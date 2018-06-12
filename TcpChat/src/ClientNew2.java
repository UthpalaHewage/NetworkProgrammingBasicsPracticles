import java.net.*;
import java.io.*;


public class ClientNew2 {
	
	public static void main(String[] args) throws Exception {
		
		Socket sock = new Socket("127.0.0.1", 3000);
		System.out.println("client");
		
		// reading from keyboard (keyRead object)
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
		
		// sending to client (pwrite object)
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);
		
		// receiving from server ( receiveRead object)
		InputStream istream = sock.getInputStream();
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
		
		System.out.println("Start the chat, type and press Enter key");
		String receiveMessage, sendMessage;
		
		while (true) {
			sendMessage = keyRead.readLine(); // keyboard reading
			pwrite.println(sendMessage); // sending to server
			pwrite.flush(); // flush the data
			if ((receiveMessage = receiveRead.readLine()) != null) //receive from server
			{
			System.out.println(receiveMessage); // displaying at DOS prompt
			}
		}
	}
}