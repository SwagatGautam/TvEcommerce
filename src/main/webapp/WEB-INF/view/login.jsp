<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/register.css"/>
</head>
<body>

    <div class="container" id="container">
        <div class="form-container sign-in">
            <form action="<%=request.getContextPath() %>/login" method="post">
            		<% 
						if(request.getAttribute("error")!=null){
							%> <p style="color:red"><%=request.getAttribute("error") %>></p>
						<%}
						%>
                <h1>Log in</h1>
                <input type="text" placeholder="Username" id="Username" name="username">
                <input type="password" placeholder="Password" id="password" name ="password">
                <a href="#">Forgot Your Password?</a>
                <button type="submit" name ="login">Login</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-right">
                    <h1>Infinity Stores</h1>
                    <p>Register with personal details to proceed further</p>
                    <a href="<%=request.getContextPath()%>/register">Register</a>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/script/script.js"></script>
</body>
</html>