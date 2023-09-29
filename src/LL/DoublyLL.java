package LL;

public class DoublyLL{

	public class Node{
		int data;
		Node next;
		Node prev;
		
		public Node(int data) {
			this.data=data;
			this.next=null;
			this.prev=null;
		}
	}
	
	public static Node head;
	public static Node tail;
	public static int size;
	
	
	//addfirst	
	public  void addFirst(int data) {
		Node newNode=new Node(data);
		size++;
		if(head==null) {
			head=tail=newNode;
			return;
		}
		newNode.next=head;
		head.prev=newNode;
		head=newNode;
	}
	
	//removefirst
	public int removeFirst() {
		int val=head.data;
		if(head==null) {
			System.out.println("empty");
			size=0;
			return Integer.MIN_VALUE;
		}
		if(size==1) {
			head=tail=null;
			size=0;
			return head.data;
		}
		
		
		head=head.next;
		head.prev=null;
		size--;
		return val;
	}
	
	//print
	public void print() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"<->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	
	//reverse
	public void reverse() {
		Node curr=head;
		Node prev=null;
		Node next;
		
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			curr.prev=next;
			prev=curr;
			curr=next;
		}
		head=prev;
	}
	
	
	
	public static void main(String[] args) {

		DoublyLL ll=new DoublyLL();
		ll.addFirst(3);
		ll.addFirst(2);
		ll.addFirst(1);
		ll.print();
		ll.reverse();
		ll.print();
		System.out.println(ll.size);

	}

}
