<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit product from list of product</h1>
<%
   int id=Integer.parseInt(request.getParameter("id"));
%>
<form action="edit">
Product_id<input type="text" value=<%=id %> name="id"><br>
Product_name<select name="name" id="name">
  <option value="chappals">chappals</option>
  <option value="sandal">sandals</option>
  <option value="sport shoes">sport_shoes</option>
  <option value="casual shoes">casual_shoes</option>
  <option value="sneakers">sneakers</option>
</select><br>
Product_company<select name="company" id="company">
  <option value="bata">bata</option>
  <option value="relaxo">relaxo</option>
  <option value="flite">flite</option>
  <option value="paragon">paragon</option>
  <option value="star">star</option>
  </select><br>
Product_size<input type="text" name="size"><br>
Product_category<select name="category" id="category">
  <option value="male">male</option>
  <option value="female">female</option>
  <option value="kids">kids</option></select><br>
  Product_price<input type="text" name="price"><br>
<input type="submit" value="submit">

</form>



</body>
</html>