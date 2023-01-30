package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataBase.ConexionDB;
import model.Provincia;

public class ProvinciaDAOF {
	public List<Provincia> listarProvincias(){
		try {
			ConexionDB conexionDB = new ConexionDB();
			Connection connection = conexionDB.establecerConexion();
			Statement st = connection.createStatement();
			ResultSet resultSet =st.executeQuery("SELECT * FROM provincias ORDER BY nombre");
			
			List<Provincia> listaProvincias = new ArrayList<Provincia>();
			
			while(resultSet.next()) {
				Provincia provincia = new Provincia(resultSet.getInt("idprovincia"), resultSet.getString("nombre"));
				listaProvincias.add(provincia);
			}
			return 	listaProvincias;
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
	public Provincia buscarXId(Integer id) {
		try {
			ConexionDB conexionDB = new ConexionDB();
			Connection conn = conexionDB.establecerConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM provincias WHERE idprovincia = " + id);
			
			Provincia provincia = null;
			while(rs.next()) {
				provincia = new Provincia(
						rs.getInt("idprovincia"),
						rs.getString("nombre")
						);
			}
			return provincia;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		// TODO Auto-generated method stub

	}
}
