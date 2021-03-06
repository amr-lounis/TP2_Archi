package Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import Interface.IDB;
import Model.TypePackage;
import Model.Universite;

public class UniversiteRepository {
	IDB idb;
	public UniversiteRepository(IDB idb){
		 this.idb =idb;
	};
	public Universite GetById(int universityId) throws SQLException {	
		System.out.println("LogBD : d�but recherche de id universit� dans la base de donn�e");
		ArrayList<Vector<Object>> al = idb.executeQuery("select * from universite where id_universite= "+ universityId);
		
		String univName =al.get(1).get(1).toString();
		int id = (int)al.get(1).get(0);
		TypePackage pt = TypePackage.valueOf(al.get(1).get(2).toString());
		System.out.print("LogBD : universit� r�cup�r�e : ");
		Universite u = new Universite (id,univName,pt);
		return u;	
	}	
	
}
