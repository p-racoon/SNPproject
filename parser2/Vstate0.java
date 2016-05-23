package parser2;

public class Vstate0 {
	static int pad;
	Vstate0()
	{
		
	}
	int startParse(char ch[],int lvl){
		/*if(ch[lvl]==2357)// व(2357)
			new State1.start(ch[],lvl+1);
		if(ch[lvl]==2357)// व(2357)
			new State1.start(ch[],lvl+1);
		if(ch[lvl]==2357)// व(2357)
			new State1.start(ch[],lvl+1);
		if(ch[lvl]==2357)// व(2357)
			new State1.start(ch[],lvl+1);
		if(ch[lvl]==2357)// व(2357)
			new State1.start(ch[],lvl+1);
		if(ch[lvl]==2357)// व(2357)
			new State1.start(ch[],lvl+1);
		*/
		switch(ch[lvl])
		{
		case 2357:  // व(2357) va
			new Vstate1().start(ch,lvl+1);
			break;
		case 2307:  //ः(2307)  H
			new Vstate2().start(ch,lvl+1);
			break;
		case 2341:  // थ(2341)  tha
			new Vstate3().start(ch,lvl+1);
			break;
		case 2340:  // त(2340) ta
			new Vstate4().start(ch,lvl+1);
			break;
		case 2367:  // chhoti i इ ki maatra
			new Vstate5().start(ch,lvl+1);
			break;
		case 2350://म(2350) ma
		case 2306: //bindoo matra()
			new Vstate6().start(ch,lvl+1);
			break;
			
		/*case 2381:
			if(ch[lvl+1]==2350)
				new State6.start(ch,lvl+2);//म् aadha ma
			else if(ch[lvl+1]==2340)
				new State4.start(ch,lvl+2);//त् aadha ta
			break;*/
		case 2381:// (2381)halant aadha
			new Vstate7().start(ch,lvl+1);
			break;
			//specials
		case 2344:
			new Vstate7().start(ch,lvl);//we dont move the pointer
		default:
				return 0;
		}
		return pad;
		
	}
}
