<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TV Show Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>Welcome <c:out value="${loggedInUser.name}"/></h1>
<a href="/show/new">Add a new show</a>
<a href="/logout">Logout</a>
<table class="table table-striped">
<thead>
<tr>
<th>Title</th>
<th>Network</th>
<th>Average Rating</th>

</tr>
</thead>
<c:forEach items="${shows}" var="show">
	<tr>
		<td><a href="/show/details/${show.id}">${show.title}</a></td>
		<td>${show.network}</td>
		<td>${show.getAverageRating()}</td>
	</tr>	
	</c:forEach>
</table>
</div>
</body>
</html>