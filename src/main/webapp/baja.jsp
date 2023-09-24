<%@ page import="bdController.BdController"%>
<%@ page import="model.User"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Baja de usuario</title>
</head>
<body>

	<style>
.Slide1691 {
	width: 1920px;
	height: 1080px;
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	background: white;
}

.Slide1691 div {
	display: flex;
	justify-content: center;
	align-items: center;
}

.list {
	width: 796px;
	height: 420px;
	left: 561px;
	top: 250px;
	position: absolute;
	background: #FFFFFF;
	padding: 20px;
	border: 1px solid #D9D9D9;
	text-align: left;
}

.form-select {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
}
</style>

	<div class="Slide1691"
		style="width: 1920px; height: 1080px; position: relative; background: white">
		<div class="Rectangle1"
			style="width: 1010px; height: 1080px; left: 455px; top: 0px; position: absolute; background: #D9D9D9"></div>
		<a href="index.html">
			<div class="Rectangle4"
				style="width: 839px; height: 67px; left: 561px; top: 141px; position: absolute; background: white"></div>
		</a>
		<div class="Rectangle7"
			style="width: 839px; height: 67px; left: 561px; top: 739px; position: absolute; background: white"></div>
		<a href="index.html">
			<div class="GestiNDeClientes"
				style="left: 773px; top: 145px; position: absolute; color: black; font-size: 48px; font-family: Inter; font-weight: 400; word-wrap: break-word">Gestión
				de clientes</div>
		</a>
		<div class="PabloMerinasSoto"
			style="left: 763px; top: 744px; position: absolute; color: black; font-size: 48px; font-family: Inter; font-weight: 400; word-wrap: break-word">Pablo
			Merinas Soto</div>

		<div class="list">
			<%
			List<User> userList = BdController.getUserList();
			if (userList.isEmpty()) {
			%>
			<p>No hay usuarios disponibles.</p>
			<%
			} else {
			%>
			<form action="SvDeleteUser" method="get">
				<label for="usuario">Selecciona un usuario:</label> <select
					name="usuario" id="usuario" class="form-select">
					<%
					for (User user : userList) {
					%>
					<option value="<%=user.getDni()%>"><%=user.getName()%>
						<%=user.getSubName()%></option>
					<%
					}
					%>
				</select>
				<button type="submit">Eliminar usuario</button>
			</form>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>
