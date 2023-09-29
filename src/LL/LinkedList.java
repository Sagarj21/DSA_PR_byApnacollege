package LL;

import org.w3c.dom.Node;

public class LinkedList {

	public static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	public static Node head;
	public static Node tail;
	public static int size;
	//add first
	public void addFirst(int data) {//O(1)
		//st1 create new node
		Node newNode=new Node(data);
		size++;
		if(head==null) {
			head=tail=newNode;
			return;
		}				
		//step2 newNode next=head
		newNode.next=head;
		//st3 newNOde=head
		head=newNode;
	}
	
	//addlast
	public void addLast(int data) {//O(1)
		//st1 create new node
		Node newNode=new Node(data);
		size++;
		if(head==null) {
			head=tail=newNode;
			return;
		}
		//st2 tail.next=newNode
		tail.next=newNode;
		//st3 newnode= tail
		tail=newNode;
	}
	
	//print ll
	public void printLL(){
		if(head==null) {
			System.out.println("empty");
			return;
		}
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println();
	}
	
	//add in middle
	public void add(int index,int data) {
		if(index==0) {
			addFirst(data);
			return;
		}
		
		Node newNode=new Node(data);
		size++;
		Node temp=head;
		int i=0;
		while(i<index-1) {
			temp=temp.next;
			i++;
		}
		//i=index-1 then temp->prev
		newNode.next=temp.next;
		temp.next=newNode;
	}
	
	
	//remove first
	public int removeFirst() {
		if(size==0) {
			System.out.println("ll is empty");
			return Integer.MIN_VALUE;
		}else if(size==1) {
			int val=head.data;
			head=tail=null;
			size=0;
			return val;
		}
		int val=head.data;
		head=head.next;
		size--;
		return val;
	}
	
	public int removeLast() {
		if(size==0) {
			System.out.println("ll is empty");
			return Integer.MIN_VALUE;
		}else if(size==1) {
			int val=head.data;
			head=tail=null;
			size=0;
			return val;
		}
		
		//prev: i=size-2
		Node prev=head;
		for (int i = 0; i < size-2; i++) {
			prev=prev.next;
		}
		int val=prev.next.data;
		prev.next=null;
		tail=prev;
		size--;
		return val;
	}
	
	//search  iteravtive linear
	public int search(int key) {//O(n) 
		int index=0;
		Node temp=head;
		while(temp.next!=null) {
			if(temp.data==key) {
				return index;
			}
			temp=temp.next;
			index++;
		}
		//key not found
		return -1;
	}
	
	
	public int helper(Node head,int key){
		if(head==null)
			return -1;
		if(head.data==key) {
			return 0;
		}
		int index=helper(head.next,key);
		if(index==-1) {
			return -1;
		}
		return index+1;
	}
	//search recursive linear search
	public int recSearch(int key) {
		return helper(head,key);
	}
	
	//reverse
	public void reverse(){
		Node prev=null;
		Node curr=tail=head;;
		Node next;
		
		while(curr !=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev; 
	}
	
	//delete nth from end
	public void deleteNthFromEnd(int n) {
		//calculate size of LL
		int sz=0;
		Node temp=head;
		while(temp!=null) {
			temp=temp.next;
			sz++;
		}
		if(n==sz)//n is head
		{
			head=head.next;
			return;
		}
		//sz-n
		int i=1;
		int iToFind=sz-n;
		Node prev=head;
		while(i< iToFind) {
			prev=prev.next;
			i++;
		}
		prev.next=prev.next.next;
		return;
		
	}
	
	//check LL is palindrome or not
	//slow-fast apporach
	public Node findMid(Node head) {
		Node slow=head;
		Node fast=head;
		
		while(fast!=null && fast.next!=null) {
			slow=slow.next;//+1
			fast=fast.next.next;//+2
		}
		return slow;//slow is my mid node
	}
	
	public boolean isPalindrome(){
		if(head==null && head.next==null) {
			return true;
		}
		//st-1 find mid
		Node midNode=findMid(head);
		
		//st-2 reverse 2nd half
		Node prev=null;
		Node curr=midNode;
		Node next;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		
		Node right=prev;//right half head
		Node left=head;
		
		//sst-3ncheck left half and right half
		while(right!=null) {
			if(left.data != right.data) {
				return false;
			}
			left=left.next;
			right=right.next;
		}
		return true;
	}
	
	//detect loop or cycle in LL
	public static boolean isCycle() {//Floyds cycle finding algorithm
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				return true;
			}
		}
		return false;
	}
	
	//remove cycle from LL
	public static void removeCycle() {
		//detect loop
		Node slow=head;
		Node fast=head;
		boolean cycle=false;
		while(fast!=null && fast.next!=null) {
			if(slow==fast) {
				cycle=true;
				break;
			}
		}
		if(cycle == false) {
			return;
		}
		
		//find meeting point
		slow=head;
		Node prev=null;//last node
		while(slow!=fast) {
			prev=fast;
			slow=slow.next;
			fast=fast.next;
		}
		
		//remove cycle -> last.next=null
		prev.next=null;
	}
	
	//MergeSort on LL
	private Node getMid(Node head) {
		Node slow=head;
		Node fast=head.next;
		
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;//mid node
	}
	private Node merge(Node head1,Node head2) {
		Node mergedLL=new Node(-1);
		Node temp=mergedLL;
		while(head1!=null && head2!=null) {
			if(head1.data<=head2.data) {
				temp.next=head1;
				head1=head1.next;
				temp=temp.next;
			}else{
				temp.next=head2;
				head2=head2.next;
				temp=temp.next;
			}
		}
		while(head1!=null) {
			temp.next=head1;
			head1=head1.next;
			temp=temp.next;
		}
		while(head2!=null) {
			temp.next=head2;
			head2=head2.next;
			temp=temp.next;
		}
		return mergedLL.next;
	}
	//MergeSort on LL
	public Node mergeSort(Node head){
		if(head==null || head.next==null) {
			return head;
		}
		
		//find mid
		Node mid=getMid(head);
		
		//left and right MS
		Node rightHead=mid.next;
		mid.next=null;
		Node newLeft= mergeSort(head);
		Node newRight= mergeSort(rightHead);
		
		//merge
		return merge(newLeft,newRight);
	}
	
	//zig-zag pattern in LL
	public void zigZag() {
		//1find mid
		Node slow=head;
		Node fast=head.next;
		
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		Node mid=slow;
		//2 reverse 2nd half
		Node curr=mid.next;
		mid.next=null;
		Node prev=null;
		Node next;
		
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		Node left=head;
		Node right=prev;
		Node nextL,nextR;
		
		//3alternate merging
		while(left!= null && right!=null) {
			nextL=left.next;
			left.next=right;
			nextR=right.next;
			right.next=nextL;
			
			left=nextL;
			right= nextR;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList ll=new LinkedList();
		
		ll.addFirst(1);
		ll.addLast(3);
		ll.addLast(3);
		ll.addLast(1);
		ll.addLast(3);
		ll.addLast(3);
		ll.addLast(1);
		ll.printLL();
		ll.zigZag();
		ll.printLL();
	}

}
 