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
	<h5>Topic Id : ${sessionScope.selected_topic_id }</h5>
	<h5>Topic Name : ${sessionScope.selected_topic_name}</h5>
	<h5>List of Tutorial Names : ${requestScope.tut_list}</h5>
	<h5>
		<a
			href="<spring:url value='/admin/add_tutorial?topicId=${sessionScope.selected_topic_id}'/>">Add
			New Tutorial</a>
	</h5>
</body>
</html>