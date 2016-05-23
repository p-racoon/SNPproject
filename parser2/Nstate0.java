package parser2;

public class Nstate0 {
	static String pad;
	String startParse(char ch[],int lvl)
	{
		/*switch(ch[lvl])
		{
		case 2307://:(2307)
			new Nstate1().start(ch[],lvl+1);
			break;
		case 2307://:(2307)
			new Nstate2().start(ch[],lvl+1);
			break;
		case 2381://:(2307)
			new Nstate3().start(ch[],lvl+1);
			break;
		case 2381://:(2307)
		case 2381:
			new Nstate3().start(ch[],lvl+1);
			break;
		default:
				
		}*/
		pad="";
		new NMFState0().start(ch,lvl);
		new NNState0().start(ch,lvl);
		return pad;
	}
}
