<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="${css}/asit4.css" rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="lead">Shop Name</p>
<div class="list-group">

<c:forEach items="${categories}" var="category">
	<a href="${contextroot}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a> 
	
</c:forEach>

</div>