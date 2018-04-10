package Lab3;
/* Rongbo Guo
 * CIS313 
 * Lab2
 * 
 * This is the Driver code to enter 
 * the order and run the file.
 */

import java.util.Scanner;

public class HeapDriver {
	 public static void main(String[] args)
	   {
		 Heap<Integer> h = new Heap<Integer>();
		 
	     System.out.println("Pleas input order to Bineary Search Tree(ex:insert element, findmin, removemin): ");	
  	
			do{
				Scanner input = new Scanner(System.in);
				String comment = input.nextLine();
				
				//exit for loop
				if(comment.equals("exit")){
					System.out.println("Exiting!");
					System.exit(0);			
				}else if(comment.equals("traverse")){											
				    System.out.println(h);		    
				   
				}else if(comment.equals("findmin")){//search data 			
					h.findMin();	
				}else if(comment.equals("removemin")){		
						h.removeMin();
						System.out.println("deleted successfully!");		
						System.out.println(h);
				}else{
				
				String[] split = comment.split("\\s+");
				int data = Integer.parseInt(split[1]);
				
				if(split[0].equals("insert")){//insert data
					h.insert(data);
					System.out.println( data + " was inserted successfully!") ;				
				}				
				else { 
		               System.out.println("Improper Entry, try again. \n ");  
		           }
				}

				
			}while(true);	      
		
	     /* h.insert(2);
	      h.insert(5);
	      h.insert(6);
	      h.insert(1);
	      System.out.println(h);
	      h.removeMin();
	      System.out.println(h);
	      h.findMin();*/
	   }


}


	    

