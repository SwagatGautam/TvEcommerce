<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order Details</title>
</head>
<body>
    <h1>Order Details</h1>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Unit Price</th>
            <th>Quantity</th>
            <th>Status</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.userId}</td>
                <td>${order.productId}</td>
                <td>${order.productName}</td>
                <td>${order.unitPrice}</td>
                <td>${order.quantity}</td>
                <td>${order.status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
