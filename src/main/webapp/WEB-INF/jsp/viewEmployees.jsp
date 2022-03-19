<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>       
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src="https://use.fontawesome.com/37d60b494a.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View employees</title>
		<style>
      body { padding-top: 50px;
      		 
      		 font-family: 'Open Sans', sans-serif;
      		 
      		}
      		
      		.navbar-inverse {
      		background-color: #85144b; 
      		border-color: #85144b;
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
<div class="container-fluid">

<nav  class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp"><i class="fa fa-home" aria-hidden="true" style="font-size: 150%; color:#337ab7;"></i>
      </a>
    </div>
    <form action="searchEmployee" class="navbar-form navbar-left">
      <div class="form-group">
        <input name="searchedValue"  type="text" class="form-control" placeholder="Search by name" onkeydown="upperCase(this)" >
      </div>
      <button type="submit" class="btn btn-info">Search</button>
    </form>
  </div>
  </nav>
<table class="table table-bordered">  
		<tr >
			<th>ID</th>
			<th>PHOTO</th>
			<th>NAME</th>
			<th>POST CODE</th>
			<th>EMAIL</th>
			<th>ADD ASSETS</th>
			<th>EDIT/DELETE</th>
			<th>ASSETS</th>
		</tr>  
   <c:forEach var="employees"	 items="${employeeList}"> 
    <tr>  
   		<td>${employees.id}</td> 
   		<td><img src='${employees.photo}' height="100" width="150"></td> 
   		<td>${employees.name}</td>
     	<td>${employees.address}</td>
   		<td>${employees.email}</td> 
   		<td><a href="addPhone${employees.id}"><input type="button" value = "Add phone" class="btn btn-primary" /><br><br>
   		    <a href="addLaptop${employees.id}"><input type="button" value = "Add laptop" class="btn btn-primary" />
   		</td>
   		<td><a href="delete${employees.id}"><input type="button" value = "Delete Employee" class="btn btn-danger" /><br><br>
   			<a href="editEmployee${employees.id}"><input type="button" value = "Edit Employee" class="btn btn-warning" />
   		</td>
   		
   	<td>
					<table class="table table-bordered table-hover">
						<tr>
							<th>Phone Make</th><th>Phone IMEI</th><th>Remove phone</th>
						</tr>
						<c:forEach items="${employees.phones}" var="phones">
							<tr>
								<td>${phones.phoneMake}</td>
								<td>${phones.phoneImei}</td>
								<td><a href="deletePhone${phones.phoneImei}"><input type="button" value = "Remove phone" class="btn btn-danger" /></a></td>
							</tr>
						</c:forEach>
						
						<tr>
							<th>Laptop Make</th><th>Laptop SN</th><th>Remove laptop</th>
						</tr>
						<c:forEach items="${employees.laptops}" var="laptops">
							<tr>
								<td>${laptops.make}</td>
								<td>${laptops.serialNumber}</td>
								<td><a href="deleteLapTop${laptops.serialNumber}"><input type="button" value = "Remove laptop" class="btn btn-danger" /></a></td>
							</tr>
						</c:forEach>
						
					</table>
	</td>
   	
   	</tr>	
   </c:forEach>  
 </table> 
 </div>
</body>
</html>