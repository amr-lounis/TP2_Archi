package Data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import Interface.IDB;
import Model.Etudiant;

public class EtudiantRepository {
	IDB idb;
	public EtudiantRepository(IDB idb){
		 this.idb =idb;
	};
	public void add(Etudiant E) throws SQLException
	{
		String sql =String.format("INSERT into etudiant values (%d,'%s','%s','%s','%s',%d,%d,%d );",
				E.getMatricule(),E.getNom(),E.getPrenom(),E.getEmail(),E.getPwd(),E.getNbLivreMensuel_Autorise(),E.getNbLivreEmprunte(),E.getId_universite());
		int rs = idb.executeUpdate(sql);
		
		if (rs >= 1){
				System.out.println("log : ajout dans la BD réussi de l'étudiant  du Matricule :" + E.getMatricule());
			}else if (rs < 1){
				System.out.println("log : Echec de l'ajout dans la BD de l'étudiant  du Matricule :" + E.getMatricule());
			}
	 }


	public boolean Exists(String email) throws SQLException	
	{
		ArrayList<Vector<Object>> al = idb.executeQuery("select * from etudiant where email='"+ email+"'");
		if (al.size() > 1){
			System.out.println("logBD--- :email existe dans la BD  " + email);
			return true;
			}
		System.out.println("logBD--- : email n'existe pas " + email);	
		return false;
	}
	
	public boolean Exists(int mat) throws SQLException	
	{
		ArrayList<Vector<Object>> al = idb.executeQuery("select * from etudiant where matricule="+ mat);
		if (al.size() > 1){
			System.out.println("logBD--- :etudiant avec ce matricule existe déja dans la BD  " + mat);
			return true;
			}
		System.out.println("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
		return false;
	}

}
