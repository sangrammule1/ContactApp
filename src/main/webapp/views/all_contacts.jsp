<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Contacts</title>
<script type="text/javascript">
	function confirmDelete() {
		return confirm("are you sure, you want to delete")
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${!empty contacts }">
			<h2 style="text-align: center;">All Contacts</h2>
			<a href="showForm">+add new contact</a>
			<table border="1"
				style="border-collapse: collapse; border-color: red">
				<tr bgcolor="orange">
					<th>Contact Id</th>
					<th>Contact Name</th>
					<th>Email</th>
					<th>Contact Number</th>
					<th>Action</th>
				</tr>
				<c:forEach var="contact" items="${contacts }">
					<tr bgcolor="cyan">
						<td>${contact.contactId }</td>
						<td>${contact.contactName }</td>
						<td>${contact.email }</td>
						<td>${contact.contactNum }</td>
						<td><a href="updateContact?contactId=${contact.contactId}">edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="deleteContact?contactId=${contact.contactId}" onclick="return confirmDelete()">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: orange; text-align: center;">contacts not
				found</h1>
		</c:otherwise>
	</c:choose>
	<h3 style="color: orange; text-align: center">${Saved}</h3>
	<h3 style="color: red; text-align: center">${delete}</h3>
	<br>
	<br>
</body>
</html>