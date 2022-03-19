<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>EditEmployee</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
    body { 
    	padding-top: 50px; 
    	background-color: #85144b; 
    	font-family: 'Open Sans', sans-serif;
    }
</style>

<script type="text/javascript">
function upperCase(a){
    setTimeout(function(){
        a.value = a.value.toUpperCase();
    }, 1);
}	
</script>
</head>
<body>
<div class="container" >
<div class="col-sm-3"></div>
<div class="col-sm-6">
<div class="jumbotron">
<form:form action="saveEditedEmployee" modelAttribute="editEmployeeForm" method="POST" >
		<h3>Edit employee data:</h3>
		<form:input path="id"  id="id"  type="hidden"/>
		<form:errors path="id"  cssClass="error"/>
        <div class="form-group"> 
       		<form:label  path="name" >Employee name:</form:label>
         	<form:input path="name" id="name" type="text" class="form-control" placeholder="Name" onkeydown="upperCase(this)" />
         	<form:errors path="name"  cssClass="error"/>
		</div>
            
        <div class="form-group"> 
       		<label  for="address" >Employee post code:</label>
         	<form:input type="text" path="address" id="address" class="form-control" placeholder="Employee Address" onkeydown="upperCase(this)" />
         	<form:errors path="address"  cssClass="error"/>
		</div>    
        
        <div class="form-group"> 
       		<label  for="email" >Employee email:</label>
         	<form:input type="text" path="email" id="email" class="form-control"  placeholder="address@email.com" />
         	<form:errors path="email"  cssClass="error"/>
		</div>
		
		 <div class="form-group"> 
       		<label  for="photo" >Employee photo URL:</label>
         	<form:input type="text" path="photo" id="photo" class="form-control"  placeholder="Employee Photo URL" />
         	<form:errors path="photo"  cssClass="error"/>
		</div>        
        <button type="submit" class="btn btn-warning">Save employee</button>
 </form:form>
</div>
</div>
<div class="col-sm-3"></div>
</div>
</body>
</html>