<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
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
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
/* Set a style for the submit button */
.btn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 10%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}
</style>
</head>
<body>

<h1>Order Report</h1>


<%
List<UserOrderSummary> orderList=(List<UserOrderSummary>)request.getAttribute("orderList"); %>

<table border="1">
<tr><th>Order Id</th><th>User Name</th><th>User Email</th><th>Shoe Name</th><th>Shoe Cost</th></tr>
<%
if(orderList!=null){
for(UserOrderSummary o:orderList){ %>

<tr>
	<td><%=o.getOrderId() %></td>
	<td><%=o.getUserName() %></td>
	<td><%=o.getUserEmail() %></td>
	<td><%=o.getShoeName() %></td>
	<td><%=o.getShoeCost() %></td>
	
</tr>

<%}} %>
</table>
<br></br>


<a href="/logout">Click here to logout</a>  
</body>
</html>
