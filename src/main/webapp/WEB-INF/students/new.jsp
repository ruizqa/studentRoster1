<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Student</title>
</head>
<body>
<section>
	<div class="container">
			<form action="/students/create" method="get" class="col">
			    <div class="form-group my-2">
			        <label for="firstName" class="form-label">First Name</label>
			    </div>
			    <div class="form-group my-2">    
			        <input type= "text" name="firstName" class="form-control"/>
			    </div>
			    <div class="form-group my-2">
			        <label for="lastName" class="form-label">Last Name</label>
			    </div>
			    
			    <div class="form-group my-2">
			        <input type="text" name="lastName" class="form-control"/>
			    </div>
			    
			    <div class="form-group my-2">
			        <label for="age" class="form-label">Age</label>
			    </div>
			    
			    <div class="form-group my-2">
			        <input type="number" name="age" class="form-control"/>
			    </div>
			    
			    <div class="text-center">    
			    	<input class="btn btn-primary text-center my-2" type="submit" value="Submit"/>
			    </div>
			</form>
	</div>
</section>
</body>
</html>