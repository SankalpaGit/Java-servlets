<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.product"%>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
</head>
<body>
		<h2>Search Results</h2>
    	
    	<% 
    List<product> searchResults = (List<product>) request.getAttribute("searchResults");
    
    if (searchResults != null && !searchResults.isEmpty()) { 
    %>
        <div class="product-cards">
            <% for (product product : searchResults) { %>
                <div class="product-card">
                    <div class="product-image">
                        <a href="${pageContext.request.contextPath}/ProductDetailServlet?productId=<%= product.getId() %>">
                            <img src="${pageContext.request.contextPath}/views/images/productImage/<%= product.getImageUrlFromPart() %>" alt="<%= product.getDescription() %>">
                        </a>
                    </div> 
                    <h2><%= product.getName() %></h2>
                    <p class="price">$ <%= product.getPrice() %></p>
                    <form action="AddToCartServlet" method="post">
                        <input type="hidden" name="productId" value="<%= product.getId() %>">
                        <button class="add-to-cart">Add to Cart</button>
                    </form>
                </div>
            <% } %>
        </div>
    <% } else { %>
        <p>No results found.</p>
    <% } %>
    	
</body>
