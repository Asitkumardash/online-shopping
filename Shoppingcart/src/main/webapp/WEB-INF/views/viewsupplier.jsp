 
  <div class="container">
  <h2>View suppliers</h2>
             
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Edit</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${suppliers}" var="supplier">
      <tr>
        <td class="col-md-4">${supplier.supname}</td>
        <td class="col-md-6">${supplier.supdescription}</td>
        <td class="col-md-2"><a class="btn btn-primary" href="${contextroot}/admin/supplierDelete/${supplier.supid}">Delete</a> <a class="btn btn-primary" href="${contextroot}/admin/supplierEdit/${supplier.supid}">Edit</a></td>
      </tr>
      </c:forEach>
        </tbody>
  </table>
</div>
  
