package com.yanni.test.snapchat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SnapChatInterview2 {
    @Test
    public void test1() {

        Tasks myTasks = new Tasks();
        //root node == c
        myTasks.root = new Node(1);
        myTasks.root.runTime = 1;
        Node nodeA = new Node(1);
        Node nodeB = new Node(2);
        myTasks.root.children.add(nodeA);
        myTasks.root.children.add(nodeB);
        System.out.println(myTasks.getTotalRunTime());
        assert(myTasks.getTotalRunTime()==3);
    }

    @Test
    public void test2() {

        Tasks myTasks = new Tasks();
        //root node == c
        myTasks.root = new Node(1);
        myTasks.root.runTime = 1;
        Node nodeA = new Node(10);
        Node nodeB = new Node(2);
        myTasks.root.children.add(nodeA);
        myTasks.root.children.add(nodeB);
        System.out.println(myTasks.getTotalRunTime());
        assert(myTasks.getTotalRunTime()==11);
    }
}


class Node {
    public Node (Integer runTime) {
        this.runTime = runTime;
    }
    Integer runTime;
    List<Node> children = new ArrayList<>();

}


class Tasks {

    Node root;

    public Integer getTotalRunTime() {

        //System.out.println(getTotalRunTime(root.children, 0));
        Integer totalRunTime = root.runTime + getTotalRunTime(root.children, 0);
        return totalRunTime;
    }

    public Integer getTotalRunTime(List<Node> children, Integer totalRunTime) {
        if (children==null || children.isEmpty()) {
            return totalRunTime;
        }

        for(Node child : children) {
            if(totalRunTime==0){
                totalRunTime = child.runTime;
            } else if (totalRunTime < child.runTime) {
                totalRunTime = child.runTime;
            }
            totalRunTime =  getTotalRunTime(child.children, totalRunTime);
        }
        return totalRunTime;

    }


}