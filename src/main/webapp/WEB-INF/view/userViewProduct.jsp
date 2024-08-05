<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!----======== CSS ======== -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/style.css">
    <title>Products</title>
    <!----===== Iconscout CSS ===== -->
    <link href="${pageContext.request.contextPath}/stylesheets/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/stylesheets/sb-admin-2.min.css" rel="stylesheet">
<title>Products</title>
</head>
<body>
<!-- 
<a href="${pageContext.request.contextPath}/cart" >cart</a>
<table border="1">
<thead>
       <tr>
           <th>Product Name</th>
           <th>Description </th>
           <th>Quantity</th>
           <th>Brand</th>
           <th>Price</th>
           <th>Screen size</th>
           <th>Product Image</th>
           <th>Edit</th>
           <th>Delete</th>
</tr>
</thead>
           <tbody>
                 <c:forEach var="product" items="${listOfProduct}">
                 <tr>
                     <td><c:out value="${product.productName }"></c:out></td>
                     <td><c:out value="${product.productDescription}"></c:out></td>
                     <td><c:out value="${product.quantity }"></c:out></td>
                     <td><c:out value="${product.brand }"></c:out></td>
                     <td><c:out value="${product.price }"></c:out></td>
                     <td><c:out value="${product.screenSize }"></c:out></td>
                     <td><c:out value="${product.productImage }"></c:out></td>
                     
                    <td>
                    <form action="<%=request.getContextPath()%>/addToCart" method="post">
    				<input type="hidden" name="id" value="${product.id }">
    				<button type="submit">Add to Cart</button>
					</form>
					</td>
                 </tr>
                 
                 </c:forEach>
           </tbody>



</table> -->
 
    <div class="container">
        <div class="card-header my-3">All Products</div>
        <div class="row">
                <c:forEach var="product" items="${products}">
                    <div class="col-md-3 my-3">
                        <div class="card w-100">
                            <img class="card-img-top" src="product-image/" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">${product.getProductName()}</h5>
                                <h6 class="price">Price: ${product.getPrice()}</h6>
                                <h6 class="category">Category: ${product.getBrand()}</h6>
                                <div class="mt-3 d-flex justify-content-between">
                    <form action="<%=request.getContextPath()%>/addToCart" method="post">
    				<input type="hidden" name="productId" value="${product.id }">
    				<button type="submit">Add to Cart</button>
					</form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
        </div>
    </div>
</body>
</html>