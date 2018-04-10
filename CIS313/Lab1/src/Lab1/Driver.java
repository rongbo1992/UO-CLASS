package Lab1;
/*
 *The class if testing my stack and queue classes
 */

import java.util.Scanner;

public class Driver {

    public static String inputString(){
        // return the string we are input
        try {
        	Scanner inputNumber =  null;
            System.out.println("Please enter string: ");
            inputNumber = new Scanner(System.in);
            return  inputNumber.nextLine(); 
        } catch (IndexOutOfBoundsException e) {
        	System.err.println("IndexOutOfBoundsException: Plese Enter the string");
        }
		return null;
    }


    public boolean is_Palindrome(String str){
    	//To determine that the string is Palindrome is true or false
    	Queue q = new Queue();
    	Stack s = new Stack();
        for (char c:str.toCharArray()) {
            s.push(new Node(c)); 
            q.enqueue(new Node(c));
        }
        str = str.replaceAll("\\W", " ");
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (s.pop().data != q.dequeue().data) {
                return false;             
            }
		}
        return true;
    }
    
    
    public static void main(String[] args){
        String string = inputString();
        System.out.println("It is true or false "+ string + " is palindrome?: " + new Driver().is_Palindrome(string));
    }
}
