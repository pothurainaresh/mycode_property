<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Books</title>
</head>
<body>
	<p><b>List of books</b></p>
	<table>
		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>Author</th>
			<th>Price</th>
		</thead>
		<tbody>
			<c:forEach var="mybook" items="${mybooklist}">
			<tr>
				<td>${mybook.id}
				<td>${mybook.name}
				<td>${mybook.author}
				<td>${mybook.price}
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
</body>
</html>