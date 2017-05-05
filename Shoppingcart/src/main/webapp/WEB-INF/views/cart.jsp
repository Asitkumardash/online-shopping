<c:if test="${cartamt >0}">
<table class="table">
	<thead>
	<tr>
		<th class="col-md-2">
			Items
		</th>
		<th class="col-md-4"></th>
		<th class="col-md-1">Price</th>
		<th class="col-md-1">Quantity</th>
		<th class="col-md-2">Subtotal</th>
		<th class="col-md-2">Edit</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${cilist}" var="cartitem">
		<tr>
			<td><img src="${cartitem.product.pimage}" alt="" width="200px" ></td>
			<td><h4>${cartitem.product.pname}</h4><p>${cartitem.product.pdesc}</p></td>
			<td>${cartitem.product.price}</td>
			<td>${cartitem.cquantity}</td>
			<td>${cartitem.ctotal}</td>
			<td><a href="${contextroot}/user/removeCartItem/${cartitem.itemid}" class="btn btn-primary">Remove</a></td>
		</tr> 
	</c:forEach>
	</tbody>
</table>

<div class="panel">
	<div class="panel-body">
		<p>Total &#8377; ${cartdata.totalcost}</p><a href="${contextroot}/selectAddress">Place order</a>
	</div>

</div>



</c:if>

