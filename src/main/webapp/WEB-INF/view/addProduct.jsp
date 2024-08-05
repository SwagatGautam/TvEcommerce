<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!----======== CSS ======== -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/style.css">
    <title>Add Products</title>
    <!----===== Iconscout CSS ===== -->
    <link href="${pageContext.request.contextPath}/stylesheets/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/stylesheets/sb-admin-2.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/stylesheets/form.css" rel="stylesheet">

</head>
<body>
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Infinity</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item ">
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
            <li class="nav-item active">
                <a class="nav-link"href="<%=request.getContextPath() %>/addProduct"  >
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
                <a class="nav-link collapsed" href="<%=request.getContextPath() %>/logout" >
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Users</span>
                </a>
            </li>
        </ul>
        <div class="right">
        <div class="productadd">
        <form action="<%=request.getContextPath() %>/addProduct"  method="post" enctype="multipart/form-data">
            <h1>Add Products</h1>
            <input type="text" placeholder="Product Name" name = "productName">
            <input type="text" placeholder="Product Description" name = "productDescription">
            <input type="file" name="image" accept="image/*">
            <div class="row">
                <div class="col">
                    <input type="text" placeholder="Product Quantity" name="quantity">
                </div>
                <div class="col">
                    <input type="text" placeholder="Product Price" name="price">
                </div>
            </div>
            
            <div class="row">
                <div class="col">

                        <select id="screenSize" name="screenSize" required name="screenSize" style="width: 150px;">
                            <option value="16 X 14  ">16 X 14  </option>
                            <option value="32 X 20">32 X 20</option>
                        </select>
                </div>
                <div class="col">
                    <select id="brand" name="brand" required name="brand" style="width: 150px;">
                        <option value="Samsung">Samsung</option>
                        <option value="LG">L.G</option>
                        <option value="others">Others</option>
                    </select>
            </div>
            </div>

        <button type="submit">Add</button>
        </form>
        </div>
    </div>
    </div>
    

    
</body>
</html>