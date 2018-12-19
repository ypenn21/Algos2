package com.yanni;
        /* Java program to show the insertion operation
 * of Unrolled Linked List */
import java.util.Scanner;
import java.util.Random;

// class for each node 
class UnrollNode {
    UnrollNode next;
    int num_elements;
    int array[];

    // Constructor 
    public UnrollNode(int n)
    {
        next = null;
        num_elements = 0;
        array = new int[n];
    }
}

// Operation of Unrolled Function 
class UnrollLinkList {

    private UnrollNode start_pos;
    private UnrollNode end_pos;

    int size_node;
    int nNode;

    // Parameterized Constructor 
    UnrollLinkList(int capacity)
    {
        start_pos = null;
        end_pos = null;
        nNode = 0;
        size_node = capacity + 1;
    }

    // Insertion operation 
    void Insert(int num)
    {
        nNode++;

        // Check if the list starts from NULL 
        if (start_pos == null) {
            start_pos = new UnrollNode(size_node);
            start_pos.array[0] = num;
            start_pos.num_elements++;
            end_pos = start_pos;
            return;
        }

        // Attaching the elements into nodes 
        if (end_pos.num_elements + 1 < size_node) {
            end_pos.array[end_pos.num_elements] = num;
            end_pos.num_elements++;
        }

        // Creation of new NodeMerge
        else {
            UnrollNode node_pointer = new UnrollNode(size_node);
            int j = 0;
            for (int i = end_pos.num_elements / 2 + 1;
                 i < end_pos.num_elements; i++)
                node_pointer.array[j++] = end_pos.array[i];

            node_pointer.array[j++] = num;
            node_pointer.num_elements = j;
            end_pos.num_elements = end_pos.num_elements / 2 + 1;
            end_pos.next = node_pointer;
            end_pos = node_pointer;
        }
    }

    // Display the Linked List 
    void display()
    {
        System.out.print("\nUnrolled Linked List = ");
        System.out.println();
        UnrollNode pointer = start_pos;
        while (pointer != null) {
            for (int i = 0; i < pointer.num_elements; i++)
                System.out.print(pointer.array[i] + " ");
            System.out.println();
            pointer = pointer.next;
        }
        System.out.println();
    }
}

/* Main Class */
class UnrolledLinkedList_Check {

    // Driver code 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // create instance of Random class 
        Random rand = new Random();

        UnrollLinkList ull = new UnrollLinkList(5);

        // Perform Insertion Operation 
        for (int i = 0; i < 12; i++) {

            // Generate random integers in range 0 to 99 
            int rand_int1 = rand.nextInt(100);
            System.out.println("Entered Element is " + rand_int1);
            ull.Insert(rand_int1);
            ull.display();
        }
    }
} 