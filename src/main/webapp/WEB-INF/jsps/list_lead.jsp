<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
       <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListOfAllLeads</title>
</head>
<body>
<a href="/">create Lead</a>
<table>
<tr>
<th>ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Source</th>
<th>Email</th>
<th>Mobile</th>
</tr>

<c:forEach items="${lead}" var="lead">
<tr> 
            <td>${lead.id}</td>
            <td><a href="leadinfo?id=${lead.id}">${lead.firstName}</a></td>
            <td>${lead.lastName}</td>
            <td>${lead.source}</td>
            <td>${lead.email}</td>
             <td>${lead.mobile}</td>
            
</tr>
        </c:forEach>

</table>

</body>
</html>