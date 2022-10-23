<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

.bg-img {
  /* The image used */
  background-image: url("images/flight.jpg");

  min-height: 1000px;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

/* Add styles to the form container */
.container {
  position: absolute;
 
  margin: 20px;
  max-width: 300px;
  padding: 16px;
  background-color: white;
  
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit button */
.btn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}


</style>
</head>
<body>
<%String msg = (String)request.getAttribute("msg"); %>
<h1>User Login Page</h1>
<%if(msg!=null){ %>
<h2><%= msg %></h2>
<%} %>
<form action="loginUser" class="container" style="border:1px solid #ccc">
Username<input type="text" name="uname" placeholder="Enter Username" required><br>
Password<input type="password" name="upassword" placeholder="Enter Password" required><br>
<br></br>
<input type="submit" value="login" class="btn">
<br></br>
<a href="register.jsp">Register New User</a>

</form>
</body>
</html>