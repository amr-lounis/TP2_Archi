package App;

import java.util.ArrayList;
import Interface.IJournal;

public class PrintComposite implements IJournal{
	public ArrayList<IJournal> ListIJournal ;
	public PrintComposite(){
		ListIJournal = new ArrayList<IJournal>();
	}
	public void addPrinter(IJournal p_IJournal){
		ListIJournal.add(p_IJournal);
	}

	@Override
	public void outPut_Msg(String message) {
		System.out.println("composit : " + message);
		for (IJournal iJournal : ListIJournal) {
			iJournal.outPut_Msg(message);
		};
	}
}