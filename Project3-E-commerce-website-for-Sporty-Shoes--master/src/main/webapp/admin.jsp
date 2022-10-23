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
<%String message = (String)request.getAttribute("msg"); %>
<h1>Welcome Admin!</h1>
<%if(message !=null) {%>
<h2><%= message %></h2>
<%} %>

<%
List<Product> list=(List<Product>)request.getAttribute("list"); %>

<table border="1">
<tr><th>Shoe Id</th><th>Shoe Name</th><th>Shoe Cost</th><th>Edit Operation</th><th>Delete Operation</th></tr>
<%
if(list!=null){
for(Product p:list){ %>

<tr>
	<td><%=p.getSid()%></td>
	<td><%=p.getSname()%></td>
	<td><%=p.getScost()%></td>
	<td><a  href="edit?sid=<%= p.getSid()%>&sname=<%=p.getSname()%>&scost=<%=p.getScost() %>">Edit</a></td>
	<td><a  href="delete?sid=<%= p.getSid()%>&sname=<%=p.getSname()%>&scost=<%=p.getSname() %>">Delete</a></td>
</tr>

<%}} %>
</table>
<br></br>
<form action="addProduct">
<input type="submit" value="Add a product" class="btn"><br>
</form>
<br/>
<a href="/logout">Click here to logout</a>  
</body>
</html>
