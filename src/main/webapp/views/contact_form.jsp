<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(event) {
		$("#email").blur(function() {
			$("#dupEmailId").text(' ');
			var emailId = $("#email").val();
			$.ajax({
				type : "GET",
				url : "validateEmail?email=" + emailId,
				success : function(data) {
					if (data == "DUPLICATE") {
						$("#dupEmailId").text('Duplicate email id')
						$("#email").focus();
					}
				}
			});
		});
	});
</script>
</head>
<h1 style="color: green; text-align: center;">Register contact
	Details</h1>

<font color="green">${Saved }</font>
<form:form modelAttribute="contact">
	<table>
		<tr>
			<td>NAME:</td>
			<td><form:input path="contactName" /></td>
		</tr>
		<tr>
			<td>EMAIL:</td>
			<td><form:input path="email" /></td>
			<td><font color="red"><span id="dupEmailId"></span></font></td>
		</tr>
		<tr>
			<td>Contact No:</td>
			<td><form:input path="contactNum" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form:form>
<br>
<a href="/showAllContact">show All Contacts</a>
