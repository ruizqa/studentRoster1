<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
</head>
<body>
<section>
	<div class="container">
			<form action="/contact/create" method="get" class="col">
			    
			    <div class="form-group my-2">
			        <label for="student" class="form-label">Student</label>
			    </div>
			
				<div class="form-group my-2">
			        <select name="studentID">
					    <c:forEach var="student" items="${students}" >
					        <option value="${student.id}" label="${student.firstName} ${student.lastName}"/>
					    </c:forEach>
					</select>
			    </div>

			
			    <div class="form-group my-2">
			        <label for="address" class="form-label">Address</label>
			    </div>
			    <div class="form-group my-2">    
			        <input type="text" name="address" class="form-control"/>
			    </div>
			    <div class="form-group my-2">
			        <label for="city" class="form-label">City</label>
			    </div>
			    
			    <div class="form-group my-2">
			        <input type="text"  name="city" class="form-control"/>
			    </div>
			    
			    <div class="form-group my-2">
			        <label for="state" class="form-label">State</label>
			    </div>
			    
			    <div class="form-group my-2">
			        <input type="text"  name="state" class="form-control"/>
			    </div>
			    
			    <div class="text-center">    
			    	<input class="btn btn-primary text-center my-2" type="submit" value="Submit"/>
			    </div>
			</form>
	
	</div>
</section>
</body>
</html>