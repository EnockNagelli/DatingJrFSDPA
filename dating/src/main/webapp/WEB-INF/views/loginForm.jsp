<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Online Dating Application</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <style type="text/css">
            .errormsg {
                color: red;
            }
        </style>
    </head>
    <body><br>
		<jsp:include page="header.jsp"/>
		<hr/>
        <div class="container">
            <h2 align="center" class="text-primary">Dating Application - User Login</h2>
            <hr />
            <div> </div>
 
            <form:form action="loginInfo" method="POST" modelAttribute="userform">
                 <div class="form-group">
                    <label>Login Name:</label><form:input path="loginName" size="30" cssClass="form-control" placeholder="Enter Login Name" />             
                    					<small><form:errors path="loginName" cssClass="errormsg" /></small>
                 </div>
                 <div class="form-group">
                    <label>Password:</label><form:password path="password" size="30" cssClass="form-control" placeholder="Enter Password" />
                    				 <small><form:errors path="password" cssClass="errormsg" /></small>
                 </div>
                 <div class="form-group">
                    <button type="submit" class="btn btn-primary">Login</button>
                 </div>
            </form:form>
        </div>
        <hr/>
		<jsp:include page="footer.jsp"/>
    </body>
</html>