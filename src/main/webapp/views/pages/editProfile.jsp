<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>

<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 20px;
}

h1 {
    text-align: center;
}

form {
    max-width: 400px;
    margin: 0 auto;
}

input[type="text"],
input[type="tel"],
textarea,
input[type="date"],
input[type="email"],
input[type="file"],
input[type="submit"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

    </style>

</head>
<body>
	 <form action="ProfileFormServlet" method="post" >
	    <input type="text" name="firstName" placeholder="First Name"><br><br>
	    <input type="text" name="lastName" placeholder="Last Name"><br><br>
	    <input type="email" name="email" placeholder="Email"><br><br>
	    <input type="tel" name="phoneNumber" placeholder="Phone Number"><br><br>
	    <textarea name="description" placeholder="Description of your bio or anything"></textarea><br><br>
	    <input type="submit" value="Submit">
</form>

</body>
</html>