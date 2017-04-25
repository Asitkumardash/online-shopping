
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="${css}/asit3.css" rel="stylesheet">
<div class="container">

        
     <form:form class="form-horizontal" action="${contextroot}/admin/savecategory" method="POST" commandName="category">


<form:hidden path="id" class="form-control" value="${category.id}" />



<!-- Text input-->
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="name">category name</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="name" placeholder="" value="${category.name}" class="form-control input-md" />
    
  </div>
</div>


<div class="form-group">
  <form:label class="col-md-4 control-label"  for="textarea" path="description">category description</form:label>
  <div class="col-md-4">                     
    <form:textarea class="form-control" id="textarea"  path="description" value="${category.description}" name="textarea" ></form:textarea>
  </div>
</div>

<%-- <!-- Text input-->
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput">price - unit</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" />
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <form:label class="col-md-4 control-label" for="selectbasic">category</form:label>
  <div class="col-md-4">
    <select id="selectbasic" name="selectbasic" class="form-control">
      <option value="1">Option one</option>
      <option value="2">Option two</option>
    </select>
  </div>
</div>

<!-- File Button --> 
<div class="form-group">
  <label class="col-md-4 control-label" for="filebutton">upload file</label>
  <div class="col-md-4">
    <input id="filebutton" name="filebutton" class="input-file" type="file">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput">keyword</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" />
  <span class="help-block">example:alibaba</span>  
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <form:label class="col-md-4 control-label" for="selectbasic">required supplier location</form:label>
  <div class="col-md-4">
    <select id="selectbasic" name="selectbasic" class="form-control">
      <option value="1">Option one</option>
      <option value="2">Option two</option>
    </select>
  </div>
</div>

<!-- File Button --> 
<div class="form-group">
  <form:label class="col-md-4 control-label" for="filebutton">Images & videos</form:label>
  <div class="col-md-4">
    <input id="filebutton" name="filebutton" class="input-file" type="file">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput">Quantity - unit</form:label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput">Expired date</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" />
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput">destination port</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" />
    
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <form:label class="col-md-4 control-label" for="textarea">Features & Specifications</form:label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="textarea" name="textarea"></textarea>
  </div>
</div>




<fieldset>
    <legend>incoterms</legend>
    
<fieldset>
    <legend>Accepted Delivery Terms</legend>
</fieldset>

<fieldset>
    <legend>Accepted Delivery Currency</legend>
</fieldset>

<fieldset>
    <legend>Accepted Delivery Type</legend>
</fieldset>
    
    
</fieldset>
 --%>



<!-- Button -->
<div class="form-group">
<center> 	<button type="submit" class="btn btn-primary">Add</button> </center>
 </div>

</form:form>


</div>