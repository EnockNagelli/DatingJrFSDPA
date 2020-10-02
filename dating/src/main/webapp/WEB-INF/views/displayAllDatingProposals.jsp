<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Online Dating Application - Display All Proposals</title>
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
			<h2 align="center" class="text-primary text-center">All Dating Proposals Received by <c:out value='${loginName.toUpperCase()}'/></h2>
			<div class="container-fluid">
			 	<div class="row-fluid">
			  		<div class="span12">
			    		<fieldset>
							<table class="table table-hover table-striped-rows table-bordered table-condensed">
							    <tr class="text-danger text-center">
							        <th>Sender ID</th>
							        <th>Receiver ID</th>
							        <th>Dating Date</th>
							        <th>Dating Time</th>
							        <th>Dating Location</th>
							        <th>Dating Request</th>
							        <th>Dating Status</th>
							        <th class="text-primary" >Proposal Request</th>
							    </tr>
					           	<c:forEach var="dating" items="${datingList}">
						            <tr>
						                <td><c:out value="${dating.userId}" /></td>
						                <td><c:out value="${dating.receiverId}" /></td>
						                <td><c:out value="${dating.datingDate}" /></td>
						                <td><c:out value="${dating.datingTime}" /></td>
						                <td><c:out value="${dating.location}" /></td>
						                <td><c:out value="${dating.datingRequest}" /></td>
						                <td><c:out value="${dating.requestStatus}" /></td>
						                <td><a href="withStatus/${dating.userId}" style='text-decoration: red;'>Accepted</a> | <a href="withStatus/${dating.userId}" style='text-decoration: none;'>Rejected</a></td>
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