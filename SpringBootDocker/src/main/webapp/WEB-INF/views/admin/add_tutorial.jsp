<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import spring supplied form tags lib to use form binding --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="tutorial">
		<table style="background-color: lightgrey; margin: auto">

			<tr>
				<td>Name</td>
				<td><form:input path="tutorialName" /></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><form:input path="author" /></td>
			</tr>
			<tr>
				<td>Visits</td>
				<td><form:input type="number" path="visits" /></td>
			</tr>
			<tr>
				<td>Publish Date</td>
				<td><form:input type="date" path="publishDate" /></td>
			</tr>
			<tr>
				<td>Contents</td>
				<td><form:textarea path="contents" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add New Tutorial" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>