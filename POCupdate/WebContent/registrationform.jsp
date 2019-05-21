<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/bootstrap.min.css"/>
<link rel="stylesheet" href="style.css"/>
<link>
<title>Registration page</title>
</head>
<body>
<jsp:include page="navhome.html"></jsp:include>
<div class="container">
<h2 align="center">Enter Your Details</h2>
<div align="center">
<form  name="form1" action="Register" onsubmit="return validatePassword()" method="post">
<table>
<tr><td>ID:</td><td><input type="text" name="id" placeholder="id" required="required"></td><td><span id="ID"></span></td></tr>
<tr><td>First Name:</td><td><input type="text" id="firstName" name="firstName" required="required"></td><td><span id="ID1"></span></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lastName" id="lastName" required="required"></td></tr>
<tr><td>Email:</td><td><input type="email" id="email" name="email" required="required" placeholder="email"></td><td><span  id="ID2"></span></td></tr>
<tr><td>Password:</td><td><input type="password" id="password" name="password" required="required"></td><td><span id="message"></span ><span id="message2"></span><span id="message3"></span></td></tr>
<tr><td>Re-enter Password:</td><td><input type="password" id="confirm_password"name="confirm_password" required="required"></td><td>
<span id="message"></span></td></tr>
<tr><td>Address:</td><td><input type="text" id="address" name="address"></td></tr>
<tr><td>Phone Number:</td><td><input type="text" id="phoneNumber" name="phoneNumber"></td><td><span id="ID4"></span></td></tr>
<tr><td>Gender:</td><td><input type="radio" name="gender" value="male"/>Male
<input type="radio" name="gender" value="female"/>Female
</td></tr>
<tr  align="center"><td><input type="submit"  id="submit" value="register"></td></tr>
</table>
</form>
</div>
</div>
<footer>
<jsp:include page="footer.html"></jsp:include>
</footer>
 <script src="resources/jquery.min.js"></script>
  <script src="resources/bootstrap.min.js"></script>

<script type="text/javascript">
	function validatePassword(){
		var pass1=document.forms["form1"]["password"].value;
		var pass2=document.forms["form1"]["confirm_password"].value;
		if(pass1!=pass2)
			{
			window.alert("passwords do not match");
			return false;
			}
		if(pass1.length<6)
		{
			window.alert("Password less than six characrters");
			return false;
		}
	};
</script> 	    
</body>
</html>