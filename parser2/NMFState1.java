package parser2;

public class NMFState1 extends NMFState0{
	void start(char ch[],int lvl)
	{
		pad="111";
		switch(ch[lvl])
		{
		
		case 2370:// bade U ki matra
			pad="723";
			break;
		case 2369:// chhote u ki matra
			pad="311/711";
			break;
		case 2366:// bde AA ki matra
			pad="113/413/423";
			break;
		case 2367://chhoti i ki matra
			pad="211/511/623";
			break;
		case 2351://ya
			pad="213/513/613";
			break;
		case 2357://va
			pad="313/713";
			break;
		}
		
		
	}

}
