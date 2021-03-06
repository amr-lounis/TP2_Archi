package App;

import Data.DBConnection;
import Data.EtudiantRepository;
import Data.UniversiteRepository;

public class MainApp {

	public static void main(String[] args) {
		try {
			DBConnection db = DBConnection.getInstanceDB();
			
			EtudiantRepository er =new EtudiantRepository(db);
			er.Exists(1);
			
			UniversiteRepository ur = new UniversiteRepository(db);
			System.out.println(ur.GetById(1).getNom());
			
			PrintComposite pc =new  PrintComposite();
			pc.addPrinter(new PrintInScreen());
			pc.addPrinter(new PrintInScreen_Date_Source());
			pc.addPrinter(new PrintInFile());
			pc.outPut_Msg("this comosite patren ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
