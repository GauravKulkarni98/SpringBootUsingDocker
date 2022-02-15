<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Welcome 2 Spring Boot....</h5>
	<h5>
		<a href="<spring:url value='/user/login'/>">User Login</a>
	</h5>
	<h5>
		<a href="<spring:url value='/products'/>">Test ResponseBody Annotation</a>
	</h5>
	<h5>
		<a href="<spring:url value='/products/123/oil/200/2022-05-12'/>">Test PathVariable Annotation</a>
	</h5>

</body>
</html>