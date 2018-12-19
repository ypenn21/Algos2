package com.yanni;/* Java program to merge two
sorted linked lists */

/* Link list node */
class NodeMerge
{ 
	int data; 
	NodeMerge next;
	NodeMerge(int d) {data = d;
				next = null;} 
} 
	
class MergeLists 
{ 
NodeMerge head;

/* Method to insert a nodeMerge at
the end of the linked list */
public void addToTheLast(NodeMerge nodeMerge)
{ 
	if (head == null) 
	{ 
		head = nodeMerge;
	} 
	else
	{ 
		NodeMerge temp = head;
		while (temp.next != null) 
			temp = temp.next; 
		temp.next = nodeMerge;
	} 
} 

/* Method to print linked list */
void printList() 
{ 
	NodeMerge temp = head;
	while (temp != null) 
	{ 
		System.out.print(temp.data + " "); 
		temp = temp.next; 
	} 
	System.out.println(); 
} 


// Driver Code 
public static void main(String args[]) 
{ 
	/* Let us create two sorted linked 
	lists to test the methods 
	Created lists: 
		llist1: 5->10->15, 
		llist2: 2->3->20 
	*/
	MergeLists llist1 = new MergeLists(); 
	MergeLists llist2 = new MergeLists(); 
	
	// NodeMerge head1 = new NodeMerge(5);
	llist1.addToTheLast(new NodeMerge(5));
	llist1.addToTheLast(new NodeMerge(10));
	llist1.addToTheLast(new NodeMerge(15));
	
	// NodeMerge head2 = new NodeMerge(2);
	llist2.addToTheLast(new NodeMerge(2));
	llist2.addToTheLast(new NodeMerge(3));
	llist2.addToTheLast(new NodeMerge(20));
	
	
	llist1.head = new Gfg().sortedMerge(llist1.head, 
										llist2.head); 
	llist1.printList(); 
	
} 
} 

class Gfg 
{ 
/* Takes two lists sorted in 
increasing order, and splices 
their nodes together to make 
one big sorted list which is 
returned. */
NodeMerge sortedMerge(NodeMerge headA, NodeMerge headB)
{ 
	
	/* a dummy first node to 
	hang the result on */
	NodeMerge dummyNode = new NodeMerge(0);
	
	/* tail points to the 
	last result node */
	NodeMerge tail = dummyNode;
	while(true) 
	{ 
		
		/* if either list runs out, 
		use the other list */
		if(headA == null) 
		{ 
			tail.next = headB; 
			break; 
		} 
		if(headB == null) 
		{ 
			tail.next = headA; 
			break; 
		} 
		
		/* Compare the data of the two 
		lists whichever lists' data is 
		smaller, append it into tail and 
		advance the head to the next NodeMerge
		*/
		if(headA.data <= headB.data) 
		{ 
			tail.next = headA; 
			headA = headA.next; 
		} 
		else
		{ 
			tail.next = headB; 
			headB = headB.next; 
		} 
		
		/* Advance the tail */
		tail = tail.next; 
	} 
	return dummyNode.next; 
} 
} 

// This code is contributed 
// by Shubhaw Kumar 
