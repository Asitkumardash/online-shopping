<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="${css}/asit5.css" rel="stylesheet">
<link href="${css}/asit5.js" rel="stylesheet">
<div class="container">
	<div class="row">
   <div class="col-xs-4 item-photo">
                    <img style="max-width:100%;" width="500px" height="200px" src="${product.pimage}" />
                </div>
                <div class="col-xs-5" style="border:0px solid gray">
                    
                    <h3>${product.pname}</h3>    
                    <h5 style="color:#337ab7">${product.pdesc}</h5>

                    <!-- Precious -->
                    
                    <h3 style="margin-top:0px;">&#8377;${product.price}</h3>

                    
                    <div class="section">
                        <h6 class="title-attr" style="margin-top:15px;" ><small>COLOR</small></h6>                    
                        <div>
                            <div class="attr" style="width:25px;background:#5a5a5a;"></div>
                            <div class="attr" style="width:25px;background:white;"></div>
                        </div>
                    </div>
                    <div class="section" style="padding-bottom:5px;">
                        <h6 class="title-attr"><small>CAPACIDAD</small></h6>                    
                        <div>
                            <div class="attr2">16 GB</div>
                            <div class="attr2">32 GB</div>
                        </div>
                    </div>   
                    <div class="section" style="padding-bottom:20px;">
                        <h6 class="title-attr"><small>CANTIDAD</small></h6>                    
                        <div>
                            <div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>
                            <input value="1" />
                            <div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>
                        </div>
                    </div>                

                    <!-- Botones de compra -->
                    <div class="section" style="padding-bottom:20px;">
                       <a href="${contextroot}/user/addToCart/${product.pid}" class="btn btn-primary">Add to Cart</a>
                        <h6><a href="#"><span class="glyphicon glyphicon-heart-empty" style="cursor:pointer;"></span> Agregar a lista de deseos</a></h6>
                    </div>                                        
                </div>                              

                <div class="col-xs-9">
                    <ul class="menu-items">
                        <li class="active">Detalle del producto</li>
                        <li>Garant�a</li>
                        <li>Vendedor</li>
                        <li>Env�o</li>
                    </ul>
                    <div style="width:100%;border-top:1px solid silver">
                        <p style="padding:15px;">
                            <small>${product.pdesc}</small>
                        </p>
                        <small>
                        <ul>
                            
                        </ul>  
                        </small>
                    </div>
                </div>		
	</div>
</div>