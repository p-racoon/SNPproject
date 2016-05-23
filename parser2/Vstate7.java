package parser2;

public class Vstate7 extends Vstate0{
	Vstate7()
	{
		
	}
	void start(char ch[],int lvl)
	{
		switch(ch[lvl])
		{
		case 2340://ta त(2340)
			if(ch[ch.length-1]==2309)
				pad=111;
			break;
		case 2344://न (2344)
			if(ch[ch.length-1]==2309)
				pad=113;
			break;
		case 2350: //म(2350) ma
			new Vstate6().start(ch,lvl+1);
			break;	
		}
	}

}
