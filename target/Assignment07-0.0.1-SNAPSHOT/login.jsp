<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" href="login.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<h2>Login</h2>
	<div class="form-container">
		<form action="login" method="post">
			<table class="table table-borderless">
				<tr>
					<td><label for="username">Username <span style="color: red">*</span></label></td>
					<td><input type="text" name="username" class="form-control">
					</td>
				</tr>
				<tr>
					<td><label for="username">Password <span style="color: red">*</span></label></td>
					<td><input type="password" name="password" class="form-control"></td>
				</tr>
				<tr>
					<td><a href="#">Forgotten your password ?</a></td>
				</tr>
			</table>
			<p>
				<button type="submit" class="btn btn-secondary" value="Login">Login>></button>
			</p>
		</form>
	</div>
	<div class="error">
			<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
			%>
			<h5 style="color:red;text-align:center;"><%=error%></h5>
			<%
			}
			%>
	</div>
</body>
</html>