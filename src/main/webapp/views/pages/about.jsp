<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us</title>
<style>
    * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

header {
    background-size: cover;
    background-position: center;
    padding: 4px 4%;
    display: flex;
    align-items: center;
    justify-content: space-between;
    background: #3FC1C9;
}

.logo img {
    height: 95px;
}



.filter {
    background: none;
    position: relative;
    right: 80px;
    border: none;
    cursor: pointer;
}

.icons a {
    margin-left: 100px;
}

nav {
    background-color: #e4ebea;
    padding: 15px;
    margin-top: 10px;
}

nav ul {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    list-style: none;
}

nav ul li a {
    color: rgb(0, 0, 0);
    text-decoration: none;
    padding: 5px;
    margin-left: 50px;
    background-color: #ffffff;
    border-radius: 5px;
}

nav ul li a:hover {
    background-color: #56d5da;
    border-radius: 5px;
    color: rgb(255, 255, 255);
}

      .container {
        padding: 20px;
      }
      
      #about,
      #contact {
        margin-bottom: 40px;
      }
      
      #about {
        display: flex;
        justify-content: space-between;
      }
      
      .image {
        flex: 2;
      }
      
      .image img {
        max-width: 100%;
        margin-left: 40px;
      }
      
      .content {
        flex: 2;
        padding-left: 100px; /* Add some space between image and content */
        text-align: justify;
      }
      .content h2{
        font-size:50px;
        text-align:center;
        margin-left: 40px;
      }
      .content p{
        width:65%;
        margin-left: 140px;
      }
      #contact {
        padding: 20px;
        border-radius: 5px;
      }
      
      h2 {
        font-size: 40px;
        margin-bottom: 20px;
        margin-left:80px;   
        font-family: 'Lato', sans-serif;



      }
      
      .form-group {
        margin-bottom: 15px;
        
      }
      
      .form-group label {
        display: block;
        margin-bottom: 5px;
        
      }
      
      input[type="tel"],
      input[type="email"],
      textarea {
        border: none;
        border-bottom: 1px solid black; /* This creates a straight line under the input */
        outline: none; /* Removes the default input focus outline */
        width: 90%;
        padding: 10px;
        margin-left: 55px;
        font-size: 20px;

      }
      
      button {
        background-color:rgb(255, 100, 100);
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-left:55px;
        margin-top:25px;
      }
      
      button:hover {
        background-color:red;
      }
      
      footer {
        background-color: #f1f1f1;
        padding: 10px;
        text-align: center;
      }


footer {
    width: 100%;
    background-color: #dfebe6c4;
    color: #000000;
    padding: 20px; /* Add some padding */
    text-align: center; /* Center align text */
}

footer img{
    height: 70px;
    margin-left: 30px;
    margin-bottom: 20px;
}
footer .footer-content{
    display: flex;
    justify-content: space-between;
    padding:20px 25px;
}
footer .footer-content h3{
    font-family: "Raleway", sans-serif;
    font-size: 20px;
    font-weight: 700;
}
footer .footer-content li{
    list-style: none;
    text-decoration: none;
    padding-bottom: 15px;
}
footer .footer-content p{
    
    margin-top: 10px;
}
footer .footer-content .Subscribe{
    display: block;
    flex-basis: 20%;
}
footer .footer-content .Subscribe input{
    margin-top: 8px;
    padding: 14px;
}
footer .footer-content .Subscribe input[type="text"]{
    width: 100%;
    height:40px;
    font-size: 15px;
    border-radius: 10px;
    outline: none;
    border:1px solid rgb(112, 108, 108);
}
footer .footer-content .Subscribe input[type="submit"]{
    width: 30%;
    height: 35px;
    line-height: 1px;
    border-radius: 7px;
    color: #fff;
    background-color: #000000;
    outline: none;
    border:1px solid rgb(66, 66, 66);
    transition: background-color 0.5s ease-in-out 10ms;
}
footer .footer-content .Subscribe input[type="submit"]:hover{
    background-color: #e18844;
}
.copyright{
    position: relative;
    justify-content: center;
    align-items: center;
    background-color: aliceblue;
    height: 40px;
    display: flex;
}


</style>

        <script src="https://kit.fontawesome.com/6a838dbad0.js" ></script>
    <body>
<header>
    <div class="logo">
        <a href=""><img src="${pageContext.request.contextPath}/views/images/logo.png" alt="logos"></a>
    </div>
    
    <div class="icons">
        <a href=""><i class="fas fa-shopping-cart fa-xl" style="color: #000000;"></i></a>
        <a href=""><i class="fas fa-bell fa-xl" style="color: #000000;"></i></a>
        <a href=""><i class="fas fa-user fa-xl" style="color: #000000;"></i></a>
    </div>
</header>

<div class="container">
  <section id="about">
    <div class="image">
      <!-- Placeholder image, replace with your own -->
<img src="${pageContext.request.contextPath}/views/images/about.jpeg" alt="About Us Image">
    </div>
    <div class="content">
      <h2>About us</h2>
      <p> At Sell Phone, we understand that your mobile device is more than just a gadget—it's an essential tool that keeps you connected, productive, and entertained. That's why we carefully curate our inventory to offer the latest technology and innovations. Whether you're upgrading your current device or exploring new features, our knowledgeable team is here to assist you every step of the way. With Sell Phone, you can shop with peace of mind, knowing that you're investing in quality and reliability."

        "But we're more than just a retailer; we're your trusted partner in the world of mobile technology. Beyond offering great products, we're dedicated to building lasting relationships with our customers. Our commitment to excellence extends to our customer service, ensuring that your experience with Sell Phone is seamless and enjoyable. Join the Sell Phone community today and experience the convenience and satisfaction of shopping with us.</p>
    </div>
  </section>

  <h2>Get Connect with us</h2>

  <section id="contact">
    
    <form action="/AboutUsFormServlet" method="post">
      <div class="form-group">
        <input type="tel" id="phone" name="phone" placeholder="Phone number"  required>
      </div>
      <div class="form-group">
        <input type="email" id="email" name="email" placeholder= "E-mail"required>
      </div>
      <div class="form-group">
        <textarea id="message" name="message" placeholder="Write your message"required></textarea>
      </div>
      <button type="submit">Send Message</button>
    </form>
  </section>
</div>

<footer>
  <div class="footer-content">
  <div class="about">
      <img src="${pageContext.request.contextPath}/views/images/footer-logo.png" alt="logo">
  <ul>
  <li><i class="fa-solid fa-phone fa-xl" style="color: #000000;"></i> +977-9123456789</li>
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
    <p>Terms  Conditions</p>
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
    <input type="submit" value="Send" style="float: left">
        </form>
    </div>
    </div>
    <div class="copyright">
        <p>&copy; 2024 SellPhone. All Rights Reserved.</p>
    </div>
    
</footer>
    </body>
    </html> 
