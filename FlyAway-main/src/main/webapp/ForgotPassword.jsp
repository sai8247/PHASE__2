<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgotpassword</title>
</head>
<body>
<br>
<a href=HomePage.jsp >FlyAway</a>
<br><br>


<form action="ForgotPassword" method="post">
	Email :-<input type="email" name="email" id="email" /><br><br>
	New Password :- <input type="password" name="password" id="pass" /><br><br>
	<input type="submit" value="submit" /> <input type="reset" />
</form>


</body>
</html>