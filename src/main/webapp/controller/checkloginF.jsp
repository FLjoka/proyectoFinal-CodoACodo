<%@page import="dao.UsuarioDAOF"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String usuario = request.getParameter("email");
	String contrasenia = request.getParameter("password");
	
	//out.println(usuario);
	//out.println(contrasenia);
	
	UsuarioDAOF usuarioDAO = new UsuarioDAOF();
	Boolean usuValido = usuarioDAO.validarUsuarioYPass(usuario, contrasenia);
	
	if(usuValido) {
		response.sendRedirect("../view/pedido.jsp");
	} else {
		response.sendRedirect("../view/loginError.html");
		out.println("<p style='color:red'>Usuario o password incorrectos</p>");
	}
		
	
	%>

</body>
</html>