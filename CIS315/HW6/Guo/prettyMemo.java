//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.*;

public class prettyMemo{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//File file = new File("/Users/robolike/Desktop/test.txt");
		
		Scanner data = new Scanner(System.in);
		String nextLine = data.nextLine();
		int graphNum = Integer.parseInt(nextLine);
		for(int n= 0; n < graphNum; n++){
			String Maxnumber = data.nextLine();
			int M = Integer.parseInt(Maxnumber);
			String string = data.nextLine();
			String [] list = string.split(" ");
			int length = list.length;
			ArrayList<int[]> matrix = new ArrayList<int[]>(length);
			for(int i = 0; i<length;i++){
				int num;
				if (i == length-1){
					num = 0;
				}else{
				num = (M-list[i].length())*(M-list[i].length())*(M-list[i].length());
						
				}
				int[] fill = new int[length];
				for (int j = 0; j< length; j++){
					fill[j]= Integer.MAX_VALUE;
				}
				fill[i]= num;
				matrix.add(fill);		
			}

			
			
			int p = memo(matrix,M, 0, length-1, length, list);
			System.out.println("penalty: "+p);
			outputString(0, length-1, matrix, list);		
		}			
	}
	static int memo(ArrayList<int[]> matrix, int width, int start, int end, int array_length, String[] string){
		int num = end-start;
		for (int i = start; i <= end; i++){
			num += string[i].length();
		}
		
		if (num <= width){
			if (end == array_length - 1){
				matrix.get(start)[end] = 0;
			}else{
				int temp = (width-num)*(width-num)*(width-num);
				if (temp <= matrix.get(start)[end]){
					//System.out.println("aaa");
					matrix.get(start)[end] = temp;
				}
			}
		}else{
			for (int i = start; i < end; i++){
				if (matrix.get(start)[i] == Integer.MAX_VALUE){
					matrix.get(start)[i] = memo(matrix,width,start,i,array_length,string);
				}
				if (matrix.get(i+1)[end] == Integer.MAX_VALUE){
					matrix.get(i+1)[end] = memo(matrix, width, i+1, end, array_length, string);
				}
				int temp = matrix.get(start)[i] + matrix.get(i+1)[end];
				if (temp <= matrix.get(start)[end]){
					matrix.get(start)[end] = temp;
					matrix.get(end)[start] = i;
				}
			}
		}
		return matrix.get(start)[end];
		
	}
	static void outputString(int s, int e, ArrayList<int[]> matrix, String[] string){
		if(matrix.get(e)[s]== Integer.MAX_VALUE){
			for(int i = s; i < e; i++){
				System.out.print(string[i]+" ");
				
			}
			System.out.println();
		}else{
			outputString(s, matrix.get(e)[s], matrix, string);
			outputString(matrix.get(e)[s]+1, e, matrix, string);			
		}
		
	}
}
