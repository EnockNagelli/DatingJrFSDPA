<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Online Dating Application - Dating Details Page</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="container">
		<hr/>
	  		<div class="h-50 d-inline-block text-red text-center form-rounded" style="width: 1120px;"><h2>Dating Proposal Form</h2></div>
	  		<form action="saveDatingProposal" class="was-validated" method=post>

	    		<div class="form-row">
		    		<div class="form-col">
		    			<label for="userId">Sender Id</label>
		    			<input type="text" class="form-control" id="userId" placeholder="Enter User Id" name="userId" required>
		    			<div class="valid-feedback">Valid.</div>
		    		</div>
		    		<div class="form-col">
		      			<label for="receiverId">Receiver Id</label>
		      			<input type="text" class="form-control" id="receiverId" placeholder="Enter Receiver Id" name="receiverId" required>
		      			<div class="valid-feedback">Valid.</div>
		    		</div>
		    	</div>

	    		<div class="form-row">
		    		<div class="form-col">
		      			<label for="datingDate">Fixing Date for Dating</label>
		      			<input type="text" class="form-control" id="dateFixing" placeholder="Enter Date for Dating" name="datingDate" required>
		      			<div class="valid-feedback">Valid.</div>
				    </div>
		    		<div class="form-col">
						<label for="datingTime">Preferred Dating Time</label>
		      			<input type="text" class="form-control" id="timeFixing" placeholder="Enter Time for Dating" name="datingTime" required>
		      			<div class="valid-feedback">Valid.</div>
		    		</div>
	    		</div>

	    		<div class="form-row">
		    		<div class="form-col">
						<label for="location">Preferred Dating Location</label>
		      			<input type="text" class="form-control" id="location" placeholder="Enter Dating Location" name="location" required>
		      			<div class="valid-feedback">Valid.</div>
		    		</div>
		    		<div class="form-col">
						<label for="requestStatus">Dating Status</label>
		      			<input type="text" class="form-control" id="requestStatus" placeholder="Enter Status" name="requestStatus" required>
		      			<div class="valid-feedback">Valid.</div>
		    		</div>
		    	</div>

	    		<div class="form-group">
	      			<label for="datingRequest">Dating Proposal</label>
	      			<textarea class="form-control" rows="7" id="address" placeholder="Dating Proposal" name="datingRequest" required></textarea>
	      			<div class="valid-feedback">Valid.</div>
	    		</div>

	    		<button type="submit" class="btn btn-primary">Commit Dating</button>
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