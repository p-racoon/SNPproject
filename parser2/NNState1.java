package parser2;

public class NNState1 extends NNState0{
	void start(char ch[],int lvl)
	{
		switch(ch[lvl])
		{
		
		case 2344://n
			if(ch[lvl+1]==2369)//chhota u
				pad="313/323";
			if(ch[lvl+1]==2366)//bada AA
				pad="913/923";
			break;
		case 2339://ण(2339)
			pad="213/223";
			break;
		}
	}
}
