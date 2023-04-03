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
			<th>Product id</th>
			<th>product name</th>
			<th>product detail</th>
			<th>product price</th>
			<th>supplier Name</th>
			<th>Add to inventory</th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach items="${list}" var="productdetail">
			<tr>
				<td><c:out value="${productdetail.product_id}" /></td>
				<td><c:out value="${productdetail.product_name}" /></td>
				<td><c:out value="${productdetail.product_detail}" /></td>
				<td><c:out value="${productdetail.product_price}" /></td>
				<td><c:out value="${productdetail.supplier.supplier_name}" /></td>
				<c:url value="/deleteproduct/${productdetail.product_id}" var="durl" />
				<c:url value="/updateproductpage/${productdetail.product_id}" var="uurl" />
				<c:url value="/updateproductinventorypage/${productdetail.product_id}" var="aurl" />
<td><a href="${durl}">Delete </a></td>
<td><a href="${uurl}">Update </a></td>
<td><a href="${aurl}">Add to Inventory</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<c:url value="/saveproduct" var="url" />
<%-- 	<c:url value="/updateproduct" var="url" /> --%>
	<form:form method="GET" modelAttribute="product" action="${url}" >
<%-- 	Product Name:<form:input path="product_id"/> --%>
	Product Name:<form:input path="product_name"/>
	Product detail:<form:input path="product_detail"/>
	Product price:<form:input path="product_price"/>
	<form:hidden path="supplier.supplier_id" />
	<form:button>submit</form:button>
	</form:form>
</body>
</html>