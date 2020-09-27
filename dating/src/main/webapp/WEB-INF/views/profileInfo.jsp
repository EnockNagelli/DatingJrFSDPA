<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Online Dating Application - Profile Information</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	</head>
	<body><br>
		<jsp:include page="header.jsp"/>
		<hr/>
		<div class="container">
			<div style="height: 100px;">
				<div class="bg-danger h-50 d-inline-block text-white text-center form-rounded" style="width: 1120px;"><h2>Dating Application : Profile Information</h2></div>
		  		<div>&nbsp;</div>
		  		<div class="h-50 d-inline-block text-red text-center form-rounded" style="width: 1120px;"><h2>User Profile Form</h2></div>
		  		<form action="saveProfile" class="was-validated" method=post>

		    		<div class="form-row">
			    		<div class="form-col">
			    			<label for="userId">User Id</label>
			    			<input type="text" class="form-control" id="userId" placeholder="Enter User Id" name="userId" required />
			    			<div class="valid-feedback">Valid.</div>
			    		</div>
			    		<div class="form-col">
			    			<label for="userPhoto">User Photo</label>
			    			<input type="file" class="form-control" id="userPhoto" placeholder="Enter User Photo" name="userPhoto" required/>
			      			<div class="valid-feedback">Valid.</div>
			    		</div>
					</div>
					
		    		<div class="form-row">
			    		<div class="form-col">
			      			<label for="contactNo">Contact Number</label>
			      			<input type="text" class="form-control" id="contactNo" placeholder="Enter Contact Number" name="contactNo" required />
			      			<div class="valid-feedback">Valid.</div>
					    </div>
			    		<div class="form-col">
			      			<label for="email">Email</label>
			      			<input type="text" class="form-control" id="email" placeholder="Enter Email ID" name="email" required />
			      			<div class="valid-feedback">Valid.</div>
			    		</div>
			    	</div>
			    	
		    		<div class="form-row">
			    		<div class="form-col">
							<label for="qualification">Qualification</label>
			      			<input type="text" class="form-control" id="qualification" placeholder="Enter Qualification" name="qualification" required />
			      			<div class="valid-feedback">Valid.</div>
			    		</div>
			    		<div class="form-col">
			      			<label for="hobbies">Hobbies</label>
			      			<input type="text" class="form-control" id="hobbies" placeholder="Enter Hobbies" name="hobbies" required />
			      			<div class="valid-feedback">Valid.</div>
			    		</div>
			    	</div>

		    		<div class="form-row">
			    		<div class="form-col">
			      			<label for="foodHabits">Hobbies</label>
			      			<input type="text" class="form-control" id="foodHabits" placeholder="Enter Food Habits" name="foodHabits" required />
			      			<div class="valid-feedback">Valid.</div>
			    		</div>
			    		<div class="form-col">
							<label for="aboutMe">About Me</label>
			      			<textarea class="form-control" rows="7" id="aboutMe" placeholder="About Me" name="aboutMe" required></textarea>
			      			<div class="valid-feedback">Valid.</div>
			    		</div>
					</div>
					
		    		<button type="submit" class="btn btn-primary">Commit Profile</button>
		  		</form><br>
				<div class="bg-primary h-50 text-white text-center form-rounded">@ Copy right : www.iiht.com</div>
		  	</div>
		</div>
		<hr/>
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