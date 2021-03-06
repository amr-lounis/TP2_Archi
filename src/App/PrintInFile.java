package App;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import Interface.IJournal;

public class PrintInFile  implements IJournal {

	public void printInFile(String p_text,String p_path){
		try{    
	        File file =new File(p_path);      
	        if(!file.exists()){    
	            file.createNewFile();
	        }   
	        else{
	            FileWriter fileWritter = new FileWriter(file,true);        
	            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	            bufferWritter.write(p_text+"\n");
	            bufferWritter.close();
	            fileWritter.close();
	        }
	    }catch(Exception e){    
	        e.printStackTrace();    
	    }
	}
	@Override
	public void outPut_Msg(String Message) {
		System.out.println("printInFile is runing");
		printInFile(Message,"log.txt");
	}
}