<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>

Welcome , 
<form action="<%=request.getContextPath()%>/logout" method="post">
<button type="submit" >Logout</button>
</form>

<form action="<%=request.getContextPath()%>/editProfile" method="post">
<button type="submit" >Edit profile</button>
</form>

</body>
</html>