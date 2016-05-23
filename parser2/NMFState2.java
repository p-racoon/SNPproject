package parser2;

public class NMFState2 extends NMFState0{
	void start(char ch[],int lvl)
	{
		switch(ch[lvl])
		{
		case 2380:// bade aU ki matra
			pad="112/122";
			if(ch[lvl+1]==2351)//ya
				pad="612/622";
			break;
		}
		
		
	}
}
