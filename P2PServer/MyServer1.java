package P2PServer;

import java.io.*;
import java.net.*;
public class MyServer1 {
	
	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	
	public MyServer1()
	{
		try{
			System.out.println("Server Started");
			ss= new ServerSocket(10);
			s=ss.accept();
			System.out.println(s);
			System.out.println("Client connected ");
			dis=new DataInputStream(s.getInputStream());
			dos=new DataOutputStream(s.getOutputStream());
			serverChat();
		}catch(Exception e)
		{
			System.out.println("boo "+e);
		}
	}

	public void serverChat() throws IOException{
		String str,s1;
		do
		{
			str=dis.readUTF();
			System.out.println("Client Message="+str);
			dos.writeUTF("^Received");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			s1=br.readLine();
			dos.writeUTF(s1);
			dos.flush();
		}while(!(s1.equals("bye")));
		System.out.println("बुआ hogaya");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyServer1();
	}

}
