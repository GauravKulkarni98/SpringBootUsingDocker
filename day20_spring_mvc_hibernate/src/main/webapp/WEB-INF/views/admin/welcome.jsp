<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--importing spring supplied JSP Tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Admin Login Successful !</h5>
	<h5>Hello , ${sessionScope.user_details.name}</h5>
	<spring:url var="url" value="/admin/tutorial_list" />
	<form action="${url}" method="get">
		<table style="background-color: lightgrey; margin: auto">

			<tr>
				<td>Choose A Topic</td>
				<td><select name="topicDetails">
						<c:forEach var="topic" items="${requestScope.topic_list}">
							<option value="${topic.id}:${topic.topicName}">${topic.topicName}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td><input type="submit" value="Choose Topic" /></td>
			</tr>
		</table>
	</form>
</body>
</html>