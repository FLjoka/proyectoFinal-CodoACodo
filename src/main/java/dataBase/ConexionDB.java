package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConexionDB {
	private Connection conexion;
	static String bd="cacproyect0";
	static String server="jdbc:mysql://localhost:3306/" + bd + "?useSSL=false&allowPublicKeyRetrieval=true";
	static String user="root";
	static String password="clavederoot";

	
	
	public String getBd() {
		return bd;
	}


	public void setBd(String bd) {
		ConexionDB.bd = bd;
	}


	public Connection establecerConexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(server,user,password);
			return conexion;

		}
		catch(Exception e){
			System.out.println("Imposible realizar conexion con la BD");
			e.printStackTrace();
		}
		return conexion;
	}


	public void cerrarConexion(ResultSet rs){
		if(rs !=null){
			try{
				rs.close();
			}
			catch(Exception e){
				System.out.print("No es posible cerrar la Conexion");
			}
		}
	}

	public void cerrar(java.sql.Statement stmt){
		if(stmt !=null){
			try{
			stmt.close();
		}
		catch(Exception e){}
		}
	}

	public void destruir(){
		if(conexion !=null){
	
		try{
			conexion.close();
		}
		catch(Exception e){}
		}
	}

}
