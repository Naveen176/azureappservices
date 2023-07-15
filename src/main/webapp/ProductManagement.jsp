<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.nagarro.assignment07.productmanagement.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product page</title>
<link rel="stylesheet" href="productManagementTool.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<br>
	<h2>PRODUCT MANAGEMENT TOOL</h2>
	<h5>
		Hi ${user.getUsername()}
		<button type="submit" class="btn btn-secondary"
			onclick="location.href='LogoutServlet'">Logout</button>
	</h5>
	<div class="form-container">
		<h4>Please enter product details to add to stock</h4>
		<form action="insertData" method="post">
			<table class="table table-borderless">
				<tr>
					<td><label for="title">Title</label></td>
					<td><input type="text" name="title" class="form-control" value='${productDetails.title}' ></td>
				</tr>
				<tr>
					<td><label for="quantity">Quantity</label></td>
					<td><input type="number" name="quantity" class="form-control" value='${productdetails.quantity}' ></td>
				</tr>
				<tr>
					<td><label for="size">Size</label></td>
					<td><input type="number" name="size" class="form-control" value='${productdetails.size}'></td>
				</tr>
				<tr>
					<td><label for="image">Image</label></td>
					<td><input type="url" name="image" class="form-control" value='${productdetails.image}'></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-secondary">Save</button>
		</form>
	</div>
	<div class="productDetails">
		<%
		Session newSession = HibernateUtil.getSessionFactory().openSession();
		%>
		<%
		String query = "FROM ProductDetails";
				List<ProductDetails> productDetails = newSession.createQuery(query).list();
		%>
		<table class="table table-bordered ">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Title</th>
					<th>Quantity</th>
					<th>Size</th>
					<th>Image</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (ProductDetails user : productDetails) {
				%>
				<tr>
					<td><%=user.getId()%></td>
					<td><%=user.getTitle()%></td>
					<td><%=user.getQuantity()%></td>
					<td><%=user.getSize()%></td>
					<td><img alt="" style="max-height: 200px;max-width:200px; width:100%;" src="<%=user.getImage()%>" ></td>
					<td>
						<button type="submit" class="btn btn-secondary" onclick="location.href='DeleteRecord?title=<%=user.getTitle()%>'">delete</button>&nbsp;
						<button type="submit" class="btn btn-secondary" onclick="location.href='EditRecord?title=<%=user.getTitle()%>'">edit</button>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>