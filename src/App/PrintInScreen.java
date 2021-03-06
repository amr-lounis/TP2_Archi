package App;

import Interface.IJournal;

public class PrintInScreen implements IJournal {

	@Override
	public void outPut_Msg(String message) {
		System.out.println(message);		
	}
}
