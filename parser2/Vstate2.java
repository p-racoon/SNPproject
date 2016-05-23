package parser2;

public class Vstate2 extends Vstate0{
	void start(char ch[],int lvl)
	{
		switch(ch[lvl])
		{
		case 2336://THa ठ(2336)
			if(ch[ch.length-1]==2309)
				pad=121;
			break;
		case 2340://त(2340)
			pad=212;///81 59 67  ठिष्य without Th
			if(ch.length>=6 &&ch[lvl+1]==2351 && ch[lvl+2]==2381 && ch[lvl+3]==2359 && ch[lvl+4]==2367)
				pad=312;
			break;
		case 2341://th थ
			pad=222;
			if(ch.length>=6 && ch[lvl+1]==2351 && ch[lvl+2]==2381 && ch[lvl+3]==2359 && ch[lvl+4]==2367)
				pad=322;
			break;
		case 2357://व(2357)
			if(ch[lvl+1]==2366)// bada aa A ki matra
				pad=232;
			if(ch.length>6 && ch[lvl+1]==2366 && ch[lvl+2]==2351 && ch[lvl+3]==2381 && ch[lvl+4]==2359 && ch[lvl+5]==2367)
				pad=332;
			break;
		case 2350://म(2350) ma
			if(ch[lvl+1]==2366)// bada aa A ki matra
				pad=233;
			if(ch.length>6 && ch[lvl+1]==2366 && ch[lvl+2]==2351 && ch[lvl+3]==2381 && ch[lvl+4]==2359 && ch[lvl+5]==2367)
				pad=333;
			break;
		}
	}
}
