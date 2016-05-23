package parser2;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;

//import parsing.PadParichay;

public class SanskritParser1 
{
	private String inputStatement;
	//private String inputStatement1;
	private String outputStatement;
	private char lastPunct;
	public SanskritParser1()
	{
		inputStatement="boo";
		lastPunct='|';
	}
	public String startSanskritParser1(String inputStatement)
	{
		this.inputStatement=inputStatement;
		NounDFA1 obNoun=new NounDFA1();
		VerbDFA obVerb=new VerbDFA();
		correct();	
		if(checkWordCount())
		{
			//if ==3
			outputStatement=inputStatement;
			checkOrder(obNoun,obVerb);
		}else 
		{
			//System.err.println("Right now Grammer Checker is available for only three words please restart the program;");
			outputStatement="Right now Grammer Checker is available for only three words please restart the program";
		}
		//System.out.println(inputStatement);
		//System.out.println("Corrected Statement:"+inputStatement+" "+lastPunct);
		
		
		
		return outputStatement;
	}
	void checkOrder(NounDFA1 obNoun,VerbDFA obVerb)
	{
		String w1=obNoun.start(word(1));
		String w2=obNoun.start(word(2));
		int w3=obVerb.start(word(3));
		/*
		 * 
		 * System.out.println(w1+"\n"+w2+"\n"+w3);
		 *
		 */
		
		//for x1 & x2 1-Subject 2-object 3-valid for both 0-its neither of these
		int x1=processSubjectObject(w1);
		int x2=processSubjectObject(w2);
		//for x3  0-not verb & 1-verb
		int x3=processVerb(w3);
		//System.out.println(x1+"\n"+x2+"\n"+x3);
		if(x1*x2*x3==0)
		{
			if(x1==0)
				outputStatement+="\n\t Error: First Word is invalid(not a Subject)";
			if(x2==0)
				outputStatement+="\n\t Error: Second Word is a invalid(not an Object)";
			if(x3==0)
				outputStatement+="\n\t Error: Third Word is invalid(not a Verb)";
		}
		if(x1==x2 && x1==1)
		{
			outputStatement+="\n\t Error: two Subjects cannot be used in one statement";
		}
		if(x1==x2 && x1==2)
		{
			outputStatement+="\n\t Error: two Objects cannot be used in one statement";
		}
		if(x1==3)
		{
			outputStatement+="\n\t Warning: First Word can be used as both Subject as well as object ";
		}
		if(x2==3)
		{
			outputStatement+="\n\t Warning: First Word can be used as both Subject as well as object ";
		}
		
		if(x1==1 && x2==2 && x3==1)
		{
			outputStatement+="\n\t Perfect!! ";
		}
			
	}
	int processVerb(int outpv)
	{
		if(outpv==0)
			return 0;
		else
			return 1;
		
	}
	int processSubjectObject(String outp)
	{
		String s[]=outp.split("/");
		int flagSub=0;
		int flagObj=0;
		int returnVal=0;
		//System.out.println("bhoomer"+s[0]+"leo"+((Integer.parseInt(s[0])/10)%10));
		for(int i=0;i<s.length;i++)
		{
			int x=((Integer.parseInt(s[i])/10)%10);
			if(x==1)
				flagSub=1;
			if(x==2)
				flagObj=1;
		}
		switch(flagObj+flagSub)
		{
		case 0: 
			returnVal=0;
			break;
		case 1:
			if(flagSub==1)
				returnVal=1;
			if(flagObj==1)
				returnVal=2;
			break;
		case 2:
			returnVal=3;
			break;
		default: returnVal=0;
		}
		return returnVal;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			SanskritParser1 obj=new SanskritParser1();
			//System.out.println(obj.startSanskritParser1(br.readLine()));
			System.out.println(obj.startSanskritParser1("पठः पन् कथ"));
			//int choice=br.readLine();
			int choice=1;//1 Noun //Verb
			System.out.println("WordParichay");
			System.out.println(obj.startWordPadParichay("पठः",choice));
			System.out.println("SentenceParichay");
			System.out.println(obj.startSentencePadParichay("पठः पन् कथ"));
		}	
	public String startWordPadParichay(String inputStatement,int x)
	{
		this.inputStatement=inputStatement;
		NounDFA1 obNoun=new NounDFA1();
		VerbDFA obVerb=new VerbDFA();
		if(correct1())
		{
			switch(x)
			{
			case 1:
				String wN=obNoun.start(word(1));
				//int xN=processSubjectObject(wN);
				padParichayNoun(word(1),Integer.parseInt(wN));
				break;
			case 2:
				int wV=obVerb.start(word(1));
				//int xV=processVerb(wV);
				padParichayVerb(word(1),wV);
				break;
			default:
				//System.out.println("Please enter a correct choice for the input word");
				outputStatement="Please enter a correct choice for the input word";
			}
		}
		else
		{
			//System.out.println("Please enter only a single word");
			outputStatement="Please enter a correct choice for the input word";
		}
		return outputStatement;
	}
	public String startSentencePadParichay(String inputStatement)
	{
		this.inputStatement=inputStatement;
		NounDFA1 obNoun=new NounDFA1();
		VerbDFA obVerb=new VerbDFA();
		correct();	
		if(checkWordCount())
		{
			//if ==3
			//System.out.println("corrected statement:"+inputStatement+" "+lastPunct);
			outputStatement=inputStatement;
			sentencePadParichay(obNoun,obVerb);
		}else 
		{
			//System.out.println("Right now Grammer Checker is available for only three words please restart the program;");
			outputStatement="Right now Grammer Checker is available for only three words please restart the program";
		}
		//System.out.println(inputStatement);
		return outputStatement;
	}
	void sentencePadParichay(NounDFA1 obNoun,VerbDFA obVerb)
	{
		String w1=obNoun.start(word(1));
		String w2=obNoun.start(word(2));
		int w3=obVerb.start(word(3));
		//System.out.println(w1+"\n"+w2+"\n"+w3);
		
		//for x1 & x2 1-Subject 2-object 3-valid for both 0-its neither of these
		//int x1=processSubjectObject(w1);
		//int x2=processSubjectObject(w2);
		//for x3  0-not verb & 1-verb
		//int x3=processVerb(w3);
		padParichayNoun(word(1),Integer.parseInt(w1));
		padParichayNoun(word(2),Integer.parseInt(w2));
		padParichayVerb(word(3),w3);
	}
		
