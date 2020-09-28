<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <title>Online Dating Application - Home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    </head>
    <body>
		<jsp:include page="header.jsp"/>
        <div class="container">
			<hr/>
			<div class="row">
				<div class="col-sm-4">
					<a href="initUser"    	class="btn btn-info btn-md btn-block"><b>Login Dating App</b></a><br>
					<a href="registerUser"	class="btn btn-info btn-md btn-block"><b>Add User Info</b></a><br>
					<a href="listAllUsers"	class="btn btn-info btn-md btn-block"><b>View All User</b></a><br>
					<a href="initProfile" 	class="btn btn-info btn-md btn-block"><b>Add Profile Info</b></a><br>
					<a href="initDating" 	class="btn btn-info btn-md btn-block"><b>Dating Proposal</b></a><br>
				</div>
			</div>
			<hr/>
		</div>
		<jsp:include page="footer.jsp"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>    
    </body>
</html>