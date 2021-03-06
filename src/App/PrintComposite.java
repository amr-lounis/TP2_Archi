package App;

import java.util.ArrayList;
import Interface.IJournal;

public class PrintComposite extends PrintInScreen_Date_Source implements IJournal{
	public ArrayList<IJournal> ListIJournal ;
	public PrintComposite(){
		ListIJournal = new ArrayList<IJournal>();
	}
	public void addPrinter(IJournal p_IJournal){
		ListIJournal.add(p_IJournal);
	}

	@Override
	public void outPut_Msg(String message) {
		for (IJournal iJournal : ListIJournal) {
			System.out.println(String.format("composit: date: %s source: %s ",getDate(),iJournal.getClass().getName() ));
			iJournal.outPut_Msg(message);
		};
	}
}