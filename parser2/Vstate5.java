package parser2;

public class Vstate5 extends Vstate0{
	Vstate5()
	{
		
	}
	void start(char ch[],int lvl)
	{
		switch(ch[lvl])
		{
		case 2340://त(2340)
			pad=211;///81 59 67  ठिष्य without Th
			if(ch.length>=4 && ch[lvl+1]==2351 && ch[lvl+2]==2381 && ch[lvl+3]==2359)
				pad=311;
			if(ch.length>4 && ch[lvl+1]==2381 && ch[lvl+2]==2344)
				pad=213;
			if(ch.length>7 && ch[lvl+1]==2381 && ch[lvl+2]==2344 && ch[lvl+3]==2351 && ch[lvl+4]==2381 && ch[lvl+5]==2359)
				pad=313;
			break;
		case 2350://म(2350) ma
			if(ch[lvl+1]==2366)// bada aa A ki matra
				pad=231;
			if(ch.length>6 && ch[lvl+1]==2366 && ch[lvl+2]==2351 && ch[lvl+3]==2381 && ch[lvl+4]==2359 && ch[lvl+5]==2367)
				pad=331;
			break;
		case 2360://स(2360)
			pad=221;
			if(ch.length>6 && ch[lvl+1]==2351 && ch[lvl+2]==2381 && ch[lvl+3]==2359 && ch[lvl+4]==2367)
				pad=321;
			break;
		}
	}

}
