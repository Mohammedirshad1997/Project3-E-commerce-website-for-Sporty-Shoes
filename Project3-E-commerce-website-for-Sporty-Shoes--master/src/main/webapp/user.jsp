<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
</style>

<%
List<Product> list=(List<Product>)request.getAttribute("list");
int userid = (Integer)request.getAttribute("userid");
String username = (String)request.getAttribute("username");
String password = (String)request.getAttribute("password");%>
<h1>Welcome <%=request.getAttribute("username") %>!!</h1>
<table border="1">
<tr>
<th>Shoe Name</th><th>Shoe Cost</th><th>Buy</th>
</tr>
<%
if(list!=null){
for(Product p:list){ %>

<tr>
	
	<td><%=p.getSname()%></td>
	<td><%=p.getScost()%></td>
	<td><a  href="addToCart?sid=<%= p.getSid()%>&sname=<%=p.getSname()%>&scost=<%=p.getScost() %>&uid=<%=userid%>&username=<%=username%>&password=<%=password%>">Add to Cart</a></td>
</tr>

<%}} %>
</table>
<br></br>
<a href="/logout">Click here to logout</a>  
</body>
</html>
