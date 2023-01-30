<%@page import="dao.PedidoDAOF"%>
<%@page import="model.PedidoF"%>
<%@page import="java.math.BigInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta charset="utf-8">
 	 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  	<title>Estado de pedido</title>

  <!-- Bootstrap core CSS -->
  <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<%

	String nombre = request.getParameter("firstName");
	String apellido = request.getParameter("lastName");
	String usuario = request.getParameter("username");
	String mail = request.getParameter("email");
	String lugarentrega = request.getParameter("address");
	String localidad = request.getParameter("country");
	String provincia = request.getParameter("state");
	String codpostal = request.getParameter("zip");
	String formadepago = request.getParameter("paymentMethod");
	String tarjtitular = request.getParameter("cc-name");
	Long tarjnumero= Long.valueOf(request.getParameter("cc-number"));
	String tarjvto = request.getParameter("cc-expiration");
	String tarjclave = request.getParameter("cc-cvv");

	PedidoF pedidoF = new PedidoF(nombre, apellido, usuario,mail, lugarentrega, Integer.valueOf(localidad), Integer.valueOf(provincia), codpostal, formadepago, tarjtitular, tarjnumero, tarjvto, Integer.valueOf(tarjclave));
	
	PedidoDAOF pedidoDAOF = new PedidoDAOF();
	Boolean guardoOk = pedidoDAOF.guardarPedido(pedidoF);

	if(guardoOk){
		out.println("<h2 class='mt-3 mx-2'>El pedido se guardó exitosamente</h2>");
		out.println("<a href='../index.html' class='mt-3 mx-2 text-primary'>Regresar al inicio</a>");
		System.out.println(pedidoDAOF);
	}else{
		out.println("<h3 class='mt-3 mx-2'>Ocurrio un error en el guardo del pedido</h3>");
		out.println("<a href='../index.html' class='mt-3 mx-2'>Regresar al inicio</a>");

	}

%>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>