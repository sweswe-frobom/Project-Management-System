<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Create Project</title>

<%--for dialog box --%>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/overcast/jquery-ui.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>

<spring:url value="/resources/js/dialog.js" var="createProjectDialogJS" />
<script src="${createProjectDialogJS}"></script>

<spring:url value="/resources/css/dialog.css"
	var="createProjectDialogCSS" />
<link href="${createProjectDialogCSS}" rel="stylesheet" />

<!-- for calender -->
<script>
	$(function() {
		$(".datepicker").datepicker();
	});
</script>
</head>

<body>
	<!-- <div class="container">
		<div class="main"> -->

	<div id="dialog" title="New Project">



		<form:form method="post" action="/insertProject"
			modelAttribute="project">

			<table>
				<tr>
					<td>Project Name</td>
					<td><input type="text" name="projectName" required></td>
					<td><font color="red">*** </font></td>
				</tr>

				<tr>
					<td>Start Date</td>
					<td><input type="text" name="projectStartDate"
						class="datepicker" value="" required></td>
					<td><font color="red">***</font></td>
				</tr>

				<tr>
					<td>End Date</td>
					<td><input type="text" name="projectEndDate"
						class="datepicker" value="" required></td>
					<td><font color="red">***</font></td>
				</tr>

			</table>

			<input type="submit" value="Create Project" id="submit">
		</form:form>
	</div>

	Project
	<input id="button" type="button" value="+" style="border-radius: 50px;">
	
	<br><br><br>
	
	<font color="red"> ${projectNameDuplicateError}</font>
	<font color="red"> ${DateError}</font>


</body>
</html>