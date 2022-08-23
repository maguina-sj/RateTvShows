<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>
			<c:out value="${tvshow.title}" />
		</h1>
		<a href="/dashboard">Back To Dashboard</a> <a href="/logout">Logout</a>
		<div class="card" style="width: 18rem;">
			<ul class="list-group list-group-flush">
				<li class="list-group-item">Posted by: <c:out
						value="${tvshow.user.name}" /></li>
				<li class="list-group-item">Network: <c:out
						value="${tvshow.network}" /></li>
				<li class="list-group-item">Description: <c:out
						value="${tvshow.description}" /></li>
			</ul>
			<br /> <a href="/show/edit/${tvshow.id}">Edit</a> <br />
			</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Rating</th>

					</tr>
				</thead>
				<c:forEach items="${tvshow.ratings}" var="rating">
					<tr>
						<td><c:out value="${rating.ratedBy.name}" /></td>
						<td>${rating.rating}</td>
					</tr>
				</c:forEach>
			</table>
		
		<form:form method="POST" action="/show/rating" modelAttribute="newRating">
		<div class = "form-group">
		<form:label path="rating">Leave a Rating:</form:label>
    	<form:input type="number" path="rating" class="form-control"/>
    	<form:errors class ="text-danger" path="rating"/>
    	<br/>
    	<!-- hidden input of user_id -->
    	<form:input type="hidden" value="${loggedInUser.id}" path="ratedBy" />
    	<form:input type="hidden" value="${tvshow.id}" path="ratedShow" />
		<br/>
		<button class ="btn-primary">Submit</button>
		</div>
		</form:form>
	</div>
</body>
</html>