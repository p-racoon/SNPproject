package parser2;

//import java.io.*;

public class VerbDFA {
	//static int output;
	/*public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		//code
		VerbDFA obj=new VerbDFA();
		//obj
		String inputWord;
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//inputWord=br.readLine();
		//inputWord="पठिष्यामः";
		//inputWord="अपठत";
		//inputWord="अपठम्";
		//inputWord="अपठन";//0
		/*inputWord="पठावः";
		int pad=obj.start(inputWord);
		System.out.println(pad);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns");
	}*/
	public int start(String inputWord)
	{
	//inputWord.reverse();
		inputWord=new StringBuffer(inputWord).reverse().toString();
		//System.out.println(inputWord);
		char inputCharAr[]=inputWord.toCharArray();
		//int len=inputCharAr.length;
		int lvl=0;
		//new State0().start(inputCharAr,len,lvl);
		return new Vstate0().startParse(inputCharAr,lvl);
	}
}
