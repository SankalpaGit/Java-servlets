<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.product"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/stylesheet/prodOver.css">
<script src="https://kit.fontawesome.com/6a838dbad0.js" ></script>
</head>
<body>
	<header>
    <div class="logo">
        <a href=""><img src="${pageContext.request.contextPath}/views/images/logo.png" alt="logos"></a>
    </div>
    <div class="searchbox">
        <input type="text" class="S_text" placeholder="What are you looking for......">
        <button class="S_btn"><i class="fas fa-search"></i></button>
    </div>
        <button class="filter"><i class="fa-solid fa-square-caret-down fa-lg" style="color: #000000;"></i></button>
    <div class="icons">
        <a href=""><i class="fas fa-shopping-cart fa-xl" style="color: #000000;"></i></a>
        <a href=""><i class="fas fa-bell fa-xl" style="color: #000000;"></i></a>
        <a href=""><i class="fas fa-user fa-xl" style="color: #000000;"></i></a>
    </div>
</header>

<nav>
    <ul>
        <li><a href="#"><i class="fa-solid fa-house fa-lg" style="color: #000000;"></i>  Home</a></li>
        <li><a href="#"><i class="fa-solid fa-cart-shopping fa-lg" style="color: #000000;"></i>  Cart</a></li>
        <li><a href="#"><i class="fa-solid fa-circle-info fa-lg" style="color: #000000;"></i>  About Us</a></li>
        <li><a href="#"><i class="fa-regular fa-user fa-lg" style="color: #000000;"></i>  Profile</a></li>
        
    </ul>
</nav>

 <div class="outer-containers">
    <% product product = (product) request.getAttribute("product"); %>
    <% if (product != null) { %>
        <div class="imagesProduct">	
			<img src="${pageContext.request.contextPath}/views/images/productImage/<%= product.getImageUrlFromPart() %>" >
        </div>
        <div class="product details">
        	<h2><%= product.getBrand() %></h2>
            <h2><%= product.getName() %></h2>
            <p> $ <%= product.getPrice() %></p>
            <p><%= product.getDescription() %></p>
            <p><%= product.getRAM() %></p>
            <p><%= product.getROM() %></p>
            <p><%= product.getProcessor() %></p>
            <!-- Add more details here as needed -->
            <button class="cartButton">Add to Cart</button>
            <button class="buyButton">Buy Now</button>
        </div>
    <% } else { %>
        <p>Product not found.</p>
    <% } %>
</div>
    <!-- Add more details as needed -->
</body>
</html>