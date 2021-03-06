package Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.util.stream.Collectors;

import Interface.IDB;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class DBConnection implements IDB {
	   
		private String BDD = "bdd";
		private String url = "jdbc:mysql://localhost:3306/";
		private String user = "root";
		private String passwd = "";
	    private Connection mConnection;
	    private static DBConnection o;
	    
	    private DBConnection(){
	    	try {
				//Class.forName("org.gjt.mm.mysql.Driver").newInstance();// in old version of jdk
				createDatabaseIfNotExist();
			} catch (Exception e) {
				System.out.println("Error Database Connect");
			}
	    }
	    
	    public static DBConnection getInstanceDB(){
	    	if (o == null)o = new DBConnection();
			return o;
		}
	    
	    @Override
		public int executeUpdate(String sql) {
			try{
				System.out.println("start executeUpdate: "+sql);
				mConnection=DriverManager.getConnection( url+BDD, user, passwd);
				Statement mStatement = (Statement) mConnection.createStatement();
				int rowsInserted = mStatement.executeUpdate(sql);
				mStatement.close();
				mConnection.close();
				return rowsInserted;
			}catch (Exception e) { {System.out.println("ERROR executeUpdate: ");} return -1;}
		}
	    @Override
		public ArrayList<Vector<Object>> executeQuery(String sql){
			ArrayList<Vector<Object>> data = new ArrayList<>();
			try{
				System.out.println("start executeQuery: "+sql);
				mConnection=DriverManager.getConnection( url+BDD, user, passwd);
				Statement mStatement = (Statement) mConnection.createStatement();
				ResultSet mResultSet = mStatement.executeQuery(sql);
				ResultSetMetaData mResultSetMetaData = (ResultSetMetaData) mResultSet.getMetaData();
	            // Names of columns
				Vector<Object> columnNames = new Vector<>();
	            int columnCount = mResultSetMetaData.getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                columnNames.add(mResultSetMetaData.getColumnName(i));
	            }
	            // Data of the table
	            data.add(columnNames);
	            while (mResultSet.next()) {
	            	Vector<Object> line = new Vector<Object>();
	                for (int i = 1; i <= columnCount; i++) {
	                	line.add(mResultSet.getObject(i));
	                }
	                data.add(line);
	            }
	            mStatement.close();
	            mConnection.close();
			}catch (Exception e) {System.out.println("ERROR executeQuery:");}
			return data;
		}
		//********************************************************************
		private void createDatabaseIfNotExist()throws Exception{
			mConnection=DriverManager.getConnection( url, user, passwd);
			ResultSet resultSet = mConnection.getMetaData().getCatalogs();
			boolean b= false;
			while (resultSet.next()) {
				  if(resultSet.getString(1).equals(BDD)){b=true;break;}
				}
			if(!b){
				String sql =ReadTextFromResource("/SQLScript.sql");
				String [] array_SQL=(sql).split(";");
				Statement mStatement = (Statement) mConnection.createStatement();
				for(int i=0;i<array_SQL.length;i++){
					mStatement.executeUpdate(array_SQL[i]+";");
				}
				mStatement.close();
				mConnection.close();
			}	
		}
		private String ReadTextFromResource(String p_path){
			try{return  new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream(p_path))).lines().
					collect(Collectors.joining("\n"));
			}catch (Exception e) {e.printStackTrace();}
			return "";
		}
		//********************************************************************
}
