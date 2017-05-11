<div class="panel panel-default">
  <div class="panel-heading">Select payment mode</div>
  <div class="panel-body">
  	<form:form class="form" modelAttribute="orderData">
						
							<div class="form-group">	
								<form:radiobutton path="paymentMode" value="ONLINE"/>Pay Online<br>
								<form:radiobutton path="paymentMode" value="COD"/>Cash on Delivery
							</div>
						 	
						 	
						 <div class="well text-center">
							<input type="submit" class="btn btn-primary" value="Proceed">	
						 </div>
	</form:form>
  
  </div>
</div>