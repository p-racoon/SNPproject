package parser2;

public class NNState0 extends Nstate0{
	void start(char ch[],int lvl)
	{
		switch(ch[lvl])
		{
		case 2367://chhoti i
			pad="211/221";
			new NNState1().start(ch,lvl+1);
			break;
		case 2368://badi I
			new NNState2().start(ch,lvl+1);
			break;
		case 2369:
			pad="311/321";
			break;
		//default:pad="0";
		}
	}

}
