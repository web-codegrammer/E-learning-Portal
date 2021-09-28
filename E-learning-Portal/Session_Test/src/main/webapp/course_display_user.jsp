<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.amdocs.project.model.Course"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h2 style="text-align: center">My Course Details</h2>
	<div class="container" style="width: 100%">
		<table class="table table-striped">
			<tr>
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Course Resource</th>
				<th>Course Description</th>
				<th>Course Fee</th>
			</tr>
			<br>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<c:forEach items="${list}" var="course">
				<tr>
					<td><c:out value="${course.getCourseID()}" /></td>
					<td><c:out value="${course.getCourseName()}" /></td>
					<td><c:out value="${course.getCourseResource()}" /></td>
					<td><c:out value="${course.getCourseDesc()}" /></td>
					<td><c:out value="${course.getCourseFee()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<div class="container" style="text-align: center">
		<h2 style="text-align: center">Enroll to New Course</h2>
		<form action="UserCourseServlet" method="get">
			Course ID: <input type="number" name="id"> <br> <br>
			<input type="submit" value="Enroll">
		</form>
	</div>
</body>
</html>