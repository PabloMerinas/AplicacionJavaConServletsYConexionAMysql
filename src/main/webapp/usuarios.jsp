<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista usuarios</title>
</head>
<body>

	<h1>Lista de Usuarios:</h1>
	<ul>
		<%
		// Obtener la lista de usuarios del objeto request
		List<User> userList = (List<User>) request.getAttribute("userList");

		// Iterar a través de la lista y mostrar los nombres y apellidos
		for (User user : userList) {
		%>
		<li>Nombre: <%=user.getName()%> Apellido: <%=user.getSubName()%>
			Dni: <%=user.getDni()%> Usuario: <%=user.getUsername()%>
			Contraseña: <%=user.getPassword()%></li>
		<%
		}
		%>
	</ul>

</body>
</html>