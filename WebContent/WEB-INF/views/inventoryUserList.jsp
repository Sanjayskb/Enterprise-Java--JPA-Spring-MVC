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
			<th>Inventory id</th>
			<th>Product id</th>
			<th>Product name</th>
			<th>Count </th>
			<th>Add to order </th>
		
		</tr>

		<c:forEach items="${list}" var="inventorydetail">
			<tr>
				<td><c:out value="${inventorydetail.inventory_id}" /></td>
				<td><c:out value="${inventorydetail.product.product_name}" /></td>
				<td><c:out value="${inventorydetail.product.product_id}" /></td>
				<td><c:out value="${inventorydetail.count}" /></td>
				<c:url value="/addtoorder/${inventorydetail.product.product_id}" var="aurl" />
<td><a href="${aurl}">Add to order</a></td>
				

			</tr>
		</c:forEach>
	</table>
	<br>
	<c:url value="/updateInventory" var="url" />
<%-- 	<form:form method="GET" modelAttribute="inventory" action="${url}" > --%>
<%-- 	Inventory Id:<form:input path="Inventory_id"/> --%>
<%-- 	Product Id:<form:input path="product.product_id"/> --%>
<%-- 	Count:<form:input path="count"/> --%>
	
<%-- 	<form:button>submit</form:button> --%>
<%-- 	</form:form> --%>
</body>
</html>