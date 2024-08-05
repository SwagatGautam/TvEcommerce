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
    <title>Admin</title>
    <!----===== Iconscout CSS ===== -->
    <link href="${pageContext.request.contextPath}/stylesheets/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/stylesheets/sb-admin-2.min.css"rel="stylesheet">

</head>
<body>
    <div id="wrapper" style="color: red;">

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
            
                        <!-- Nav Item - Utilities Collapse Menu -->
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
                    <span>Logout</span>
                </a>
            </li>
            
            
        </ul>
    <section class="dashboard">
    <form action="<%=request.getContextPath()%>/logout" method="post">
<button type="submit" >Logout</button>
</form>
        <div class="dash-content">
            <div class="overview">
                <div class="title">
                    <i class="uil uil-tachometer-fast-alt"></i>
                    <span class="text">Dashboard</span>
                </div>

                <div class="boxes">
                    <div class="box box1">
                        <i class="uil uil-thumbs-up"></i>
                        <span class="text">Total Products</span>
                        <span class="number">50,120</span>
                    </div>
                    <div class="box box2">
                        <i class="uil uil-comments"></i>
                        <span class="text">Total Users</span>
                        <span class="number">20,120</span>
                    </div>
                    <div class="box box3">
                        <i class="uil uil-share"></i>
                        <span class="text">Total Orders</span>
                        <span class="number">10,120</span>
                    </div>
                </div>
            </div>   
        </div>
    </section>
    </div>
    
</body>
</html>
