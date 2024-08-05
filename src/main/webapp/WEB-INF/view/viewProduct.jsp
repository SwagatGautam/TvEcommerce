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
    <title>Admin</title>
    <!----===== Iconscout CSS ===== -->
    <link href="${pageContext.request.contextPath}/stylesheets/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/stylesheets/sb-admin-2.min.css"rel="stylesheet">
<title>View Products</title>
</head>
<body>

    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Infinity</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="<%=request.getContextPath() %>/admin">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath() %>/addProduct" >
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Add Products</span>
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="<%=request.getContextPath() %>/product" >
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>View Products</span>
                </a>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="orders.html" >
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>View Orders</span>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link collapsed" href="users.html" >
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Users</span>
                </a>
            </li>         
        </ul>
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
                    <form action="<%=request.getContextPath()%>/editProduct" method="post">
    				<input type="hidden" name="id" value="${product.id }">
    				<button type="submit">Edit</button>
					</form>
					</td>
                    <td>
                    <form action="<%=request.getContextPath()%>/deleteProduct" method="post">
					    <input type="hidden" name="id" value="${student.id}">
					    <button type="submit">Delete</button>
					</form>
					</td>
                 </tr>
                 
                 </c:forEach>
           </tbody>



</table>
</div>
</body>
</html>