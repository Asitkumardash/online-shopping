
  <div class="container">
  <h2>View product</h2>
            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
         <th>CID</th>
          <th>Price</th>
           <th>Images</th>
            <th>Color</th>
             <th>Delete/Edit</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${product}" var="product" >
      <tr>
        <td class="col-md-1">${product.pid}</td>
        <td class="col-md-2">${product.pname}</td>
         <td class="col-md-3">${product.pdesc}</td>
           <td class="col-md-1">${product.cid}</td>
           <td class="col-md-1">${product.price}</td>
            <td class="col-md-2 "><img src="${product.pimage}" width="100px"></td>
             <td class="col-md-2">${product.pcolor}</td>
        
        <td class="col-md-2"><a class="btn btn-primary" href="${contextroot}/admin/productDelete/${product.pid}">Delete</a> <a class="btn btn-primary" href="${contextroot}/admin/productEdit/${product.pid}">Edit</a></td>
      </tr>
      </c:forEach>
      
        </tbody>
  </table>
</div>
  
