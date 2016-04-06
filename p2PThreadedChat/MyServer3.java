package p2PThreadedChat;

import java.io.*;
import java.net.*;
public class MyServer3 {
	
	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	
	
	public MyServer3()
	{
		try{
			System.out.println("Server Started");
			/*ss= new ServerSocket(10);
			s=ss.accept();*/
			s=new Socket("localhost",10);
			System.out.println(s);
			System.out.println("Client connected ");
			dis=new DataInputStream(s.getInputStream());
			dos=new DataOutputStream(s.getOutputStream());
			//serverChat();
			startThreads(dis,dos);
		}catch(Exception e)
		{
			System.out.println("boo "+e);
		}
	}
	public void startThreads(DataInputStream dis, DataOutputStream dos)
	{
		Runnable r1=new MyThread1(dis,dos);
		Runnable r2=new MyThread2(dis,dos);
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();
		System.out.println("thread 1 started");
		t2.start();
		System.out.println("thread 2 started");
	}
	/*public void serverChat() throws IOException{
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
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyServer3();
	}

}

