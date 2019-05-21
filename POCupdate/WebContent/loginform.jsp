<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/bootstrap.min.css"/>
<link rel="stylesheet" href="style.css"/>
<title>Login</title>
</head>

<body>
<jsp:include page="navlogin.html"></jsp:include>
<div class="container">
<form action="LoginHome" method="post">
<table>
<tr><td>Email:</td><td><input id="input"type="email" name="email" placeholder="Email" required="required"/></td></tr>
<tr><td>Password:</td><td><input type="password" name="password" placeholder="Password" required="required"/></td></tr>
<tr><td colspan="2" class="center"><input type="submit" value="Login"/></td></tr>

</table>

</form>
</div>
<jsp:include page="footer.html"></jsp:include>
  <script src="resources/jquery.min.js"></script>
  <script src="resources/bootstrap.min.js"></script>
	<script type="text/javascript">
	/**$("input").on("keyup", function(){
		var xhttp=new XMLHttpRequest();
		xhttp.onreadystatechange=function(){
		if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("result").innerHTML =
		      this.responseText;
	}
	};
	xhttp.open("POST" , "Search" , true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	  xhttp.send("email="$("input");
	}*/
	</script>
</body>
</html>