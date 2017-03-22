<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Member Detail</title>


<spring:url value="/resources/css/editMemberCSS.css" var="editMemberCSS" />
<link href="${editMemberCSS}" rel="stylesheet" />

<spring:url value="/resources/image/crossSign.jpg" var="crossSign" />

<spring:url value="/resources/image/plusSign.jpg" var="plusSign" />

</head>
<body>

	<b> PROJECT NAME
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </b>
	<%=session.getAttribute("ProjectName")%>
	<br>
	<b> PROJECT CREATOR &nbsp;: </b>
	<%=session.getAttribute("ProjectCreatorName")%>



	<center>
		<font color="red"> ${NotAllowToDeleteMemberError} </font>
		<h3>
			<i><font color="green"> Member List </font></i>
		</h3>

		<table>
			<c:forEach var="user" items="${userNameListInProject}">
				<tr>
					<td>${user.userName}</td>
					<td><a href="projectMemberDelete/${user.userId}">
							<button class="delete">
								<img src="${crossSign}" />
							</button>
					</a></td>
				</tr>
			</c:forEach>

			<c:forEach var="user" items="${userNameListInTeam}">
				<tr>

					<td>${user.userName}</td>
					<td><a href="projectMemberAdd/${user.userId}"><button
								class="add">
								<img src="${plusSign}" />
							</button> </a></td>
				</tr>

			</c:forEach>
		</table>
	</center>


</body>
</html>