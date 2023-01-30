<%@page import="com.mysql.jdbc.Blob"%>
<%@page import="dao.UsuarioDAOF"%>
<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String usuario = request.getParameter("user");
	String contrasenia = request.getParameter("pass");
	String nombre = request.getParameter("name");
	String apellido = request.getParameter("lastName");
	
	Usuario usu = new Usuario(usuario, contrasenia);
	
	UsuarioDAOF usuarioDAOF = new UsuarioDAOF();
	
	Boolean okGuardado = usuarioDAOF.guardarUsuarioOk(usu);
	
	   if (okGuardado) {
	        out.println("El usuario se agregó correctamente <br>");
	    } else {
	        out.println("Error en agregar usuario <br>");
	    }	
	%>

</body>
</html>