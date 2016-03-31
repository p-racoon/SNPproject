package basicChat;

import java.io.*;
import java.net.*;
public class EchoServer {
	
	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	
	public EchoServer()
	{
		try{
			System.out.println("Server Started");
			ss= new ServerSocket(10);
			s=ss.accept();
			System.out.println(s);
			if(s!=null){
				System.out.println("Client connected s!=null");
			}
			else System.out.println("Client connected s==null");
			dis=new DataInputStream(s.getInputStream());
			dos=new DataOutputStream(s.getOutputStream());
			serverChat();
		}catch(Exception e)
		{
			System.out.println("boo"+e);
		}
	}

	public void serverChat() throws IOException{
		String str;
		do
		{
			str=dis.readUTF();
			System.out.println("Client Message="+str);
			dos.writeUTF(str);
			dos.flush();
		}while(!str.equals("bye"));
		System.out.println("à¤¬à¥�à¤† hogaya");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EchoServer();
	}

}
