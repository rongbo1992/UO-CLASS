package Lab1;
/*
 * Create a Queue
 */

public class Queue {
	private Node front = null;//first of the queue
	private Node back = null;//last of the queue
	
	public Queue(){
		
	}//default constructor
	
	public void enqueue(Node N){
		//add element to the queue
		if(isEmpty()) {front = N;}
		else{back.next = N;}
		back = N;		
	}
	
	public Node dequeue(){
		//remove the element and return 
		if(isEmpty())
			throw new RuntimeException("Can't dequene from an empty stack.");
		Node firstItem = front;
		front = front.next;
		return firstItem;
	
	}
	public boolean isEmpty(){
		//define the queue is empty or not
		return front == null;
	}

}
