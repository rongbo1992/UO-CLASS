package homework;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Sorting extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static double convertToFractionalMiliSeconds(long nanoTime) 
	{
		return nanoTime / 1000000000.0;
	}

	private Container container; //define container
	private GridBagLayout layout; //define layout
	GridBagConstraints constraints;

	public JTextField selectSortTime;
	public JTextField mergeSortTime;
	
	class Input
	{	
		private int phoneNumber;
		private String userName;
		public Input(int phonenumber, String username)
		{
			phoneNumber = phonenumber;
			userName = username;
		}
		public void print(Input inp)
		{
			System.out.println(inp.phoneNumber + " " + inp.userName);
		}
		public int getPhone()
		{
			return phoneNumber;
		}
		public String getName()
		{
			return userName;
		}
		
		public String toString()
		{
			return phoneNumber + " " + userName;
		}
	}
	static ArrayList<Input> data = new ArrayList<Input>();
	private Thread selectSortThread;
	private Thread mergeSortThread;
	
	public Sorting(){
		super("Assignment 5");
		
		container = getContentPane();
		layout = new GridBagLayout();
		container.setLayout(layout);
		constraints = new GridBagConstraints();	
		
		
		JButton SelectSort=new JButton("Selection Sort");
		SelectSort.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e){
            	selectSortThread = new Thread(){
            		public void run(){
            			System.out.println("sorting...");
            			ArrayList<Input> arrayLists = copy(data);        			
            			/*for(int z=0; z<=10; z++)
            			{
            				System.out.println(arrayLists.get(z));
            			}*/            			
            			long start = System.nanoTime();
            			ArrayList<Input> sortArray = selectSort(arrayLists);            			
            			/*System.out.println("----------------------------------------------");
            			
            			for(int z=0; z<=10; z++)
            			{
            				System.out.println(sortArray.get(z));
            				} */    			
            			System.out.println("sorting finish");           			
            			double timeTaken = convertToFractionalMiliSeconds(System.nanoTime() - start);         			
            			if (sortTest(sortArray)){            				
                			String time=Double.toString(timeTaken);	
            				selectSortTime.setText(time);          				
            				System.out.println("Slection sort successful!!");
            			}
            			else{
            				System.out.println("Error");
            			}     			
            		}
            	};
            	selectSortThread.start();
            }
		});
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=1; 
		constraints.gridheight=1;
		constraints.fill=GridBagConstraints.BOTH; //fill space
		constraints.weightx=50;
		constraints.weighty=50; 		
		layout.setConstraints(SelectSort,constraints);
		container.add(SelectSort);
		
		
		selectSortTime = new JTextField("0");
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.gridwidth=1; 
		constraints.gridheight=1;
		constraints.fill=GridBagConstraints.BOTH; 
		constraints.weightx=100;
		constraints.weighty=50; 
		layout.setConstraints(selectSortTime,constraints);
		container.add(selectSortTime);
		
		JButton MergeSort=new JButton("Merge Sort");
		MergeSort.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e){
            	mergeSortThread = new Thread(){
            		public void run(){
            			System.out.println("Sorting...");
            			ArrayList<Input> arrayLists = copy(data);
            			System.out.println("Sorting finish"); 
            			long start = System.nanoTime();
            			ArrayList<Input> sortArray = mergeSort(arrayLists);
            			double timeTaken = convertToFractionalMiliSeconds(System.nanoTime() - start);
            			if (sortTest(sortArray)){        				
                			String time=Double.toString(timeTaken);	
                			mergeSortTime.setText(time);
            				System.out.println("Merge sort successful!!");
            			}
            			else{
            				System.out.println("Error");
            			}
            			
            		}
            	};
            	mergeSortThread.start();
            }
		});
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth=1; 
		constraints.gridheight=1;
		constraints.fill=GridBagConstraints.BOTH; 
		constraints.weightx=50;
		constraints.weighty=50; 		
		layout.setConstraints(MergeSort,constraints);
		container.add(MergeSort);

		
		
		mergeSortTime = new JTextField("0");
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.gridwidth=1; 
		constraints.gridheight=1;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.weightx=100;
		constraints.weighty=50; 
		layout.setConstraints(mergeSortTime,constraints);
		container.add(mergeSortTime);		
		setSize(400,200); 
		setVisible(true);
		readFile();	
	}
	
	private void readFile()
	{		
	    try 
	    {
	    	BufferedReader brFile = new BufferedReader(
	    			
	    			new FileReader("/Users/robolike/desktop/phonebook.txt"));//put the location for the file in this place
	    	
	        String line = brFile.readLine();
	        
	        while (line != null) 
	        {
	        		String[] parts=line.split(" ");
	        		parts[1]  = parts[1].replace(",", "");
	        		Input input = new Input(Integer.parseInt(parts[0]), parts[1]+ " " + parts[2]);
	        		data.add(input);
	                line = brFile.readLine();
	        }	       
	        brFile.close();
	    }
	    catch(Exception e)
	    {
	    	System.err.print("File reading error!");
	    	System.err.print(e.getMessage());
	    }
	    //System.out.println("I am done");    
	}
	
	public ArrayList<Input> selectSort(ArrayList<Input> arrayList)
	{
		int x, y, minimumIndex;
		for (x = 0; x < arrayList.size()-1 ; x++) 
		{
			minimumIndex = x;
			for (y = x + 1; y < arrayList.size(); y++) 
			{
				if (arrayList.get(y).getName().compareTo(
						arrayList.get(minimumIndex).getName()) < 0) 
				{
					//System.out.println(arrayList.get(j).getName().toString()+"<"+arrayList.get(minIndex).getName().toString()+"\n");
					minimumIndex = y;
				}
			}			
			if (minimumIndex != y)
			{
				//System.out.println(arrayList.get(i)+"\t"+arrayList.get(minIndex));			
				Input swap = arrayList.get(x);
				arrayList.set(x, arrayList.get(minimumIndex));
				arrayList.set(minimumIndex, swap);			
				//System.out.println(arrayList.get(i)+"\t"+arrayList.get(minIndex));
				//System.out.println("---------------");
			}
		}
		return arrayList;
	}

	
	public ArrayList<Input> mergeSort(ArrayList<Input> arrayList)
	{
		if (arrayList.size() <= 1) 
		{
			return arrayList;
		}
		int listSize = arrayList.size();
		ArrayList<Input> left = new ArrayList<Input>();
		ArrayList<Input> right = new ArrayList<Input>();
		int middle = listSize / 2;
		for (int i = 0; i < middle; i++) 
		{
			left.add(arrayList.get(i));
		}
		for (int i = middle; i < listSize; i++) 
		{
			right.add(arrayList.get(i));
		}
		left = mergeSort(left);
		right = mergeSort(right);
		ArrayList<Input> result = merge(left, right);
		return result;
	}
	private ArrayList<Input> merge(ArrayList<Input> left, ArrayList<Input> right)
	{
		ArrayList<Input> result = new ArrayList<Input>();
		while (left.size() > 0 || right.size() > 0) 
		{
			int leftSize = left.size(), rightSize = right.size();
			if (leftSize > 0 && rightSize > 0) 
			{
				if (left.get(0).getName().compareTo(right.get(0).getName()) < 0) 
				{
					result.add(left.get(0));
					left.remove(0);
				} 
				else 
				{
					result.add(right.get(0));
					right.remove(0);
				}
			} 
			else if (leftSize > 0) 
			{
				result.add(left.get(0));
				left.remove(0);
			} 
			else if (rightSize > 0) 
			{
				result.add(right.get(0));
				right.remove(0);
			}
	    }
		return result;	
	}
	private ArrayList<Input> copy(ArrayList<Input> arrayList)
	{
 		ArrayList<Input>  c = new ArrayList<Input>(arrayList.size());
 		for (Input input : arrayList)
 		{
 			c.add(input);
 		}
 		return c;	
	}
	public static Boolean sortTest(ArrayList<Input> arrayList)
	{
		Input firstItem = arrayList.get(0);
		int n = arrayList.size();
		for (int i = 1; i < n; i++)
		{
			if (firstItem.getName().compareTo(arrayList.get(i).getName()) <= 0)
			{
				firstItem = arrayList.get(i);
			}
			else 
			{
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) 
	{
		Sorting s = new Sorting();
		s.setResizable(true);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

