<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreateLeadPage</title>
</head>
<body>
<form action="saveOneLead">
<pre>
First Name<input type="text" name="firstName">
Last Name<input type="text" name="lastName">
Source
<select name="source" >
  <option value="TV">TV</option>
  <option value="NEWS paper">NEWS paper</option>
  <option value="Online">Online</option>
  <option value="Radio">Radio</option>
</select>
Email<input type="text" name="email">
Mobile<input type="text" name="mobile">
<input type="submit" value="Save">
</pre>

</form>

</body>
</html>