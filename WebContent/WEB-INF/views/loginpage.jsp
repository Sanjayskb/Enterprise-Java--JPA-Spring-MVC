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
<c:url value="/loginuser" var="url" />
	<form:form method="GET" modelAttribute="user" action="${url}" >
	Email:<form:input path="email"/>
	Password:<form:input path="password"/>
	Select <input type="radio" name="usertype" value="supplier" checked="checked">supplier
	<input type="radio" name="usertype" value="user">user
	<form:button>submit</form:button>
	</form:form>
</body>
</html>