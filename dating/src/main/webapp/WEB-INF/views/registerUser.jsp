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
	<body>
		<jsp:include page="header.jsp"/>
		<div class="container">
			<hr/>
	    		<div class="form-group">
			  		<div class="d-inline-block text-blue text-center form-rounded" style="width: 1120px;"><h2>User Registration Form</h2></div>
			  	</div>
		  		<form action="saveUser" class="was-validated" method=post>
		    		<div class="form-row">
			    		<div class="form-col-md-3">
			    			<label for="firstName">First Name</label>
			    			<input type="text" class="form-control" id="firstName" placeholder="Enter User Name" name="firstName" required>
			    			<div class="valid-feedback">Valid.</div>
			    		</div>
			    		<div class="form-col-1"></div>
			    		<div class="form-col-md-3">
			      			<label for="lastName">Last Name</label>
			      			<input type="text" class="form-control" id="lastName" placeholder="Enter Last Name" name="lastName" required>
			      			<div class="valid-feedback">Valid.</div>
			    		</div>
			    		<div class="form-col-2"></div>
			    		<div class="form-cols-md-3">
			      			<label for="dateOfBirth">Date of Birth</label>
			      			<input type="text" class="form-control" id="dateOfBirth" placeholder="Enter Date Of Birth" name="dateOfBirth" required>
			      			<div class="valid-feedback">Valid.</div>
					    </div>
 					</div><br>
		    		<div class="form-row">
 			    		<div class="form-col-md-3">
							<label for="gender">Gender</label>
			      			<input type="text" class="form-control" id="gender" placeholder="Enter Gender" name="gender" required>
			      			<div class="valid-feedback">Valid.</div>
			    		</div>
			    		<div class=form-col-5></div>
			    		<div class="form-col-md-3">
							<label for="loginName">Login Name</label>
			      			<input type="text" class="form-control" id="loginName" placeholder="Enter Login Name" name="loginName" required>
			      			<div class="valid-feedback">Valid.</div>
			    		</div>
			    		<div class=form-col-5></div>
			    		<div class="form-col-md-3">
							<label for="password">Password</label>
			      			<input type="text" class="form-control" id="password" placeholder="Enter Password" name="password" required>
			      			<div class="valid-feedback">Valid.</div>
			    		</div>
			    		<div class=form-col-5></div>
			    		<div class="form-col-md-3">
			      			<label for="address">Current Address</label>
			      			<textarea class="form-control" rows="4" id="address" placeholder="Current Address" name="address" required></textarea>
			      			<div class="valid-feedback">Valid.</div>
		    			</div>
		    		</div>
		    		<button type="submit" class="btn btn-primary">Commit Registration</button>
		  		</form>
		  	<hr/>
		  	</div>
			<jsp:include page="footer.jsp"/>
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