package p2PThreadedChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class MyThread1 implements Runnable
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
				//dos.writeUTF("^Received");
				//dos.flush();
			}while(!str.equals("stop"));	
		}catch(Exception e)
		{
			System.out.println("Error is i thread 1:::"+e);
		}
		
		
	}
}
