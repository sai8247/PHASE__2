<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminPage</title>
</head>
<body>
<br>
<a href="HomePage.jsp">FlyAway</a>
<br><br>

<h2>AdminLogin</h2>

<form action="AdminLogin" method="post">
	Email :- <input type="email" name=email id=email /><br><br>
	Password :- <input type="password" name=password id=pass /><br><br>
	<input type=submit value=submit /> <input type=reset />
</form>

<br>
<a href="ForgotPassword.jsp" >Forgot Password</a>

<%
	String message=(String)session.getAttribute("message");
	if(message!=null){

		session.setAttribute("message", null);
	}
%>
</body>
</html>