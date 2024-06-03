<%@page import="model.product"%>
<%@page import="util.stringUtils"%>
<%@page import="java.util.List"%>
<%@ page import="javax.servlet.jsp.PageContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<head>
<meta charset="UTF-8">
<title>Home-Sell Phone</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/stylesheet/home.css">
<script src="https://kit.fontawesome.com/6a838dbad0.js" ></script>
</head>
<body>  
    <header>
        <div class="logo">
            <a href=""><img src="${pageContext.request.contextPath}/views/images/logo.png"  alt="logos"></a>
        </div>
        <div class="searchbox">
        	<form action="${pageContext.request.contextPath}/SearchProductServlet" method="get">
           	 	<input type="text" class="S_text" placeholder="What are you looking for......">
            	<button type="submit" class="S_btn"><i class="fas fa-search"></i></button>
            </form>
        </div>
        <div class="icons">
            <a href="/SellPhone/CartDisplayServlet"><i class="fas fa-shopping-cart fa-xl" style="color: #000000;"></i></a>
            <a href="${pageContext.request.contextPath}/views/pages/about.jsp"><i class="fa-solid fa-circle-info fa-lg" style="color: #000000;"></i></a>
            <a href="/SellPhone/OrderHistoryServlet"><i class="fas fa-user fa-xl" style="color: #000000;"></i></a>
        </div>
    </header>


    <!-- Slider Section -->
<div class="slider">
    <div class="slide active">
        <img src="${pageContext.request.contextPath}/views/images/slide1.jpg" alt="Image 1">
        <div class="info">
            <a href="#" class="btn">Shop Now</a>
        </div>
    </div>
    <div class="slide">
        <img src="${pageContext.request.contextPath}/views/images/slide2.jpg" alt="Image 2">
        <div class="info">
            <a href="#" class="btn">Shop Now</a>
        </div>
    </div>
    <img src="${pageContext.request.contextPath}/views/images/ban1.jpg" alt="left Banner" class="banner-image left-banner">
    <img src="${pageContext.request.contextPath}/views/images/ban2.jpg" alt="Right Banner" class="banner-image right-banner">
    
    <div class="navigation-dots">
        <!-- Navigation dots will be generated here by JS -->
    </div>
</div>

<header class="products-header">
    <h2>Products</h2>
</header>


<%
    List<product> pl = (List<product>) request.getAttribute("products");
    if (pl != null) {
        for (product pp : pl) {
%>
            <div class="product-card">
                <div class="product-image">
                    <a href="${pageContext.request.contextPath}/ProductDetailServlet?productId=<%= pp.getId() %>">
                        <img src="${pageContext.request.contextPath}/views/images/productImage/<%= pp.getImageUrlFromPart() %>" alt="<%= pp.getDescription() %>">
                    </a>
                </div> 
                <h2><%= pp.getName() %></h2>
                <p class="price">$ <%= pp.getPrice() %></p>
                <form action="${pageContext.request.contextPath}/AddToCartServlet" method="post">
                <input type="hidden" name="userId" value="<%= session.getAttribute("user_id") %>">
                <input type="hidden" name="productImage" value="<%= pp.getImageUrlFromPart() %>">
    			<input type="hidden" name="productId" value="<%= pp.getId() %>">
    			<input type="hidden" name="productName" value="<%= pp.getName() %>">
    			<input type="hidden" name="quantity" value="<%= pp.getStock() %>">
    			<input type="hidden" name="price" value="<%= pp.getPrice() %>">
                <button type="submit" class="add-to-cart">Add to Cart</button>
                </form>
            </div>
<%
        }
    }
%>



    <footer>
        <div class="footer-content">
        <div class="about">
            <img src="${pageContext.request.contextPath}/views/images/footer-logo.png" alt="logo">
            <ul>
            <li><i class="fa-solid fa-phone fa-xl" style="color: #000000;"></i> +977-9123456789</li>
            <li><i class="fa-solid fa-envelope fa-xl" style="color: #000000;"></i> sellphone.official@gmail.com</li>
            <li><i class="fa-solid fa-location-dot fa-xl" style="color: #000000;"></i> Itahari, Sunsari</li>
            
            </ul>
        </div>
        <div class="Information">
            <h3>Info</h3>
            <p>My Account</p>
            <p>Login</p>
            <p>My Cart</p>
            <p>Checkout</p>
            <p>FAQ</p>
        </div>
        <div class="Service">
            <h3>Service</h3>
            <p>Terms Conditions</p>
            <p>About Us</p>
            <p>Carrers</p>
            <p>Delivery Information</p>
            <p>Privacy Policy</p>
        </div>
        
        <div class="Subscribe">
            <form class="sub">
            <h3>Subscribe</h3>
            <p>Enter your email to be the first one to Knew about all new products</p>
            <input type="text" placeholder="Email here..."/><br />
            <input type="submit" value="Send" onclick="valid1()" />
            </form>
        </div>
        </div>
        <div class="copyright">
            <p>&copy; 2024 SellPhone. All Rights Reserved.</p>
        </div>
        
    </footer>
    
    <script>
        let slides = document.querySelectorAll('.slider .slide');
        let dotsContainer = document.querySelector('.navigation-dots');
        let currentIndex = 0;
        let intervalId;
    
        // Function to move to the next slide
        function nextSlide() {
            const nextIndex = (currentIndex + 1) % slides.length;
            goToIndex(nextIndex);
        }
    
        // Start the timer
        function startTimer() {
            intervalId = setInterval(nextSlide, 3000); // Change 3000 to desired interval in milliseconds (e.g., 3000 for 3 seconds)
        }
    
        // Stop the timer
        function stopTimer() {
            clearInterval(intervalId);
        }
    
        // Function to handle navigation to a specific slide
        function goToIndex(index) {
            slides[currentIndex].classList.remove('active');
            dotsContainer.children[currentIndex].classList.remove('active');
            currentIndex = index;
            slides[currentIndex].classList.add('active');
            dotsContainer.children[currentIndex].classList.add('active');
        }
    
        // Initialize the slider and start the timer
        slides.forEach((slide, index) => {
            let dot = document.createElement('div');
            dot.classList.add('navigation-dot');
            if (index === 0) dot.classList.add('active');
            dot.addEventListener('click', () => {
                stopTimer(); // Stop timer when user manually navigates
                goToIndex(index);
            });
            dotsContainer.appendChild(dot);
        });
    
        startTimer(); // Start the timer initially
    </script>

</body>