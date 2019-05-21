<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Account</title>
</head>
<body>
<%@page import="myproject.dao.UserDao"%>  
<jsp:useBean id="u" class="myproject.beans.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
UserDao.reset(u);  
response.sendRedirect("registered-users.jsp");  
%>  
</body>
</html>