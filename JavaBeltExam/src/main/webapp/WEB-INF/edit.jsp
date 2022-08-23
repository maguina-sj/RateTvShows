<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit the TV Show</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>Edit the TV Show</h1>
<a href="/dashboard">Go Back to Dashboard</a>
<a href="/logout">Logout</a>
<h1>Edit TV Show</h1>
	<form:form method="put" action="/show/update/${editShow.id}" modelAttribute="editShow">
		<div class = "form-group">
		<form:label path="title">Title:</form:label>
    	<form:input path="title" class="form-control"/>
    	<form:errors class ="text-danger" path="title"/>
		</div>
		<div class = "form-group">
		<form:label path="network">Network:</form:label>
    	<form:input path="network" class="form-control"/>
    	<form:errors class ="text-danger" path="network"/>
		</div>
		<div class = "form-group">
		<form:label path="description">Description:</form:label>
    	<form:input path="description" class="form-control"/>
    	<form:errors class ="text-danger" path="description"/>
		</div>
		<!-- hidden input of user_id -->
    	<form:input type="hidden" value="${loggedInUser.id}" path="user" />
		<br/>
		<button class ="btn-primary">Edit This TV Show</button>
	</form:form>
</div>
</body>
</html>