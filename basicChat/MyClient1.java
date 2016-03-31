
package basicChat;

/**
 * @author PrAshesh
 *
 */
import java.io.*;
import java.net.*;

public class MyClient1 {

	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	public MyClient1(){
		try{
			//s=new Socket("10.10.0.3",10); <-- this i just a andom IP
			//..............^IP Address,^ Port no.
			//s=new Socket("192.168.1.225",10)  <-- this kind of IP is waht we generally get to see
			s= new Socket("localhost",10); //<-- meaning will search for it in the system hosted servers
			System.out.println(s);
			din = new DataInputStream(s.getInputStream());
			dout= new DataOutputStream(s.getOutputStream());
			clientChat();
		}
		catch(Exception e){
			System.out.println("BOO"+e);
		}
	}
	public void clientChat() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s1="";
		do{
			s1=br.readLine();
			dout.writeUTF(s1);
			dout.flush();
			System.out.println("Server Message:"+din.readUTF());
		}while(!s1.equals("bye"));
		System.out.println("à¤¬à¥�à¤† hogaya Client");
	}
	public static void main(String... args) {
		// TODO Auto-generated method stub
		new MyClient1();
	}

}
