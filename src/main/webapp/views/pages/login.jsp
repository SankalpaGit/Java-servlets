<%@page import="util.stringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/stylesheet/login.css">
</head>
<body>
	  <div class="form-container">
        <h2>Login Form</h2>
        <form action="${pageContext.request.contextPath}/loginServlet" method="post">
            <input type="text" id="username" placeholder="Username" name="username" required>
            <input type="password" id="password" placeholder="Password" name="password" required>
            <input type="submit" value="Login">
        </form>
        <br/>
        <div class="link-site">
            Not a member? <a href="register.jsp">Signup here</a>
        </div>
        
         <% 
        String successMessage = (String) request.getAttribute(stringUtils.SUCCESS_MESSAGE);
        String errorMessage = (String) request.getAttribute(stringUtils.ERROR_MESSAGE);

        if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
        <!-- Display error message -->
         <div class="alert-danger" role="alert">
            <%= errorMessage %>
        </div>
        <% } %>

        <% 
        if (successMessage != null && !successMessage.isEmpty()) {
        %>
        <!-- Display success message -->
        <div class="alert-success" role="alert">
            <%= successMessage %>
        </div>
        <% } %>
    </div>
</body>
</html>