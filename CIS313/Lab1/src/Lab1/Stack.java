package Lab1;
/*
 * Create a stack
 */

public class Stack {

	//Pointer to the Node that is at the top of the stack. 
    //If top == null, then the stack is empty.
	
	private Node top = null;//top of the stack
	
	public Stack(){
		
	}//default constructor
	
	public boolean isEmpty(){
		//define the stack is empty or not
		return top == null;
	}
	
	public void push(Node N){	
		N.next = top;
		top = N;
	}
	
	public Node pop(){
		//remove the element and return it
		if (isEmpty()) 
			throw new IllegalStateException("Can't pop from an empty stack.");
		Node topItem = top;
		top = top.next;
		return topItem;	
	}

}
