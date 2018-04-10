package Lab2;
/* Rongbo Guo
 * CIS313 
 * Lab2
 * 
 * This is the Driver code to enter 
 * the order and run the file.
 */

import java.io.IOException;
import java.util.Scanner;

public class Driver {

	
	public static void main(String[] args) throws IOException{
		
		//build a String for binary search tree
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		System.out.println("Pleas input order to Bineary Search Tree(ex:insert element, search element, delete element): ");	


		
		do{
			Scanner input = new Scanner(System.in);
			String comment = input.nextLine();
			
			//exit for loop
			if(comment.equals("exit")){
				System.out.println("Exiting!");
				System.exit(0);			
			}else if(comment.equals("traverse")){				
				bst.inOrderTraverse();				
			}else{
			
			String[] split = comment.split("\\s+");
			int data = Integer.parseInt(split[1]);
			
			

			if(split[0].equals("insert")){//insert data
				bst.insert(data);
				System.out.println( data + " was inserted successfully!") ;				
			}
			
			else if(split[0].equals("search")){//search data 			
				boolean a = bst.search(data);
				if(a==true){
					System.out.println( "Found "+ data+"!");				
				}
				else if(a==false){
					System.out.println( data+" does not exist.");
				}	
			}
			//First we use search to find data. If find, delete it. If not find, Print can't find the element.
			else if(split[0].equals("delete")){
				boolean a = bst.search(data);	
				if(a==false){
					System.out.println( data+" does not exist.");
				}
				else if(a==true){
					bst.delete(data);
					System.out.println( data+" deleted successfully!");
				}	
			}
			
			else { 
	               System.out.println("Improper Entry, try again. \n ");  
	           }
			}

			
		}while(true);	      
	}
}
