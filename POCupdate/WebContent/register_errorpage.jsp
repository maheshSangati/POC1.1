<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/bootstrap.min.css"/>
<link rel="stylesheet" href="style.css"/>
<title>Register Error Page</title>
</head>
<body>
<jsp:include page="navhome.html"></jsp:include>

<div class="container">
<h2>Registration Error</h2>
<p>User already exists </p>
<p>register with new user id</p>
</div>
<jsp:include page="errloginform.html"></jsp:include> 
<jsp:include page="footer.html"></jsp:include> 

</body>
</html>