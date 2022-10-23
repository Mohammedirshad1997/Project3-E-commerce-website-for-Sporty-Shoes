<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
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
  max-width: 500px;
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

<% int sid = (Integer)request.getAttribute("sid");
String sname = (String)request.getAttribute("sname");
String scost = (String)request.getAttribute("scost");
int uid = (Integer)request.getAttribute("userid");

%>

<form action="orderProduct"  class="container" style="border:1px solid #ccc">
<h1>Order Details</h1>
Shoe Name<input type="text" name="sname" readonly value="<%=sname %>" ><br/>
Shoe Cost<input type="text" name="scost" readonly value="<%=scost %>" ><br/>
<br/>

<div class="bg-img">
<h1>Payment Details</h1>
<h2><p align="left" >ENTER YOUR CARD DETAILS</p></h2>

	<label for="cardName"><b>CREDIT/DEBIT CARDS</b></label>
	 <select name="type" name="userType" required>
		<option value ="hdfc">HDFC Credit Card</option>
		<option value="admin">HDFC Debit Card</option>
		<option value="admin">ICICI Debit Card</option>
		<option value="admin">ICICI Debit Card</option>
		</select>
		<br></br>
    <label for="cardNo"><b>Card Number</b></label>
    <input type="text" placeholder="Card number" name="cardNo" required>

 	<label for="nameOnCard"><b>Name on Card</b></label>
    <input type="text" placeholder="Name on card" name="nameOnCard" required>

    <input type="submit" name="orderProduct" value ="Place Order" class="btn">
<input type="hidden" name="uid" value="<%= uid%>">
<input type="hidden" name="sid" value="<%= sid%>">

</form>
 </div>



</body>
</html>