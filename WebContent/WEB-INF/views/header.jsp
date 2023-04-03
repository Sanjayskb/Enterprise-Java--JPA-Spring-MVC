<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<c:url value="/resources/mystyle.css" var="mycss" />
	<link href="${mycss}" rel="stylesheet">
</head>
<body>
	<c:url value="/resources/images/headerimg.png" var="headerlogo" />
	<img src="${headerlogo}" alt="Website Logo"
		style="height: 60px; width: 30%;">
	<h1>Inventory Management System</h1>


</body>
</html>