package App;

import java.text.SimpleDateFormat;
import java.util.Date;

import Interface.IJournal;

public class PrintInScreen_Date_Source  implements IJournal {
	public String getDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return format.format(new Date(System.currentTimeMillis()));
	}
	public String getNameThisClass(){
		Class<?> enclosingClass = getClass().getEnclosingClass();
		String nameClass="";
		if (enclosingClass != null) {
			nameClass = enclosingClass.getName();
		} else {
			nameClass = getClass().getName();
		}
		return nameClass;
	}
	@Override
	public void outPut_Msg(String message) {
		System.out.println(getDate() +" " +getNameThisClass() + " : " + message);
	}
}