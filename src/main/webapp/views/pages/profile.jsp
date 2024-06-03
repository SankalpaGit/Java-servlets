<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Orders" %>
   <%@ page import="java.util.List" %>

<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/stylesheet/profile.css">
<script src="https://kit.fontawesome.com/6a838dbad0.js" ></script>
</head>
<body>
	
  <header>
    <div class="logo">
      <a href=""><img src="${pageContext.request.contextPath}/views/images/logo.png" alt="logos"></a>
    </div>

    <div class="icons">
      <a href=""><i class="fas fa-shopping-cart fa-xl" style="color: #000000;"></i></a>
      <a href=""><i class="fa-solid fa-circle-info fa-lg" style="color: #000000;"></i></a>
      <a href=""><i class="fas fa-user fa-xl" style="color: #000000;"></i></a>
    </div>
  </header>
  <section class="profile-container">
    <section class="profile">
      <div class="profile-box">
      <a href="editProfile.jsp">
        <button class="edit-profile-btn">Edit Profile</button>
        </a>
        <h1>Personal Details</h1>
        <div class="user-details">
          <p>FirstName  LastName</p>
          <p>demo@hotmail.com</p>
          <p>98555555556</p>
          <p>description</p>
          
          <form action="${pageContext.request.contextPath}/LogOutServlet" method="post">
    <button type="submit">Log Out</button>
</form>

        </div>
      </div>
    </section>

<section class="order-history">
  <div class="order-history-box">
    <h1>Order History</h1>
    <div class="order-details">
      <% List<Orders> userOrders = (List<Orders>) request.getAttribute("userOrders");
         if (userOrders != null && !userOrders.isEmpty()) {
             for (Orders order : userOrders) { %>
                 <div class="ordered-product">
                     <div class="order-info">
                         <span class="order-id">Product Name: <%= order.getProductName() %></span>
                         <span class="status">Status: <%= order.getOrderStatus() %></span>
                     </div>
                     <!-- Add additional order information as needed -->
                 </div>
      <%     }
         } else { %>
             <p>No orders found.</p>
      <% } %>
    </div>
  </div>
</section></section>
</body>
</html>