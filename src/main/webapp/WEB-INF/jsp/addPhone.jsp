<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>AddPhone</title>
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
		$(document).ready(
			function() {
				$.getJSON('<spring:url value="phonemakes.json"/>', {
					ajax : 'true'
				}, function(data){
					var html = '<option selected disabled >--Please select a phone make--</option>';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].phoneMake + '">'
								+ data[i].phoneMake + '</option>';
					}
					html += '</option>';
					
					$('#phoneMake').html(html);
				});
				
			});
</script>
 
</head>
<body>
<div class="container" >
<div class="col-sm-3"></div>
<div class="col-sm-6">
<div class="jumbotron">


<form:form action="savePhone" modelAttribute="savePhoneForm" method="POST" >
	 <div class="form-group">
			<label>Add phone details for:</label><br>
			<label>${name}</label><br>
			<label>System Id: ${id}</label>
	</div>
        <div class="form-group"> 
       		<label  >Phone make:</label>
         	<form:select path="phoneMake" id="phoneMake" type="text" class="form-control"/>
         	<form:errors path="phoneMake"  cssClass="error"/>
        </div>
		<div class="form-group"> 
       		<label >Phone imei(15 digits):</label>
         	<form:input path="phoneImei" id="phoneImei" type="text" class="form-control" />
         	<form:errors path="phoneImei"  cssClass="error"/>
		</div>
		<div class="form-group"> 
       		<button type="submit" class="btn btn-primary">Add phone</button>
       		<a href="viewEmployees"><button type="button" class="btn btn-primary">Cancel</button></a>
 		</div>
</form:form>
</div>            
</div>
<div class="col-sm-3"></div>
</div>
</body>
</html>