<%@page import="model.product"%>
<%@page import="model.Orders"%>
<%@page import="util.stringUtils"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/stylesheet/admin.css">
</head>
	<body>
  <div class="sidebar">
    <div class="logo">
      <img src="${pageContext.request.contextPath}/views/images/logo.png" alt="">
    </div>
    <nav>
      <ul style="margin-top: 15%;">
        <li><a href="#add-product-section" class="active">Add Product</a></li>
        <li><a href="#view-product-section">View Product</a></li>
        <li><a href="#see-orders-section">See Orders</a></li>
        <li><a href="#view-messages-section">View Messages</a></li>
      </ul>
    </nav>
    <button class="logout-btn" type="submit">Logout</button>
  </div>
  <div class="content">
    <h1 style="color: #2e6063; margin-top: -0.5%;">Sell Phone Admin Dashboard</h1>
    <div class="container">
      <h2 id="add-product-section">Add New Product For Website</h2>
      <form id="add-product-form" action="${pageContext.request.contextPath}/prodAndHomeServlet" method="post"
      enctype="multipart/form-data">
        <input type="text" placeholder="Product Name" name="productName">
        <input type="text" placeholder="Brand" name="brand">
        <input type="number" placeholder="Stock" name="stock">
        <input type="number" placeholder="Price" name="price">
        <textarea placeholder="Description" name="description"></textarea>
        <input type="text" placeholder="RAM" name="ram">
        <input type="text" placeholder="ROM" name="rom">
        <input type="text" placeholder="Processor" name="processor">
        <input type="file" placeholder="Media" name="productImage">
        <input type="submit" value="Submit">
      </form>
    </div>
    
    <h2 id="view-product-section">View Products</h2>
    <table class="view-products">
      <tr class="productTable">
      	<th>Image</th>
        <th>Name</th>
        <th>Brand</th>
        <th>RAM</th>
        <th>ROM</th>
        <th>Processor</th>
        <th>Stock</th>
        <th>Price</th>
        <th>Action</th>
      </tr>
      <% 
    List<product> pl = (List<product>) request.getAttribute("products");
    if (pl != null) {
        for (product pp : pl) {
%>
	<tr class="productRow">
	        <td class="admin-prodImg"> <img src="${pageContext.request.contextPath}/views/images/productImage/<%= pp.getImageUrlFromPart() %>" ></td>
	        <td><%= pp.getName() %></td>
	        <td><%= pp.getBrand() %></td>
	        <td><%= pp.getRAM() %> GB</td>
	        <td><%= pp.getROM() %> GB</td>
	        <td><%= pp.getProcessor() %></td>
	        <td> <%= pp.getStock() %></td>
	        <td>$ <%= pp.getPrice() %></td>
	        <td>
	        	<button class="edit">Edit</button>
	        	<button class="delete">Delete</button>
	        </td>
      </tr>
<%
        }
    }
%>
  </table>
      <!-- Add more rows with random values here -->

     <h2>All Orders</h2>
    <table>
            <tr>
                <th>Order ID</th>
                <th>Product ID</th>
                <th>User ID</th>
                <th>Product Name</th>
                <th>Status</th>
                <th>Date</th>
                <th>Quantity</th>
            </tr>
            <% 
            List<Orders> ord = (List<Orders>) request.getAttribute("orders");
            if (ord != null) {
                for (Orders or : ord) {
            %>
                <tr>
                    <td><%= or.getOrderId() %></td>
                    <td><%= or.getProductId() %></td>
                    <td><%= or.getUserId() %></td>
                    <td><%= or.getProductName() %></td>
                    <td>
                    	<select name="status">
                    		<option><%= or.getOrderStatus() %></option>
                    		<option>Delivered</option>
                    	</select>
                    </td>
                    <td><%= or.getOrderDate() %></td>
                    <td><%= or.getQuantity() %></td>
                </tr>
            <% } }%>
    </table>
   
   
   
    
    <h2 id="view-messages-section">View Messages</h2>
    <table id="view-messages">
      <tr>
        <th>Phone</th>
        <th>Email</th>
        <th>Message</th>
      </tr>
      <tr>
        <td>123-456-789</td>
        <td>example@example.com</td>
        <td>Hello! I have a question...</td>
      </tr>
      <!-- Add more rows with random values here -->
    </table>
  </div>

  <script>
    document.addEventListener('DOMContentLoaded', function () {
      var links = document.querySelectorAll('.sidebar ul li a');

      links.forEach(function(link) {
        link.addEventListener('click', function(event) {
          event.preventDefault(); // Prevent default link behavior
          var targetId = this.getAttribute('href'); // Get the target section ID
          var targetSection = document.querySelector(targetId); // Find the target section
          if (targetSection) {
            targetSection.scrollIntoView({ behavior: 'smooth' }); // Scroll to the target section smoothly
          }
        });
      });
    });
  </script>
</body>
</html>