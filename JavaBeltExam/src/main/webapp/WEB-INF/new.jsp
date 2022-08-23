<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Show</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>Create a New TV Show</h1>
<a href="/dashboard">Go Back To Dashboard</a>
<a href="/logout">Logout</a>
<form:form method="POST" action="/show/create" modelAttribute="newShow">
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
		<br/>
		<button class ="btn-primary">Add This Show</button>
	</form:form>
</div>
</body>
</html>