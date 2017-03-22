<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Project Member</title>

<spring:url value="/resources/css/createProjectAddMemberCSS.css"
	var="createProjectAddMemberCSS" />
<link href="${createProjectAddMemberCSS}" rel="stylesheet" />

</head>

<body>

	<table>
		<tr>
			<th>PROJECT NAME</th>
			<td><%=session.getAttribute("ProjectName")%></td>
		</tr>

		<tr>
			<th>PROJECT CREATOR</th>
			<td><%=session.getAttribute("ProjectCreatorName")%></td>
		</tr>

	</table>
	<br>
	<br> Add Member
	<div class="dropdown">

		<button onclick="myFunction()" class="dropbtn" name="addmember">+</button>

		<div id="myDropdown" class="dropdown-content">
			<input type="text" placeholder="Search.." id="myInput"
				onkeyup="filterFunction()">
			<c:forEach var="user" items="${userNameList}">
				<a href="projectMemberSave/${user.userId}"> ${user.userName} </a>
			</c:forEach>
		</div>
	</div>


	<!-- <font color="red"> *** </font> -->

	<br>
	<br>
	<fieldset style="width: 300px; height: 400px;">
		<legend>
			<font color="green">PROJECT MEMBERS </font>
		</legend>

		<c:forEach var="user" items="${UserName}">
						 ${user.userName} 
				<br>
		</c:forEach>

	</fieldset>

	<font color="red"> ${AlreadySelectedError} </font>

	<br>
	<br>
	<br>
	<br> ProjectManagement.java
	<div class="dropdown">
		<button onclick="myFunction1()" class="dropbtn" name="editProject">...</button>
		<div id="myDropdown1" class="dropdown-content">
			<a href="editMember">Edit Member</a> <a href="">Delete Project</a>
		</div>
	</div>

	<!-- for drop down button -->
	<script>
		function myFunction() {
			document.getElementById("myDropdown").classList.toggle("show");
		}
		function myFunction1() {
			document.getElementById("myDropdown1").classList.toggle("show");
		}

		// Close the dropdown if the user clicks outside of it
		window.onclick = function(event) {
			if (!event.target.matches('.dropbtn')) {

				var dropdowns = document
						.getElementsByClassName("dropdown-content");
				var i;
				for (i = 0; i < dropdowns.length; i++) {
					var openDropdown = dropdowns[i];
					if (openDropdown.classList.contains('show')) {
						openDropdown.classList.remove('show');
					}
				}
			}
		}

		function filterFunction() {
			var input, filter, ul, li, a, i;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			div = document.getElementById("myDropdown");
			a = div.getElementsByTagName("a");
			for (i = 0; i < a.length; i++) {
				if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
					a[i].style.display = "";
				} else {
					a[i].style.display = "none";
				}
			}
		}
	</script>


	<script>
		function myFunction1() {
			document.getElementById("myDropdown1").classList.toggle("show");
		}

		// Close the dropdown if the user clicks outside of it
		window.onclick = function(event) {
			if (!event.target.matches('.dropbtn')) {

				var dropdowns = document
						.getElementsByClassName("dropdown-content");
				var i;
				for (i = 0; i < dropdowns.length; i++) {
					var openDropdown = dropdowns[i];
					if (openDropdown.classList.contains('show')) {
						openDropdown.classList.remove('show');
					}
				}
			}
		}
	</script>

</body>
</html>