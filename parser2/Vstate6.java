package parser2;

public class Vstate6 extends Vstate0{
	Vstate6()
	{
		
	}
	void start(char ch[],int lvl)
	{
		/*
		 * we are not taking if-else approach bcoz 
		 * it has a dhaatu linked with it and that
		 * needs to be checked with all possible values
		 */
		pad=0;
		if(ch[ch.length-1]==2309)
		{
			pad=131;
		}
		if(ch[lvl]==2366)// bade A aa ki matra(2366)
		{
			if(ch[lvl+1]==2340 && ch[ch.length-1]==2309)//त(2340)
				pad=112;
			else if(ch[ch.length-1]==2309)
				pad=133;
		}
		if(ch[lvl]==2340 && ch[ch.length-1]==2309)//त(2340)
		{
			pad=122;
		}
		
	}

}
