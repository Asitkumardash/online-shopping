<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="${css}/asit3.css" rel="stylesheet">
<div class="container">

        
     <form:form class="form-horizontal" action="${contextroot}/admin/saveproduct" method="POST" commandName="product" enctype="multipart/form-data">

<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="cid">Category ID</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="cid" placeholder="" class="form-control input-md" />
    
  </div>
</div>




<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="pname">product name</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="pname" placeholder="" class="form-control input-md" />
    
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <form:label class="col-md-4 control-label" path="pdesc" for="textarea">description</form:label>
  <div class="col-md-4">                     
    <form:textarea class="form-control" id="textarea" path="pdesc" name="textarea"></form:textarea>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <form:label class="col-md-4 control-label"  path="price" for="textinput">price</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text"  path="price" placeholder="" class="form-control input-md" />
    
  </div>
</div>

<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="pcolor">product color</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="pcolor" placeholder="" class="form-control input-md" />
    
  </div>
</div>

<!-- File Button --> 
<div class="form-group">
  <form:label class="col-md-4 control-label"  path="image" for="filebutton">Upload image</form:label>
  <div class="col-md-4">
    <form:input path="image" class="input-file" type="file" />
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">add</button>
  </div>
</div>


</form:form>

</div>