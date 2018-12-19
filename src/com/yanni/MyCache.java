package com.yanni;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MyCache extends TimerTask{

    class MyNode {
        public MyNode(int value){
            this.value = value;
            createdTime = new Date().getTime();
        }

        int value;
        long createdTime;
        MyNode left; //should be prev and next not left and right
        MyNode right;

    }

     public MyCache(){
         timer.schedule(this, 3000, 3000);
     }

    @Override
    public void run() {
        cleanNodes();
    }

    Map<Integer, MyNode> cached = new ConcurrentHashMap();

     MyNode start;
     MyNode end;
     private static final Timer timer = new Timer(true);
     private static final Integer MAX_NODES = 4;
     private static final Long TIME_TO_LIVE = new Long (100000);

    public void cleanNodes() {
//        while(true) {
            long current  = new Date().getTime();
            for (Map.Entry<Integer, MyNode> cachedEntry : cached.entrySet()){
                long lived = current - cachedEntry.getValue().createdTime;
                if ( (lived) > TIME_TO_LIVE) {
                    System.out.println("REMOVED :"+cachedEntry.getValue().value);
                    cached.remove(cachedEntry.getKey());
                }

            }
//        }

    }

     // get entry puts the node at the top again since we have accessed it.
    public MyNode getNode(Integer key) {
        MyNode entry = cached.get(key);
        if(entry!=null) {
            entry.createdTime = new Date().getTime();
            removeNode(entry);
            insertAtTop(entry);
            return entry;
        }else {
            return null;
        }
    }

     public void putNode(Integer value) {
        if(cached.containsKey(value)) {
            MyNode node = cached.get(value);
            node.createdTime = new Date().getTime();
            removeNode( node );
            insertAtTop( node );
        } else {
            MyNode insertNode = new MyNode(value);
            cached.put(value, insertNode);
            if(MAX_NODES< cached.size()){
                removeNode( end );
                cached.remove(end.value);
            }
            insertAtTop(insertNode);
        }

     }

     private void insertAtTop(MyNode node) {
        node.right = start;
        node.left = null;
        if(start!=null){
            start.left = node;
        }
        start = node;
        if(end == null) {
            end = node;
        }
         System.out.println("put at top"+node.value);
     }

     //don't use directly to remove only removes from linked list not map
     private void removeNode(MyNode node) {
        if(node.left!=null)
            node.left.right = node.right;
        else{
            start = node.right;
        }

        if(node.right!=null)
            node.right.left = node.left;
        else
            end = node.left;
         System.out.println("remove"+node.value);
     }

    public void removeNodeFromListNMap(MyNode node) {
        removeNode(node);
        cached.remove(node.value);
    }

    public static void main(String[] args) {
        try {
            MyCache myCache = new MyCache();
            myCache.putNode(5);
            myCache.putNode(4);
            MyNode node4 = myCache.getNode(4);
            myCache.putNode(3);
            myCache.putNode(2);
            myCache.putNode(1);
            Thread.sleep(1000);
//            MyNode node1 = myCache.getNode(1);
            myCache.removeNodeFromListNMap(node4);
//            myCache.putNode(1);
//            timer.schedule(myCache, 3000, 3000);

//            Thread.sleep(TIME_TO_LIVE * 10);
        } catch (InterruptedException ex) {
        }
        System.out.println("finished");
    }

    abstract class Super {
        Number aNumber;
    }

    class Sub extends Super {
        Float aNumber;
    }


}