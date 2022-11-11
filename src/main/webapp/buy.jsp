<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import= "com.example.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Product p=(Product)request.getAttribute("p");

%>
<h1>
Billing Receipt
</h1>
<p>Name Of Product:<%=p.getPname() %></p>
<p>Manufacturing Company:<%=p.getCompany() %></p>
<p>Category:<%=p.getCatagory() %></p>
<p>size:<%=p.getPsize() %></p>
<p>Prize:<%=p.getPrice() %></p>
<a href="customerhome.jsp">Back to home page</a>

</body>
</html>