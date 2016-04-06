package p2PThreadedChat;

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
		new MyServer1();
	}

}
/*class MyThread1 implements Runnable
{
	DataInputStream dis;
	DataOutputStream dos;
	String str;
	MyThread1(DataInputStream dis, DataOutputStream dos)
	{
		this.dis=dis;
		this.dos=dos;
	}
	public void run()
	{
		try
		{
			do
			{
				str=dis.readUTF();
				System.out.println("Client Message="+str);
				if(str.equals("stop"))System.out.println("Termnating Connection..");
				dos.writeUTF("^Received");
				dos.flush();
			}while(str.equals("stop"));	
		}catch(Exception e)
		{
			System.out.println("Error is i thread 1:::"+e);
		}
		
		
	}
}*/
/*class MyThread2 implements Runnable
{
	DataInputStream dis;
	DataOutputStream dos;
	String s1;
	MyThread2(DataInputStream dis, DataOutputStream dos)
	{
		this.dis=dis;
		this.dos=dos;
	}
	public void run()
	{
		try
		{
			do
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			s1=br.readLine();
			dos.writeUTF(s1);
			dos.flush();
		}while(s1.equals("stop"));
		}catch(Exception e)
		{
			System.out.println("Error is in thread 2:::"+e);
		}
		
	}
}
*/