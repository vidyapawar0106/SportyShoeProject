<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import= "com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Product> list=(List<Product>)request.getAttribute("list");
%>
<table border="1">
<tr><th>product_id</th><th>Product_name</th><th>Product_company</th><th>Product_size</th><th>Product_category</th><th>Product_Price</th><th>Buy Product</th></tr>
<% for(Product p:list){ %>
<tr><td><%=p.getId() %></td><td><%=p.getPname() %></td><td><%=p.getCompany() %></td><td><%=p.getPsize() %></td><td><%=p.getCatagory() %></td><td><%= p.getPrice()%></td><td><a href="/buy?id=<%=p.getId()%>">Buy</a></td></tr>




<%} %>
</table>

</body>


</html>