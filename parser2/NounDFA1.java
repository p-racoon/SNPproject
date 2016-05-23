package parser2;

//import java.io.IOException;

public class NounDFA1 {

	/*public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		//code
		NounDFA1 obj=new NounDFA1();
		//obj
		String inputWord;
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//inputWord=br.readLine();
		inputWord="पठमी";
		String pad1=obj.start(inputWord);
		System.out.println(pad1);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns");
	}*/
	String start(String inputWord)
	{
	//inputWord.reverse();
		inputWord=new StringBuffer(inputWord).reverse().toString();
		//System.out.println(inputWord);
		char inputCharAr[]=inputWord.toCharArray();
		//int len=inputCharAr.length;
		int lvl=0;
		//new State0().start(inputCharAr,len,lvl);
		return new Nstate0().startParse(inputCharAr,lvl);
	}

}
