<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 	  <div class="container">

        <div class="row">

            <div class="col-md-3">
                <!-- <p class="lead">Shop Name</p>
                <div class="list-group">
                    <a href="#" class="list-group-item">TV</a>
                    <a href="#" class="list-group-item">MOBILE</a>
                    <a href="#" class="list-group-item">LAPTOP</a>
                </div> -->
                <%@include file="./shared/sidebar.jsp"%>
            </div>
 

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="${images}/lap123.jpg" alt="">
                                </div>
                                <div class="item">
                                 <img src="${images}/Mob13.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img src="${images}/tv31.jpg" alt="" width="800px" height="300px">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                                   </a>
                        </div>
                    </div>

                </div>

                <div class="row">
				<c:forEach items="${products}" var="product">
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                              <a href="${contextroot}/productdetails/${product.pid}"><img src="${product.pimage}" alt="dsafsg" width="200px" height="100px" /></a>
                            <div class="caption">
                                <h4 class="pull-right">&#8377;${product.price}</h4>
                                <h4><a href="${contextroot}/productdetails/${product.pid}">${product.pname}</a>
                                </h4>
                                <p>${product.pdesc}</p>
                            </div>
                           <div>
                           <a href="${contextroot}/user/addToCart/${product.pid}" class="btn btn-primary">Add to Cart</a>
                                   
                            </div>
                        </div>
                        </div>
                    
				</c:forEach>