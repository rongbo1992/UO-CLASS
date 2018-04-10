package homework;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int produce = 1;
		while(true){
			System.out.println("Enter a positive integer (-1 to quit, -2 to print, -3 to reset): ");		
			int x = scanner.nextInt();	
			if(x>=0){
				int output = produce *x;
				produce = output;			
			}			
			//when x equal -1, print produce and exit the while loop.
			if(x==-1){
				System.out.println("produce: "+produce);
				System.exit(0);		
			}
			//when x equal -2, print produce.
			if(x==-2){
				System.out.println("produce: "+produce);
			}
			//when x equal -3, we reset the produce.
			if(x==-3){
				produce = 1;
			}
		    //if x smaller than -3 do nothing!!
		    /*if(x<-3){
				
			}*/
		}
	}
}
