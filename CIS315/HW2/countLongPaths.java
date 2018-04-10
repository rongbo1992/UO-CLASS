

//import java.awt.List;
import java.util.*;

public class countLongPaths{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner data = new Scanner(System.in);
		String nextLine = data.nextLine();
		int graphNum = Integer.parseInt(nextLine);
		for(int n= 0; n < graphNum; n++){
			int g = n+1;
			System.out.println("graph number: "+ g);
			String number = data.nextLine();
			String [] graph = number.split(" ");
			//int verticeNum = Integer.parseInt(graph[0]);
			int edgeNum = Integer.parseInt(graph[1]);		
			Dictionary<Integer, Integer> dict = new Hashtable<Integer, Integer>();
			ArrayList<Integer> List = new ArrayList<Integer>();
			for(int i = 0; i < edgeNum; i++){			
				String graphData = data.nextLine();
				String [] graphList = graphData.split(" ");
				int startNode = Integer.parseInt(graphList[0]);
				int endNode = Integer.parseInt(graphList[1]);
				int edgeWeight  = Integer.parseInt(graphList[2]);
				if (startNode==1){
					dict.put(startNode, 0);
				}	
				int totalWeight = edgeWeight + dict.get(startNode);
				dict.put(endNode, totalWeight);
				List.add(totalWeight);
				//System.out.println(List);
			}
			Integer i = Collections.max(List);
			System.out.println("longest path: "+ i);			
		}			
	}
}
