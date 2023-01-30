package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataBase.ConexionDB;
import model.Usuario;

/**
 * Clase DAO consentra todo las modificaciones y altas en la tabla usuarios de la bd
 * @author franco
 *
 */

public class UsuarioDAOF {
	/**
	 * 
	 * 
	 * @param usuario emial ingresado
	 * @param clave password ingresado
	 * @return
	 */
	public Boolean validarUsuarioYPass(String usuario,String clave) {
		try {
			ConexionDB conexionDB = new ConexionDB();
			Connection connection = conexionDB.establecerConexion();
			Statement statement = connection.createStatement();
			
			String sql = new String("SELECT * FROM usuarios WHERE usuario = '"+ usuario.trim()+"' AND clave='"+clave.trim()+"'"); 
			ResultSet resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
				return true;
			}
			else {
				return false;
			}
			
		}catch (Exception e) {
			e.getStackTrace();
			return false;
					
		}
		

	}
	
	public Boolean guardarUsuarioOk(Usuario usuario) {
		try {
			ConexionDB conexionDB = new ConexionDB();
			Connection connection = conexionDB.establecerConexion();
			Statement statement = connection.createStatement();
			
			
			String sql = new String();
			sql = "INSERT INTO usuarios(`usuario`, `clave`)" + " VALUES (" 
			+ "'" + usuario.getUsuario() + "',"
			+ "'" + usuario.getClave() + "')";
			
			
			statement.executeUpdate(sql);
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
