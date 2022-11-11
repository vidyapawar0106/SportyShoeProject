<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int id=Integer.parseInt(request.getParameter("id"));
HttpSession s=request.getSession();
s.setAttribute("id",id);
%>
<p>Are you sure want to delete, press the delete button</p>
<form action="delete">
<input type="text" value=<%=id %> name="id" disabled ><br>
<input type="submit" value="Delete_Product"><br>
</form>
</body>
</html>