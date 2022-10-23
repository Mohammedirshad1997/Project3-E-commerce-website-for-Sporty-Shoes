<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Shoe Details</title>
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
<% int sid = Integer.parseInt(request.getParameter("sid"));

String sname = request.getParameter("sname");

String scost = request.getParameter("scost");
%>
<h1><i>Edit Shoe Details</i></h1>
<form action="update" class="container" style="border:1px solid #ccc">
Shoe name<input type="text" name="sname" value="<%=sname%>" required><br>
Shoe cost<input type="text" name="scost" value="<%=scost%>" required><br>
<input type="submit" value="Save Product" class="btn">
 <input type="hidden" name="sid" value="<%=sid%>"> 
</form>
</body>
</html>