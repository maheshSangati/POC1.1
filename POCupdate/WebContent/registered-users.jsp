<%@page import="myproject.dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="myproject.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/bootstrap.min.css"/>
<link rel="stylesheet" href="style.css"/>
<script src="resources/bootstrap.min.js">
</script>
<title>Registered Users</title>
</head>
<body>

<jsp:include page="navwelcomepage.html"></jsp:include>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragna","no-cache");
response.setHeader("Expire","0");

User a=(User)request.getSession().getAttribute("user");
	if(a==null)
	{
		response.sendRedirect("loginform.jsp");
	}else{
			List<User>  list = UserDao.getRegisteredUsers();
			request.setAttribute("users",list); 
	}
%>
<br>
<c:out value="${list}"></c:out>
<table class="table table-bordered table-striped">
<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Email-id</th><th>Password</th>
<th>Status</th><th>Address</th><th>Phone Number</th><th>Gender</th><th>Reset account</th></tr>
<c:forEach items="${users}" var="u">  
<tr><td>${u.getId()}</td><td>${u.getFirstName()}</td><td>${u.getLastName()}</td> <td>${u.getEmailId()}</td>
<td>${u.getPassword()}</td><td>${u.getStatus()}</td><td>${u.getAddress()}</td><td>${u.getPhoneNumber()}</td>
<td>${u.getGender()}</td><td><a href="reset.jsp?id=${u.getId()}">Reset</a></td></tr>
</c:forEach>  
</table>
<jsp:include page="footer.html"></jsp:include>
</body>
</html>