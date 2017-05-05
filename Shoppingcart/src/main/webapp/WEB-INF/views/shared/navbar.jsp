<!-- Navigation -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextroot}/home">online
				Shopping</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="${contextroot}/about">About</a></li>
				<li><a href="${contextroot}/contact">Contact</a></li>
				<%-- <li id="listProducts"><a href="${contextroot}/show/all/products">View Products</a></li> --%>
				
			</ul>
			<c:if test="${pageContext.request.userPrincipal.name != null }">
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<ul class="nav navbar-nav">

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextroot}/admin/addcategory">Add
										Category</a></li>

								<li><a href="${contextroot}/admin/viewcategory">View
										Category</a></li>
							</ul></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Supplier <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextroot}/admin/addsupplier">Add
										Supplier</a></li>

								<li><a href="${contextroot}/admin/viewsupplier">View
										Supplier</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Product <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextroot}/admin/addproduct">Add
										Product</a></li>

								<li><a href="${contextroot}/admin/viewproduct">View
										Product</a></li>
							</ul></li>
							
							<ul class="nav navbar-right navbar-nav">

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">${pageContext.request.userPrincipal.name }
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								
								<li><a href="${contextroot}/logout">Log Out</a></li>
							</ul></li>
					</ul>
					</ul>
				</security:authorize>
			</c:if>




			<c:if test="${pageContext.request.userPrincipal.name == null }">


				<ul class="nav navbar-right navbar-nav">
					<li><a href="${contextroot}/login">login</a></li>
				</ul>
				<ul class="nav navbar-right navbar-nav">
					<li><a href="${contextroot}/registration">Register</a></li>
				</ul>

			</c:if>

			<!-- user  -->

			<c:if test="${pageContext.request.userPrincipal.name != null }">
				<security:authorize access="hasRole('ROLE_USER')">

					<ul class="nav navbar-right navbar-nav">
						<li>
							<a href="${contextroot}/mycart">Cart</a>
						</li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">${pageContext.request.userPrincipal.name }
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="${contextroot}/user/myAccount/${userid}">Account</a></li>

								<li><a href="${contextroot}/user/changeAddress">Addresses</a></li>
								<li><a href="${contextroot}/user/personaldetails">Personal Details</a></li>
								<li><a href="${contextroot}/user/manageAddress">Shipping Address</a></li>
								<li><a href="${contextroot}/user/orderDetails">Orders</a></li>
								<li><a href="${contextroot}/logout">Log Out</a></li>
							</ul></li>
					</ul>
				</security:authorize>
			</c:if>



		</div>

	</div>

</nav>