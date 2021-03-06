package App;

import java.text.SimpleDateFormat;
import java.util.Date;

import Interface.IJournal;

public class PrintInScreen_Date_Source  implements IJournal {
	protected String getDate(){
		SimpleDateFormat format = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
		return format.format(new Date(System.currentTimeMillis()));
	}
	@Override
	public void outPut_Msg(String message) {
		System.out.println(getDate() +" " +this.getClass().getName() + " : " + message);
	}
}