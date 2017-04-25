
  <div class="container">
  <h2>View categories</h2>
            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Edit</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${categories}" var="category">
      <tr>
        <td class="col-md-4">${category.name}</td>
        <td class="col-md-6">${category.description}</td>
        <td class="col-md-2"><a class="btn btn-primary" href="${contextroot}/admin/categoryDelete/${category.id}">Delete</a> <a class="btn btn-primary" href="${contextroot}/admin/categoryEdit/${category.id}">Edit</a></td>
      </tr>
      </c:forEach>
        </tbody>
  </table>
</div>
  