		private void correct()
		{
			inputStatement=inputStatement.trim();
			//System.out.println(inputStatement);
			char lastCh=inputStatement.charAt(inputStatement.length()-1);
			if(lastCh=='|'||lastCh=='?'||lastCh=='॥'||lastCh=='।')
				{savePunct(lastCh);correct();}
			//System.out.println("corrected statement:"+inputStatement);
		}
		private boolean correct1()
		{
			inputStatement=inputStatement.trim();
			//System.out.println(inputStatement);
			char lastCh=inputStatement.charAt(inputStatement.length()-1);
			if(lastCh=='|'||lastCh=='?'||lastCh=='॥'||lastCh=='।')
				{savePunct(lastCh);correct1();}
			//System.out.println("corrected statement:"+inputStatement);
			if((inputStatement.split(" ")).length==1)
				return true;
			else 
				return false;
		}
		private void savePunct(char lastCh)
		{
			lastPunct=lastCh;
			inputStatement=inputStatement.substring(0,(inputStatement.length()-1));
			/*
			lastPunct=inputStatement.charAt(inputStatement.length());
			inputStatement=inputStatement.substring(0,(inputStatement.length()-1));*/
			//System.out.println(inputStatement);
		}
		private boolean checkWordCount()
		{
			//if ()
			String s[]=inputStatement.split(" ");
		/*	for(String str:s)*/
			/*for(int i=0;i<s.length;i++)*/
			//System.out.println(s[i]);
			//System.out.println("length"+s.length);
			/*for (String retval: inputStatement.split(" "))
		         System.out.println(retval);*/
			if(s.length!=3)
				return false;
			else
				return true;
				
			
		}
		private void padParichayVerb(String rcvdVerb,int x)
		{
			//System.out.println("in ppV"+x);
			//System.out.println("word: "+rcvdVerb+"\n वचन: "+plurals(x%10)+"\n लकार: "+tense((x/100))+"\n पुरुष: "+person((x/10)%10));
			outputStatement ="word: "+rcvdVerb+"\n वचन: "+plurals(x%10)+"\n लकार: "+tense((x/100))+"\n पुरुष: "+person((x/10)%10);
		}
		private void padParichayNoun(String rcvdVerb,int x)
		{
			//System.out.println("in ppN"+x);
			//System.out.println("पद   मूलशब्द   लिंग   विभक्ति   वचन   धातु   लकार   पुरुष");
			//System.out.println("word: "+rcvdVerb+"\n  लिंग: "+gender(x/100)+"\n विभक्ति: "+kaarak((x/10)%10)+"\n वचन: "+plurals(x%10));
			outputStatement="word: "+rcvdVerb+"\n  लिंग: "+gender(x/100)+"\n विभक्ति: "+kaarak((x/10)%10)+"\n वचन: "+plurals(x%10);
		}
		private String gender(int x)
		{
			//System.out.println("in gender"+x);
			switch(x)
			{
			case 1:
			case 2:
			case 3:
				return "पुल्लिंग";
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				return "स्त्रीलिंग";
			case 9:
				return "नपुंसकलिंग";
				default :return "batao";
			}
		}
		private String kaarak(int x)
		{
			//System.out.println("in kaarak"+x);
			if(x==1)
				return "प्रथम विभक्ति";
			else if(x==2)
				return "द्वितीय विभक्ति";	
			else return "batao";
		}
		private String word(int a)
		{
			String s[]=inputStatement.split(" ");
			return s[a-1];
		}
		private String person(int x)
		{
			//System.out.println("in person"+x);
			if(x==1)
				return "प्रथम";
			else if(x==2)
				return "मधय्म";
			else if(x==3)
				return "उत्तम";
			else 
				return "";
		}
		private String plurals(int x)
		{
			//System.out.println("in plurals"+x);
			if(x==1)
				return  "एकवचन";
			else if(x==2)
				return "द्विवचन";
			else if(x==3)
				return "बहुवचन";
			else
				return "";
			
		}
		private String tense(int x)
		{
			switch(x)
			{
			case 1://past
				return "लड् लकार";
			case 2://present
				return "लट् लकार";
			case 3://future
				return "लृट लकार";
			}
			return "";
		}
		


}
