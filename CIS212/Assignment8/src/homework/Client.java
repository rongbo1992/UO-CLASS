package homework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
////////////////////////////////////
//                                //
// Run the "Server" program first.//                               
// Then run the "Client" program. //
//                                //
////////////////////////////////////

public class Client {
	private static final int PORT = 12345;
     
	
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			Socket socket = new Socket(address, PORT);

			System.out.println("connected!");
			
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			
			String message = inputStream.readUTF();
			
			System.out.println("Client received: " + message + ""); 
				
			boolean flag1 = true;
			
			while(flag1)
			{
				
			boolean flag = true;
			String steam="";
			
			Scanner input=new Scanner(System.in);
			
			do
		
			{
				System.out.println("Enter a number, blank line to quit:");
				
				String value=input.nextLine();
				
				
				if(value==null || "".equals(value))
				{
					flag=false;
				}
				if(value == "exist"){
					flag1 = false;
				}
				else
				{
					if(isNumber(value))
					{
						steam=steam+value+",";
					}
					
				}
			}
			while(flag);

			flag=true;
			
			
			steam=steam.substring(0, steam.length()-2);

			outputStream.writeUTF(steam);
			outputStream.flush();
			System.out.println("Client sent: [" + steam +"]" );
			
			String revString = inputStream.readUTF();
			System.out.println("Client received: [" + revString + "]");

			}	
			inputStream.close();
			outputStream.close();
			socket.close();			
			System.out.println("shutting down");		
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static boolean isNumber(String str)
	{
		for(int i=0; i<str.length(); i++)
		{
			if(!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
}
