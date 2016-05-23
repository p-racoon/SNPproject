package ftpSanskritServer;
//import java.awt.*;
//import javax.swing.*;
import java.io.*;
import java.net.*;
import parser2.*;

public class FileReceiver {
	Socket s;
	ServerSocket ss;
	DataInputStream dis,dis1;
	PrintWriter pw;
	public FileReceiver()
	{
		try
		{
			ss=new ServerSocket(12);
			s=ss.accept();
			dis=new DataInputStream(s.getInputStream());
			String s2=dis.readUTF();
			System.out.println("receiving");
			FileWriter fo=new FileWriter(s2);
			pw=new PrintWriter(fo);
			fileReceiver();
		}
		catch(Exception e)
		{
			System.out.println(e+"bn");
		}
	}
	public void fileReceiver()
	{
		String str="";
		try
		{
			do
			{
				str=dis.readUTF();
				System.out.println("input from file is:"+str);
				SanskritParser1 ob=new SanskritParser1();
				String s1=ob.startSanskritParser1(str);
				System.out.println(s1);
				pw.println(str);
				pw.flush();
			}while(!str.equals(null));
		}
		catch(Exception e)
		{
			System.out.println(e+"boo");
		}
		//return str;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileReceiver();
	}

}
