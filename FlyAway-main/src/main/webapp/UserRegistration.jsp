<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>
<br>
<a href="HomePage.jsp">FlyAway</a>
<br><br>


<form action=UserRegister method=post>
	Email :<input type="email" name="email" id="email" /><br><br>
	Password :<input type="password" name="password" id="pass" /><br><br>
	Name :<input type="text" name="name" id="name" /><br><br>
	Phone No. :<input type="text" name="phno" id="phno" /><br><br>
	AadhaarNo. :<input type="text" name="adno" id="adno" /><br><br>
	
	<input type="submit" value="submit" /> <input type="reset" />
</form>


</body>
</html>