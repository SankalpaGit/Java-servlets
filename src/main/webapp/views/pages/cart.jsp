<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.cart"%>
<%@page import="util.stringUtils"%>
<%@page import="java.util.List"%>

<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/stylesheet/cart.css">
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
        <div class="icons">
            <a href=""><i class="fas fa-shopping-cart fa-xl" style="color: #000000;"></i></a>
            <a href=""><i class="fas fa-bell fa-xl" style="color: #000000;"></i></a>
            <a href=""><i class="fas fa-user fa-xl" style="color: #000000;"></i></a>
        </div>
    </header>

<div class="container">
    <div class="cart-items">
        <% 
            List<cart> cartItems = (List<cart>) request.getAttribute("cartItems");
            if (cartItems != null) {
                for (cart item : cartItems) { 
        %>
                    <div class="product">
                        <div class="item-image">
                            <img src="${pageContext.request.contextPath}/views/images/productImage/${item.getProductImage()}">
                        </div>
                        <div class="item-details">
                            <p class="item-desc"><%= item.getProductName() %></p>
                            <p class="item-price">$<%= item.getPice() %></p> <!-- corrected method name -->
                            <form action="UpdateCartQuantityServlet" method="post">
                            <input type="number" name="quantity_<%= item.getProductId() %>" value="<%= item.getQuantity() %>">
                            </form>
                        </div>
                        <div class="item-remove">
                            <button class="remove-btn">X</button>
                        </div>
                    </div>
                    
            <% 
                }
            } 
        %>
    </div>
    
    <div class="checkout-buttons"> 
    <form action="OrderInsertServlet" method="post">  
        <button class="checkout-btn">Buy Now</button> 
         </form>    
    </div>
     
</div>

    <% if (request.getAttribute("successMessage") != null) { %>
    <div class="success-message">
        <%= request.getAttribute("successMessage") %>
    </div>
	<% } %>


	<% if (request.getAttribute("errorMessage") != null) { %>
    <div class="error-message">
        <%= request.getAttribute("errorMessage") %>
    </div>
	<% } %>

</body>
