<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="solid">
		<tr>
			<th>order ID</th>
			<th>Product id</th>
			<th>User ID</th>
			<th>Quantity</th>
			<th>Amount</th>
		</tr>

		<c:forEach items="${list}" var="orderdetail">
			<tr>
				<td><c:out value="${orderdetail.order_id}" /></td>
				<td><c:out value="${orderdetail.product.product_id}" /></td>
				<td><c:out value="${orderdetail.users.user_id}" /></td>
				<td><c:out value="${orderdetail.quantity}" /></td>
				<td><c:out value="${orderdetail.amount}" /></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>