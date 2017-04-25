<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="fonts" value="/resources/fonts" />

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextroot" value="${pageContext.request.contextPath}" />

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>online shopping -${title}</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">



<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<center> ${Usermsg}  ${cartmsg}  ${errorMessage} ${successMessage } </center>

	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>

	<!-- Page Content -->
	<!--loading the home content  -->

	<c:if test="${userClickedHome==true}">
		<%@include file="home.jsp"%>
	</c:if>
<!--load only when user clicks register  -->
	<c:if test="${userClickedRegister==true}">
		<%@include file="registration.jsp"%>
	</c:if>
	<!--load only when user clicks about  -->

	<c:if test="${userClickedAbout==true}">
		<%@include file="about.jsp"%>
	</c:if>

<c:if test="${userClickedLoginError==true}">
		<%@include file="loginerror.jsp"%>
	</c:if>
	<!--load only when user clicks contact  -->
	<c:if test="${userClickedContact==true}">
		<%@include file="contact.jsp"%>
	</c:if>
	
	<!--load only when user clicks add category  -->
	<c:if test="${userClickedAddCategory==true}">
		<%@include file="addcategory.jsp"%>
	</c:if>
	
	<!--load only when user clicks view category  -->
	<c:if test="${userClickedViewCategory==true}">
		<%@include file="viewcategory.jsp"%>
	</c:if>
	
	<!--load only when user clicks add supplier  -->
	<c:if test="${userClickedAddSupplier==true}">
		<%@include file="addsupplier.jsp"%>
	</c:if>
	
	<!--load only when user clicks view category  -->
	<c:if test="${userClickedViewSupplier==true}">
		<%@include file="viewsupplier.jsp"%>
	</c:if>
	
	<!--load only when user clicks add product  -->
	<c:if test="${userClickedAddProduct==true}">
		<%@include file="addproduct.jsp"%>
	</c:if>
	
	<!--load only when user clicks view product  -->
	<c:if test="${userClickedViewProduct==true}">
		<%@include file="viewproduct.jsp"%>
	</c:if>
	<!--load only when user clicks login  -->
	<c:if test="${userClickedLogin==true}">
		<%@include file="login.jsp"%>
	</c:if>
	
	<!--load only when user clicks Productdetails  -->
	<c:if test="${userClickedProductdetails==true}">
		<%@include file="productdetails.jsp"%>
	</c:if>
 	<!--load only when user clicks account  -->  
  	<c:if test="${userClickedAccount==true}">  
  		<%@include file="user/myAccount.jsp"%>  
 	</c:if> 
 	
 	<c:if test="${userClickedMyCart == true}">
 		<%@include file="cart.jsp" %>
 	</c:if>
 	
 	 
 <!-- 	load only when user clicks Change password   -->
<%--    <c:if test="${userClickedPassword==true}">  --%>
<%--  		<%@include file="user/changepassword.jsp"%>   --%>
<%--   	</c:if>   --%>
		
 	
 <!--  load only when user clicks Addresses    -->
<%--  	<c:if test="${userClickedPersonal Details==true}">   --%>
<%--   		<%@include file="user/personaldetails.jsp"%>   --%>
<%--  	</c:if>   --%>
 	  
 	    	<!--load only when user clicks Orders -->  
<%--   	<c:if test="${userClickedOrders==true}">  --%>
<%--   	<%@include file="user/orderDetails.jsp"%>   		  --%>
<%--  	</c:if>   --%>
	
	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>

</body>

</html>

