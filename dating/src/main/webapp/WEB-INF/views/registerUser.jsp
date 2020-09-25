<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Online Dating Application - Registration Page</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	</head>
	<body><br>
		<div class="container">
			<div style="height: 100px;">
				<div class="bg-danger h-50 d-inline-block text-white text-center form-rounded" style="width: 1120px;"><h2>User Registration for Dating</h2></div>
		  		<div>&nbsp;</div>
		  		<div class="h-50 d-inline-block text-red text-center form-rounded" style="width: 1120px;"><h2>User Registration Form</h2></div>
		  		<form action="saveUser" class="was-validated" method=post>
		    		<!-- <div class="form-group">
		    			<label for="title">User Id</label>
		    			<input type="text" class="form-control" id="userId" placeholder="Enter User Id" name="userId" required>
		    			<div class="valid-feedback">Valid.</div>
		    		</div> -->
		    		<div class="form-group">
		    			<label for="title">First Name</label>
		    			<input type="text" class="form-control" id="firstName" placeholder="Enter User Name" name="firstName" required>
		    			<div class="valid-feedback">Valid.</div>
		    		</div>
		    		<div class="form-group">
		      			<label for="tags">Last Name</label>
		      			<input type="text" class="form-control" id="lastName" placeholder="Enter Last Name" name="lastName" required>
		      			<div class="valid-feedback">Valid.</div>
		    		</div>
		    		<div class="form-group">
		      			<label for="tags">Date of Birth</label>
		      			<input type="text" class="form-control" id="dateOfBirth" placeholder="Enter Date Of Birth" name="dateOfBirth" required>
		      			<div class="valid-feedback">Valid.</div>
				    </div>
		    		<div class="form-group">
						<label for="tags">Gender</label>
		      			<input type="text" class="form-control" id="gender" placeholder="Enter Gender" name="gender" required>
		      			<div class="valid-feedback">Valid.</div>
		    		</div>
		    		<div class="form-group">
		      			<label for="posts">Current Address</label>
		      			<textarea class="form-control" rows="7" id="address" placeholder="Current Address" name="address" required></textarea>
		      			<div class="valid-feedback">Valid.</div>
		    		</div>
		    		<div class="form-group">
						<label for="tags">Login Name</label>
		      			<input type="text" class="form-control" id="loginName" placeholder="Enter Login Name" name="loginName" required>
		      			<div class="valid-feedback">Valid.</div>
		    		</div>
		    		<div class="form-group">
						<label for="tags">Password</label>
		      			<input type="text" class="form-control" id="password" placeholder="Enter Password" name="password" required>
		      			<div class="valid-feedback">Valid.</div>
		    		</div>
		    		<button type="submit" class="btn btn-primary">Commit Registration</button>
		  		</form><br>
				<div class="bg-primary h-50 text-white text-center form-rounded">@ Copy right : www.iiht.com</div>
		  	</div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
		<script>
			// Disable form submissions if there are invalid fields
			(function() {
			  	'use strict';
				window.addEventListener('load', function() {
		   			// Get the forms we want to add validation styles to
		   			var forms = document.getElementsByClassName('needs-validation');
		   			// Loop over them and prevent submission
		   			var validation = Array.prototype.filter.call(forms, function(form) {
		   				form.addEventListener('submit', function(event) {
		        			if (form.checkValidity() === false) {
		          				event.preventDefault();
		          				event.stopPropagation();
			      			}
				       		form.classList.add('was-validated');
			   			}, false);
			    	});
			  	}, false);
			})();
		</script>
	</body>
</html>




























<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- <f:view> </f:view> -->
		<h2>Inside Add Company Page...</h2>
	 </body>
</html> --%>