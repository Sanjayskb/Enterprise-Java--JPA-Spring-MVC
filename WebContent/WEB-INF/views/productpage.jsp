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
	<c:url value="/updateproduct" var="url" />
	<form:form method="GET" modelAttribute="product" action="${url}" >
<%-- 	Product Name:<form:input path="product_id"/> --%>
	Product Name:<form:input path="product_name"/>
	Product detail:<form:input path="product_detail"/>
	Product price:<form:input path="product_price"/>
	<form:hidden path="supplier.supplier_id" />
	<form:hidden path="product_id" />
	<form:button>submit</form:button>
	</form:form>
</body>
</html>