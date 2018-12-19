package com.yanni;


public class Twilio {

    static class Node {
        int value;
        Node next;
        public Node(int val){
            this.value=val;
        }
    }

    static class NumberLinkedList {
        Node head;
        String entireNumber="";

        public void insert(Node node){
            if(head==null){
                entireNumber = entireNumber+node.value+"";
                head = node;
                return;
            }
            Node crawl = head;
            while(crawl.next!=null){
                crawl=crawl.next;
            }
            entireNumber = entireNumber+node.value+"";
            crawl.next = node;
        }

        public void cleanNodes(){
            entireNumber="";
            head.next=null;
            head=null;
        }

        public void reverseLinkedList() {
            NumberLinkedList linkedList = new NumberLinkedList();
            reverseLinkedList(head, linkedList);
//            System.out.println(linkedList.head.value);
            head = linkedList.head;
            entireNumber = linkedList.entireNumber;

        }

        public void reverseLinkedList2() {
            Node prev = null;
            Node current = head;
            Node next = null;
            while(current !=null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
            // this is just to build the entireNumber again.. the linked list has already been reversed at this point
            current = head;
            entireNumber = "";
            while(current !=null) {
                entireNumber = entireNumber+current.value+"";
                current = current.next;
            }
            System.out.println(entireNumber);
        }

        private void reverseLinkedList(Node node, NumberLinkedList list){
            if(node.next==null){
                list.insert(new Node(node.value));
                return;
            }
            reverseLinkedList(node.next, list);
            list.insert(new Node(node.value));
        }

        public void addOne(){
            Integer number = Integer.parseInt(entireNumber);
            number++;
            entireNumber = number+"";
            char[] numbers = entireNumber.toCharArray();
            cleanNodes();
            for(int i=0; i<numbers.length;i++){
                int x = Character.getNumericValue(numbers[i]);
                insert(new Node(x));
            }
        }

    }

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     * A non-negative number is expressed as a Singly Linked List. Add one to it.
     * Tests: 1→0→4 => 1→0→5, 1→9→9 => 2→0→0
     */

        public static void main(String[] args) {
            NumberLinkedList numberLinkedList = new NumberLinkedList();
            numberLinkedList.insert(new Node(1));
            numberLinkedList.insert(new Node(0));
            numberLinkedList.insert(new Node(4));
            numberLinkedList.addOne();
            System.out.println(numberLinkedList.head.value  );
            System.out.println(numberLinkedList.entireNumber  );
            numberLinkedList.reverseLinkedList();
            numberLinkedList.reverseLinkedList2();
            System.out.println(numberLinkedList.head.value);
            System.out.println(numberLinkedList.entireNumber);
        }
}