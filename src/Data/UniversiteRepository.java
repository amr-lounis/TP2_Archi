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
		System.out.println("LogBD : début recherche de id université dans la base de donnée");
		ArrayList<Vector<Object>> al = idb.executeQuery("select * from universite where id_universite= "+ universityId);
		
		String univName =al.get(1).get(1).toString();
		int id = (int)al.get(1).get(0);
		TypePackage pt = TypePackage.valueOf(al.get(1).get(2).toString());
		System.out.print("LogBD : université récupérée : ");
		Universite u = new Universite (id,univName,pt);
		return u;	
	}	
	
}
