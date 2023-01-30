package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataBase.ConexionDB;
import model.Localidad;

public class LocalidadDAOF {
	public List<Localidad> listarLocalidades() {
		try {
			ConexionDB conexionDB = new ConexionDB();
			Connection connection = conexionDB.establecerConexion();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * from localidades ORDER BY nombrelocalidad");
			
			
			List<Localidad> listaLocalidades = new ArrayList<Localidad>();
			
			while (resultSet.next()) {
				Localidad localidad = new Localidad(resultSet.getInt("idlocalidad") , resultSet.getString("nombrelocalidad"));
				listaLocalidades.add(localidad);		
			}
			return listaLocalidades;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	public Localidad bucarXId(Integer id) {
		try {
			ConexionDB conexionDB = new ConexionDB();
			Connection conn = conexionDB.establecerConexion();
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT * FROM localidades WHERE idlocalidad = " + id);
			
			Localidad localidad = null;
			
			while(resultSet.next()) {
				localidad = new Localidad(
						resultSet.getInt("idlocalidad"),
						resultSet.getString("nombrelocalidad"));
			}
			return localidad;
		} catch (Exception e) {
			e.printStackTrace();		}
		return null;
		// TODO Auto-generated method stub

	}
}

