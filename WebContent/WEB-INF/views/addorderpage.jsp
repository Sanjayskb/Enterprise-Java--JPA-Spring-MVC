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
<body>${orders} 
<c:url value="/saveToOrders" var="url" />
	<form:form method="GET" modelAttribute="orders" action="${url}" >
	<label>Adding for ${orders.product.product_name}</label>
	Add Quantity:<form:input path="quantity"/>
	<form:hidden path="product.product_id"/>
	
	<form:button>submit</form:button>
	</form:form>

</body>
</html>