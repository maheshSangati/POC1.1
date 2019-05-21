<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/bootstrap.min.css"/>
<link rel="stylesheet" href="style.css"/>
<link href="resources/bootstrap.min.js">
<title>Login Error</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="index.html">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="registrationform.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="loginform.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<div class="container">
<h3>Login Error</h3>
<p>Try login again
</div>	
	<jsp:include page="errloginform.html"></jsp:include>
	<jsp:include page="footer.html"></jsp:include>
</body>
</html>