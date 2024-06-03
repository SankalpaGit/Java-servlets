<%@page import="model.User"%>
<%@page import="util.stringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/stylesheet/login.css">
</head>
<body>
	 <div class="form-container">
        <h2>Signup Form</h2>
        
         <%
        String errorMessage = (String) request.getAttribute(stringUtils.ERROR_MESSAGE);
    
        
        if (errorMessage !=null && !errorMessage.isEmpty()) {
    %>
        <div class="alert alert-danger" role="alert">
            <%= errorMessage %>
        </div>
        <% 
        }
        %>
        <form action="${pageContext.request.contextPath}/registerServlet" method="post">
            <input type="text" id="username" placeholder="Username" name="username" required>

            <!-- <label for="firstname">First Name</label> -->
            <input type="text" id="firstname" placeholder="First Name" name="firstname" required>

            <!-- <label for="lastname">Last Name</label> -->
            <input type="text" id="lastname" placeholder="Last Name" name="lastname" required>

            <input type="email" id="email" placeholder="Email" name="email" required>


            <input type="password" id="password" placeholder="Password" name="password" required>

            <input type="password" id="confirm-password" placeholder="Confirm Password" name="confirm-password" required>

            <input type="submit" value="Signup">
        </form>
        <br/>
        <div class="link-site">
            Already have an account? <a href="login.jsp">Login here</a>
        </div>
    </div>
</body>
</html>