package parser2;

public class Vstate1 extends Vstate0{
	Vstate1()
	{
		
	}
	void start(char ch[],int lvl)
	{
		/*switch(ch[lvl])
		{
		case :
			break;
		default:	
		}*/
		pad=0;
		if(ch[ch.length-1]==2309)//va व 2357
		{
			pad=132;
		}
			/*bade A aa ki matra(2366) and अ(2309)*/
	}
}
