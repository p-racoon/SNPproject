package parser2;

public class NMFState3 extends NMFState0{
	void start(char ch[],int lvl)
	{
		switch(ch[lvl])
		{
		case 2350://ma
			pad="121/911/921";
			switch(ch[lvl+1])
			{
			case 2366://bada AA
				pad="421";
				break;
			case 2367:// chhoti i
				pad="221/521";
				break;
			case 2369:// chhota u
				pad="321/721";
				break;
			case 2368://badi I
				pad="621";
				break;
			}
			break;
		case 2344:// na
			pad="123";
			if(ch[lvl+1]==2368)//badi I ki matra
				pad="223/523";
			if(ch[lvl+1]==2370)//bade U ki matra
				pad="323";
			break;
		}
		
		
	}

}
