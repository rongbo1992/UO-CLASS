/*
CIS 315 
Rongbo Guo
Homework 0
*/
import java.util.Scanner;

public class addMultNum {

	public static void main(String[] args){
		int sum = 0;
		int mul = 0;
		int x = 0;
		int y = 0;
		Scanner num = new Scanner(System.in);
		while(num.hasNextLine()){
			String Str = num.nextLine();
			String[] number = Str.split(" ");
			if(number.length == 2){
				x = Integer.parseInt(number[0]);
				y = Integer.parseInt(number[1]);
				sum = x+y;
				mul = x*y;
				System.out.println(sum+" "+mul);
			}else{
				
			}						
		}		
	}
}
