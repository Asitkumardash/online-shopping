<div class="panel panel-default">
	<h3>Confirm Purchase</h3>
	<hr />
	<div class="panel-body">
		<div class="col-md-4">
				<p>${user.fname} ${user.lname}</p><p>Phone: ${user.pno}</p>
				</div>
				<div class="col-md-4">
				
				<p>Billing Address</p>
				<p>${user.add1}</p>
				<p>${user.add2}</p>
				<p>${user.add3}</p>
				<p>${user.city}</p>
				<p>${user.state}</p>
				<p>${user.pincode}</p>
				</div>
				
				<div class="col-md-4">
				
				<p>Shipping Address</p>
				<p>${orderstuff.address.add1}</p>
				<p>${orderstuff.address.add2}</p>
				<p>${orderstuff.address.add3}</p>
				<p>${orderstuff.address.city}</p>
				<p>${orderstuff.address.state}</p>
				<p>${orderstuff.address.pincode}</p>
				</div>
				
		
	
	</div>


</div>
<div class="panel panel-default">
			<!-- <div class="panel-heading">
			    <h3 class="panel-title">
			    	Order summary
			    </h3>
			</div> -->
			  <table class="table">
				            <thead>
				              <tr>
				                
				                <th class="col-md-2 col-xs-2"></th>
				                <th class="col-md-6 col-xs-6"></th>
				                <th class="col-md-1 col-xs-1">Price</th>
				                <th class="col-md-1 col-xs-1">Quantity</th>
				                <th class="col-md-1 col-xs-1">Delivery charges</th>
				                <th class="col-md-1 col-xs-1">Subtotal</th>
				              </tr>
				              
				            </thead>
				            <tbody>
				            <c:forEach items="${clist}" var="cartitem">
				            <tr>
				            	<td class="col-md-2"><img src="${cartitem.product.pimage}" alt="image here"></td>
				            	<td class="col-md-6">${cartitem.product.pname}<p>${cartitem.product.pdesc}</p></td>
				            	<td class="col-md-1">${cartitem.product.price}</td>
				            	<td class="col-md-1">${cartitem.cquantity}</td>
				            	<td class="col-md-1">Free</td>
				            	<td class="col-md-1">${cartitem.ctotal}</td>
				            </tr>
				            </c:forEach>
				            </tbody>
				            
				       </table>
				       
				       </div>
				       
				       <div class="panel panel-default">
				       		<div class="panel-body">
				       			<p>Subtotal: ${orderstuff.amount}</p>
				       			<p><a href="${contextroot}/paymentMode" class="btn btn-primary">Proceed to pay</a></p>
				       		</div>
				       </div>