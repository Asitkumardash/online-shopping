<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><p class="forlegends">Your  Profile</p></h1>
					
					<div class="panel panel-default">
					  	
						<div class="panel-body">
							<h2><p class="myachead">Name: 
							<span class="myactext">${user.fname} ${user.lname}</span></p></h2>
							<hr />
							<h2><p class="myachead">E-mail: <br /> <span class="myactext">${user.email}</span></p></h2>
							<hr />
							<h2><p class="myachead">Mobile Phone Number: <br /> <span class="myactext">${user.pno}</span></p></h2>
						
							<hr>
							<h2><p class="myachead">Address: <span class="myactext"><br/>${user.add1} <br/> ${user.add2} <br/>${user.add3} <br/>${user.city} <br/>${user.state} <br/>${user.pincode}</span></p><h2>
							

						</div>							

			
		
					</div>
</body>
</html>