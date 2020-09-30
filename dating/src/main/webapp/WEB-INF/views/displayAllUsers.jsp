<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Online Dating Application - Display All Users</title>
		<link type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet"/>
		<style>
			table {
			  border-collapse: collapse;
			  border-spacing: 0;
			  width: 100%;
			  border: 1px solid #ddd;
			}
			th, td {
			  text-align: left;
			  padding: 16px;
			}
			tr:nth-child(even) {
			  background-color: #f2f2f2;
			}
		</style>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="container">
		<hr/>
			<% String loginName = (String) session.getAttribute("loginName"); %>
		
			<h2 align="center" class="text-primary text-center">Hi <c:out value='${loginName.toUpperCase()}'/>, All Registered Users for Dating</h2>
			<div class="container-fluid">
			 	<div class="row-fluid">
			  		<div class="span12">
			    		<fieldset>
							<table class="table table-hover table-striped-rows table-bordered table-condensed">
							    <tr class="text-danger text-center">
							        <th>User ID</th>
							        <th>First Name</th>
							        <th>Last Name</th>
							        <th>Date of Birth</th>
							        <th>Gender</th>
							        <th>Address</th>
							    </tr>
					           	<c:forEach var="user" items="${userList}">
						            <tr>
						                <td><c:out value="${user.userId}" /></td>
						                <td><c:out value="${user.firstName}" /></td>
						                <td><c:out value="${user.lastName}" /></td>
						                <td><c:out value="${user.dateOfBirth}" /></td>
						                <td><c:out value="${user.gender}" /></td>
						                <td><c:out value="${user.address}" /></td>
						                <td><a href="initDating/${user.userId}" style='text-decoration: none;'>Wanna Propose For Dating?</a></td>
						            </tr>
					           	</c:forEach>
					        </table>
					    </fieldset>
		   			</div>
		  		</div>
				<hr/>
		 	</div>
	 	</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>