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
<body>
<h1>Product successfully added to the list</h1>
<% List<Product> list=(List<Product>)request.getAttribute("list");
%>
<table border="1">
<tr><th>product_id</th><th>Product_name</th><th>Product_company</th><th>Product_size</th><th>Product_category</th><th>Product_Price</th><th>Edit_operation</th><th>delete_operation</th></tr>
<% for(Product p:list){ %>
<tr><td><%=p.getId() %></td><td><%=p.getPname() %></td><td><%=p.getCompany() %></td><td><%=p.getPsize() %></td><td><%=p.getCatagory() %></td><td><%= p.getPrice()%></td><td><a href="Edit_Product.jsp?id=<%=p.getId()%>">Edit</a></td><td><a href="delete.jsp?id=<%=p.getId() %>">delete</a></td></tr>




<%} %>
</table>

</body>

</body>
</html>