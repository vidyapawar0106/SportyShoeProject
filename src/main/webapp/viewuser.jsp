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
<h1>List of User</h1>
<a href="home.jsp">Go_to_Homepage</a><br>
<br>


<% List<User> list=(List<User>)request.getAttribute("list");
%>
<table border="1">
<tr><th>userid</th><th>user_name</th><th>User_password</th>
<% for(User u:list){ %>
<tr><td><%=u.getUserid() %></td><td><%=u.getUsername() %></td><td><%=u.getPassword() %></td></tr>
<%} %>

</table>

</body>
</html>