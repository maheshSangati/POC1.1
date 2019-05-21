<%@page import="myproject.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/bootstrap.min.css"/>
<link rel="stylesheet" href="style.css"/>
<script src="resources/bootstrap.min.js">
</script>

<title>Welcome Page</title>

<!-- need to fix this function -->

<script type="text/javascript">
function preBack(){window.history.forword();}
setTimeout("preBack()",0);
window.onunload= function() {null};
</script>
</head>
<body >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="navwelcomepage.html"></jsp:include>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragna","no-cache");
response.setHeader("Expire","0");

User u=(User)request.getSession().getAttribute("user");
	if(u==null)
	{
		response.sendRedirect("loginform.jsp");
	}else{
		
out.println("<h1>Welcome <h1>");
out.print(u.getFirstName()+" "+u.getLastName());
	}
%>
<br>
<h6>Click here to <a href="registered-users.jsp">view users</a></h6>
<jsp:include page="footer.html"></jsp:include>
</body>

</html>