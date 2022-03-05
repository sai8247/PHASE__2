<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body>

<a href="Admin.jsp">AdminLogin</a>


<%
	@SuppressWarnings("unchecked")
	HashMap<String,String> user=(HashMap<String,String>)session.getAttribute("user");
	if(user!=null){
%>
<p>Welcome <%=user.get("name") %></p>
<a href="Logout">Logout</a>
<%
	}else{
%>
<a href=UserPage.jsp>User Login</a>
<%
	}
%>
<br><br>


<form action="FlightsAvail" method=post>
	 Source :-  <input type="text" name="source" id="source"><br><br>
	 Destination :-  <input type="text" name="destination" id="Destination"/><br><br>
	 Departure :-  <input type="date" name="departure" id="Departure"/><br><br>
	 
	<input type="submit" value="Search" /> <input type="reset" />
</form>


</body>
</html>