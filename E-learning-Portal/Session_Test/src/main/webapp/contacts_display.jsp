<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.amdocs.project.model.Contact"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
</head>
<body>
	<h2 style="text-align: center">Contact Details</h2>
	<div class="container" style="width: 100%">
		<table class="table table-striped">
			<tr>
				<th>User_ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Message</th>
			</tr>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<br>
			<c:forEach items="${list}" var="contact">
				<tr>
					<td><c:out value="${contact.getUserID()}" /></td>
					<td><c:out value="${contact.getName()}" /></td>
					<td><c:out value="${contact.getEmail()}" /></td>
					<td><c:out value="${contact.getPhone()}" /></td>
					<td><c:out value="${contact.getMessage()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>