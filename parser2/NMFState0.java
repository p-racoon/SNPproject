package parser2;

public class NMFState0 extends Nstate0{
	void start(char ch[],int lvl)
	{
		switch(ch[lvl])
		{
		case 2307:// : (2307)
			pad="111";
			new NMFState1().start(ch,lvl+1);
			break;
		case 2380://bade O au ki matra
			pad="112/122";
			new NMFState2().start(ch,lvl+1);
			break;
		case 2381://halant (2381)
			new NMFState3().start(ch,lvl+1);
			break;
		case 2350://ma
		case 2344://na
			new NMFState3().start(ch,lvl);
			break;
			//matras from state 1
		case 2375://chhote ae ki matra
			pad="412/422/912/922";
			break;
		case 2368://badi ii ki matra
			pad="212/222/512/522/611";
			break;
		case 2370://bade U ki matra
			pad="312/322/712/722";
			break;
		case 2366://bade AA ki matra
			pad="411";
			break;
		default:pad="0";
		}
		
	}

}
