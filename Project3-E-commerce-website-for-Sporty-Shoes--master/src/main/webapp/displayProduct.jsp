<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
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
	<td><a  href="edit?id=<%= p.getSid()%>&sname=<%=p.getSname()%>&semail=<%=p.getScost() %>">Edit</a></td>
	<td><a  href="delete?id=<%= p.getSid()%>&sname=<%=p.getSname()%>&semail=<%=p.getSname() %>">Delete</a></td>
</tr>

<%}} %>
</table>
</body>
</html>
