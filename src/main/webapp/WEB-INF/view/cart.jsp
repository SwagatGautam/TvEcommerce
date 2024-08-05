<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cart Details</title>
</head>
<body>
    <h1>Cart Details</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>User ID</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cartList}" var="cartItem">
                <tr>
                    <td>${cartItem.productId}</td>
                    <td>${cartItem.product.productName}</td>
                    <td>${cartItem.userId}</td>
                    <td>                    
                    	<form action="<%=request.getContextPath()%>/reduceItem" method="post">
                    	<input type = "hidden" value="${cartItem.productId}" name="productId">
							<button type="submit" >-</button>
						</form>
					</td>
                    <td>${cartItem.cartQuantity}</td>
                    <td>                    
                    	<form action="<%=request.getContextPath()%>/increaseItem" method="post">
                    	<input type = "hidden" value="${cartItem.productId}" name="productId">
							<button type="submit" >+</button>
						</form>
					</td>
                    <td>                    
                    	<form action="<%=request.getContextPath()%>/removeItem" method="post">
                    	<input type = "hidden" value="${cartItem.productId}" name="productId">
							<button type="submit" >Remove</button>
						</form>
					</td>

                </tr>
                        
            </c:forEach>
        </tbody>
    </table>
        <form action="<%=request.getContextPath()%>/checkout" method="post">
			<button type="submit" >Checkout</button>
		</form>
</body>
</html>
