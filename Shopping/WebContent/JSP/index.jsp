<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <form action="view.obj" method="post"> -->
<h1>Product Management System</h1>
	<table border="1">
		<tr>
			<th>product_id</th>
			<th>product_name</th>
			<th>product_price</th>
			<th>product_quantity</th>
			<th>Description</th>
			<th>Action</th>

		</tr>
		<c:forEach var="shop" items="${list}">
			<tr>
				<td>${shop.productId}</td>
				<td>${shop.productName}</td>
				<td>${shop.productPrice}</td>
				<td>${shop.productQuantity}</td>
				<td>${shop.description}</td>
				<td><a href="delete.obj?productId=${shop.productId}">delete</a></td>
				</tr>
				</c:forEach>
				</table>
`


</body>
</html>