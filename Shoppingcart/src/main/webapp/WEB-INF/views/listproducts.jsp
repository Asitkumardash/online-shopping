
   
   <div class="container">
		
    	
    	
    	<!-- Added breadcrumb -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts==true}">
					<ol class="breadcrumb">
						<li><a href="${contextroot}/home">Home</a></li>
						<li class="active">All Products</li>
					</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts==true}">
					<ol class="breadcrumb">
						<li><a href="${contextroot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
					</ol>
					</c:if>
				</div>
			</div>
		<!-- Ended breadcrumb -->
			
			
			<!-- To display sidebar -->
			<div class="col-md-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
						Brands
						</h3>
					</div>
					<div class="panel-body">
						
						 <%-- <%@include file="sidebar.jsp" %> --%> 		
					 <%@include file="./shared/sidebar.jsp"%> 
					</div>
				</div>
			</div>
			
			<!-- to display products -->
			<div class="col-md-9">
				<div class="panel panel-default">
					<!-- <div class="panel-heading">
						<h3 class="panel-title">Category Query</h3>
					</div> -->
					<div class="panel-body">
						<div class="row">
						  
						  <c:forEach items="${products}" var="product">
						  
						  <div class="col-sm-6 col-md-4">
						    <div class="thumbnail">
						      <a href="${contextroot}/productdetails/${product.pid}"><img src="${product.pimage}" alt="${product.pname}"></a>
						      <div class="caption">
						        <p class="thumbp">
						        <a href="${contextroot}/productdetails/${product.pid}" > ${product.pname}</a></p>
						       
						        <p class="productprice"><span class="rupeesymbol">&#8377;</span>${product.price}</p>
						        </div>
						    </div>
						  </div>
						  
						  </c:forEach>
						  <c:forEach items="${catProducts}" var="product">
						 
						  <div class="col-sm-6 col-md-4">
						    <div class="thumbnail">
						      <a href="${contextroot}/productdetails/${product.pid}"><img src="${product.pimage}" alt="${product.pname}"></a>
						      <div class="caption">
						        <p class="thumbp">
						        <a href="${contextroot}/productdetails/${product.pid}" > ${product.pname}</a></p>
						       
						        <p class="productprice"><span class="rupeesymbol">&#8377;</span>${product.price}</p>
						        </div>
						    </div>
						  </div>
						 
						  </c:forEach>
						  
						</div>
					</div>	
				</div>
			</div>

		</div>