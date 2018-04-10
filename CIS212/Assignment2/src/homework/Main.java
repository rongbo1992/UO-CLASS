package homework;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	//Create the java program which can input the length and density for the list
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		boolean start = false;
		int length = 0;
		double density = 0;
		do{
			System.out.println("Please array length: ");			
			try {
				length = scanner.nextInt();
				start = false;
			} catch (InputMismatchException ex) {
				System.out.println("Unparsable input. TRY AGAIN!!");				
				// call next() to flush the buffer.
				scanner.next();
				start = true;
			}			
		}while (start == true);
		
		do{
			System.out.println("Enter density: ");			
			try {
				density = scanner.nextDouble();
				start = false;
			} catch (InputMismatchException ex) {
				System.out.println("Unparsable input. TRY AGAIN!!");				
				// call next() to flush the buffer.
				scanner.next();
				start = true;
			}			
		}while (start == true);
		
		int[] list= arrayDensity(length, density);
		ArrayList<int[]> arrayList = arraySparse(length, density);
		toSparse(list);
		toDensity(arrayList);
		maxDensity(list);
		maxSparse(arrayList);
	}
	
	//create a density list
	public static int[] arrayDensity (int length, double density)
	{
		double startTime = System.nanoTime();
		int[] list = new int[length];
		Random produceRandom = new Random();
		for (int i = 0; i < length; i++){
			double number = produceRandom.nextDouble();
			if(number < density){
			    list[i] = produceRandom.nextInt(1000000) + 1;
			}
			else{
				list[i] = 0;	
			}
		}
		double usedTime = (System.nanoTime() - startTime)/1000000;
		System.out.printf ("create dense length: %s time: %s\n" ,length, usedTime);
		return list;
	}
	
	//create a sparse arrayList
	public static ArrayList<int[]> arraySparse (int length, double density)
	{
		double startTime = System.nanoTime();
		ArrayList<int[]> arrayList = new ArrayList<int[]>();
		Random produceRandom = new Random();
		for (int i = 0; i < length; i++){
			double number = produceRandom.nextDouble();
			if(number < density){			
				int[] array = new int[2];
				array[0] = i;
				array[1] = produceRandom.nextInt(1000000) + 1;
				arrayList.add(array);		
			}		
		}
		double usedTime = (System.nanoTime() - startTime)/1000000;
		System.out.printf("create sparse length: %s time: %s\n" ,arrayList.size(), usedTime);
		return arrayList;		
	}
	
	//convert a density list to sparse
	public static ArrayList<int[]> toSparse (int[] list)
	{
		double startTime = System.nanoTime();
		ArrayList<int[]> sparseArray = new ArrayList<int[]>();
		for (int i = 0; i < list.length; i++){
			if (list[i] != 0){
				int[]array = new int[2];
				array[0] = i;
				array[1] = list[i];
				sparseArray.add(array);
			}
		}
		double usedTime = (System.nanoTime() - startTime)/1000000;
		System.out.printf ("convert to sparse length: %s time: %s\n" ,sparseArray.size(), usedTime);
		return (sparseArray);		
	}
	
	//cover a sparse arrayList to density
	public static int[] toDensity (ArrayList<int[]> arrayList)
	{
		double startTime = System.nanoTime();
		int[] denseArray = new int[arrayList.size()];
		for (int i = 0; i < arrayList.size(); i++){
			denseArray[i] = arrayList.get(i)[1];	
		}
		double usedTime = (System.nanoTime() - startTime)/1000000;
		System.out.printf ("convert to dense length: %s time: %s\n" ,denseArray.length, usedTime);
		return (denseArray);		
	}
	
	//find max number from dense list
	public static void maxDensity(int[] denseArray){
		double startTime = System.nanoTime();
		int maxNumber = 0;
		int index = 0;
		for (int i = 0; i < denseArray.length; i++){
			if (denseArray[i] >maxNumber){
				maxNumber = denseArray[i];
				index = i;				
			}		
		}
		double usedTime = (System.nanoTime() - startTime)/1000000;
		System.out.printf("find max (dense): %s at: %s\ndense find time: %s\n",maxNumber,index,usedTime);	
	}
	
	//find max number from sparse arrayList
	public static void maxSparse(ArrayList<int[]> sparseArray){
		double startTime = System.nanoTime();
		int maxNumber = 0;
		int index = 0;
		for (int i = 0; i < sparseArray.size(); i++){
			if (sparseArray.get(i)[1] >maxNumber){
				maxNumber = sparseArray.get(i)[1];
				index = i;				
			}		
		}
		double usedTime = (System.nanoTime() - startTime)/1000000;
		System.out.printf("find max (sparse): %s at: %s\nsparse find time: %s\n",maxNumber,index,usedTime);	
	}	
}
