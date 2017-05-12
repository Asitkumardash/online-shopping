<div class="panel panel-default">
							  	<div class="panel-heading">
									<h3 class="panel-title">Select address</h3>
								</div>
								<div class="panel-body">
										<div class="row">
										<c:forEach items="${addresses}" var="addresses">
										<form:form role="form">
										  <div class="col-sm-6 col-md-4">
										    <div class="thumbnail">
										     
											        <p>${addresses.add1},</p>
											        <p>${addresses.add2},</p>
											        <p>${addresses.add3},</p>
											        <p>${addresses.city},</p>
											        <p>${addresses.state},</p>
											        <p>${addresses.pincode}</p>
											        
														
		                        <%--  <form:radiobutton path="address.addid" value="${addresses.addid}"/>
								<input type="submit" class="btn btn-default" value="Deliver here">
								 --%>
								 <a href="${contextroot}/user/addressSelected/${addresses.addid}" class="btn btn-primary">Deliver here</a>
										
										    </div>
										  </div>
										  </form:form>
										</c:forEach>
										  
										</div>
										


								</div>

						</div>