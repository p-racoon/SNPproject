package p2pThreadedMChat2;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import p2PThreadedChat.ServerStart;

public class FileTransfer extends JFrame implements ActionListener {
	JFrame jf;
	JButton jb1,jb2;
	TextField tf;
	JFileChooser jfc;
	Socket s;
	DataInputStream dis;
	DataOutputStream dout,dout1;
	String s1=new String();
	String s2="";
	File f;
	JLabel jl;
	FileTransfer()
	{
		jf=new JFrame("File Transfer");
		jf.setSize(400, 400);
		Container c=jf.getContentPane();
		c.setBackground(Color.red);
		jf.setLayout(null);
		jb1=new JButton("choose file");
		jb2=new JButton("send");
		jb1.setBounds(30, 50, 100, 50);
		jb2.setBounds(250, 150, 70, 50);
		jf.add(jb1);
		jf.add(jb2);
		tf=new TextField();
		tf.setEditable(false);
		tf.setBackground(Color.white);
		tf.setBounds(150,50,190,50);
		jf.add(tf);
		//jf.setDefaultCloseOperation(WindowsConstant.EXIT_ON_CLOSE);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		jfc=new JFileChooser();
		jfc.setVisible(true);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}
	public void fileTransfer(String s1)
	{
		try
		{
			dout.writeUTF(s1);
			dout1.flush();
			s2=f.getAbsolutePath();
			FileReader fr=new FileReader(s2);
			BufferedReader br=new BufferedReader(fr);
			String s3="";
			do
			{
				s3=br.readLine();
				if(s3!=null)
				{
					dout.writeUTF(s3);
					dout.flush();
				}
			}while(s3!=null);
			br.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jb1)
		{
			int x=jfc.showOpenDialog(null);
			if(x==JFileChooser.APPROVE_OPTION)
			{
				f=jfc.getSelectedFile();
				String path=f.getPath();
				s1=f.getName();
				tf.setText(path+"\\"+s1);
			}
			//jb1.setName("stop");
			jf.setTitle("hoq");
		}
		if(e.getSource()==jb2)
		{
			try
			{
				//s1=tf.getText();
				InetAddress IP=InetAddress.getLocalHost();
				System.out.println("IP of my system is := "+IP.getHostAddress());
				s=new Socket("localhost",12);
				dout1=new DataOutputStream(s.getOutputStream());
				dout=new DataOutputStream(s.getOutputStream());
				
			}catch(Exception E)
			{
				System.out.println("Send Button"+E);
			}
			fileTransfer(s1);			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileTransfer ft=new FileTransfer();
		new FileTransfer();
		//new ServerStart(); 
	}
	
}
