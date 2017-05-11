<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	    	<div class="col-md-3">
	        
			        <div class="panel panel-default">
			          <div class="panel-heading">
			            <h3 class="panel-title">My Account</h3>
			          </div>
			          <div class="panel-body">
			          	<legend class="text-center"></legend>
			            <ul class="list-group">
			              <a href="${contextroot}/user/myAccount" id="myAccount" class="list-group-item">Account details</a>
			              <a href="${contextroot}/user/orderDetails" id="orderDetails" class="list-group-item">Orders</a>
			           
			              
			            </ul> 
			            <legend class="text-center"></legend>
			            <ul class="list-group">
			              <a href="${contextroot}/user/personaldetails" id="personalInfo" class="list-group-item">Personal information</a>
			              <a href="${contextroot}/user/changePassword" id="changePW" class="list-group-item">Change password</a>
			              <a href="${contextroot}/user/billingAddress" id="billingAddress" class="list-group-item">billing address</a>
			              <a href="${contextroot}/user/manageAddress" id="manageAddress" class="list-group-item">Manage addresses</a>
			              <a href="${contextroot}/user/changeMobNo" id="changeMobNo" class="list-group-item">Update mobile number</a>
			              
			            </ul> 
			          </div>
			        </div>
			
            
			</div>
			<div class="col-md-9">
				
					
					<c:if test="${userClickedShippingAddress==true }">
						<%@include file="shippingAddress.jsp" %>
					</c:if>  					

					<c:if test="${userClickedPersonalDetails==true}">  
				  		<%@include file="personaldetails.jsp"%>  
				 	</c:if>  
				 	
				 	<c:if test="${userClickedBillingAddress == true }">
				 		<%@include file="billingAddress.jsp" %>
				 	</c:if>
				 	
				 	<c:if test="${userClickedChangePassword == true }">
				 		<%@include file="changepassword.jsp" %>
				 	</c:if>
		
	</div>
	
	</div>		