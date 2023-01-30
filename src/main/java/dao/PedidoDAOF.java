package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataBase.ConexionDB;
import model.PedidoF;

public class PedidoDAOF {
	public Boolean guardarPedido(PedidoF pedido) {
		try {
			ConexionDB conexionDB = new ConexionDB();
			Connection connection = conexionDB.establecerConexion();
			Statement statement = connection.createStatement();
			
			String sql = new String();
			sql = "INSERT INTO pedidos (`nombre`, `apellido`, `usuario`, `mail`, `lugarentrega`, `localidad`, `provincia`, `codpostal`, `formadepago`, `tarjtitular`, `tarjnumero`, `tarjvto`, `tarjclave`)"
					+ " VALUES (" + 
					"'" + pedido.getNombre() + "',"
					+ "'" + pedido.getApellido() + "',"
					+ "'" + pedido.getUsuario() + "',"
					+ "'" + pedido.getMail() + "',"
					+ "'" + pedido.getLugarEntrega() + "',"
					+ "'" + pedido.getLocalidad() + "',"
					+ "'" + pedido.getProvincia() + "',"
					+ "'" + pedido.getCodPostal() + "',"
					+ "'" + pedido.getFormaDePago() + "',"
					+ "'" + pedido.getTarjTitular() + "',"
					+ "'" + pedido.getTarjNumero() + "',"
					+ "'" + pedido.getTarjVto() + "',"
					+ "'" + pedido.getTarjClave() + "'"					
					+ ")";
			
			statement.execute(sql);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
		// TODO Auto-generated method stub

	}
	
	public List<PedidoF> listarPedido() {
	try {
		ConexionDB conexionDB = new ConexionDB();
		Connection connection = conexionDB.establecerConexion();
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("SELECT * FROM pedidos");
		
		List<PedidoF> listPedido = new ArrayList<PedidoF>();
		while(resultSet.next()) {
			PedidoF pedidoF = new PedidoF(
					resultSet.getInt("idpedido"), 
					resultSet.getString("nombre"),
					resultSet.getString("apellido"),
					resultSet.getString("usuario"),
					resultSet.getString("mail"),
					resultSet.getString("lugarentrega"),
					resultSet.getInt("localidad"),
					resultSet.getInt("provincia"),
					resultSet.getString("codpostal"),
					resultSet.getString("formadepago"),
					resultSet.getString("tarjtitular"),
					resultSet.getLong("tarjnumero"),
					resultSet.getString("tarjvto"),
					resultSet.getInt("tarjclave")
					);
			listPedido.add(pedidoF);
		}
		return listPedido;
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;

	}
}
