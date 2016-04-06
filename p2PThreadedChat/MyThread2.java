package p2PThreadedChat;

import java.io.*;

public class MyThread2 implements Runnable
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
			System.out.println("enter your msg:");
			s1=br.readLine();
			dos.writeUTF(s1);
			dos.flush();
		}while(!s1.equals("stop"));
		}catch(Exception e)
		{
			System.out.println("Error is in thread 2:::"+e);
		}
		
	}
}

