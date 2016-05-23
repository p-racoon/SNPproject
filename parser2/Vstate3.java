package parser2;

public class Vstate3 extends Vstate0{
	Vstate3()
	{
		
	}
	void start(char ch[],int lvl) 
	{
				pad=223;
			if(ch.length>=6 && ch[lvl+1]==2351 && ch[lvl+2]==2381 && ch[lvl+3]==2359 && ch[lvl+4]==2367)
				pad=323;
	}

}
