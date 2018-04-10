package homework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
///////////////////////////////////
////                             //
//Run the "Server" program first.//                               
//then run the "Client" program. //
////                             //
///////////////////////////////////

public class Server {
	private static final int PORT = 12345;
	
	
	
	public static void main(String[] args) {
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			//127.0.0.1
			System.out.println("IP address: " + address.getHostName());
			
			System.out.println("creating server socket");

			ServerSocket serverSocket = new ServerSocket(PORT);
			
			System.out.println("waiting for connection");
			
			Socket socket = serverSocket.accept();

			System.out.println("accepted connection");

			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			
			outputStream.writeUTF("Server says hi!");
			outputStream.flush();
			boolean flag = true;
			
			String returnMessage="";
			
			while(flag){
				//get random number
				String message = inputStream.readUTF();

				
				String[] strs=message.split(",");
				
				for (int i=0; i< strs.length; i++)
				{
					if (Integer.valueOf(strs[i])%2!=0)
					returnMessage=returnMessage+strs[i]+",";
				}
				returnMessage=returnMessage.substring(0, returnMessage.length()-1);
				
				outputStream.writeUTF(returnMessage);
				outputStream.flush();
				System.out.println("Server sent: [" + returnMessage +"]");
				flag = false;
			}
					
			inputStream.close();
			outputStream.close();
			socket.close();	
			
			System.out.println("shutting down");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
}