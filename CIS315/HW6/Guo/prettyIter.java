
//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.*;

public class prettyIter {

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

			
			int p = iter(matrix,M,length,list);
			System.out.println("penalty: "+p);
			outputString(0, length-1, matrix, list);		
		}			
	}
	static int iter(ArrayList<int[]> matrix, int M, int length, String[] string){
		for(int d = 1; d<length; d++){
			for(int a = 0; a<length-d; a++){
				int j= a+d;
				int num = j-a;
				for (int b = a; b<=j;b++){
					num +=string[b].length();
				}
				if (M >= num){
					if(j == length-1){
						matrix.get(a)[j] = 0;
					}else{
						int panalty = (M-num)*(M-num)*(M-num);
						if(panalty < matrix.get(a)[j]){
							matrix.get(a)[j] = panalty;
						}
					}
				}else{
					for(int k = a; k<j; k++){
						int g = matrix.get(a)[k] +matrix.get(k+1)[j];
						if(g< matrix.get(a)[j] && g>=0){
							matrix.get(a)[j]= g;
							matrix.get(j)[a]= k;
						}
					}
				}
			}
		}
		
		return matrix.get(0)[length-1];
		
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
