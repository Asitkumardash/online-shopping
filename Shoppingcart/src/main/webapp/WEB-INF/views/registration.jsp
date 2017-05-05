<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="${css}/asit4.css" rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">
	  <form:form class="form-horizontal" action="${contextroot}/register" method="POST" commandName="user">

    

    


<!-- Text input-->
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="fname">first name <span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="fname" /></font>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="fname" placeholder=""  class="form-control input-md" />
    
  </div>
</div>
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="lname">last name <span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="lname" /></font>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="lname" placeholder=""  class="form-control input-md" />
    
  </div>
</div>

<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="email">Email id<span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="email" /></font> 
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="email" placeholder=""  class="form-control input-md" />
    
  </div>
</div>
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="pw">Password<span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="pw" /></font>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="password" path="pw" placeholder=""  class="form-control input-md" />
    
  </div>
</div>
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="pno">Phone number<span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="pno" /></font>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="pno" placeholder=""  class="form-control input-md" />
    
  </div>
</div>

<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="add1">Address line 1<span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="add1" /></font>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="add1" placeholder=""  class="form-control input-md" />
    
  </div>
</div>
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="add2">Address line 2<span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="add2" /></font>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="add2" placeholder=""  class="form-control input-md" />
    
  </div>
</div>
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="add3">Address line 3<span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="add3" /></font>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="add3" placeholder=""  class="form-control input-md" />
    
  </div>
</div>



<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="city">City<span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="city" /></font>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="city" placeholder=""  class="form-control input-md" />
    
  </div>
</div>

<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="state">State<span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="state" /></font>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="state" placeholder=""  class="form-control input-md" />
    
  </div>
</div>

<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="pincode">Pincode<span class="reqstar">&#42;</span></form:label><font color='red'><form:errors path="pincode" /></font>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="pincode" placeholder=""  class="form-control input-md" />
    
  </div>
</div>






			
				
			<center>	<button type="submit" class="btn btn-primary btn-md">Register</button> </center>
				
				
</form:form>

</div>