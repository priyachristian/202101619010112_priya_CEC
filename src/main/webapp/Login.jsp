<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body style="text-align: center;">
	<h1> Login Page </h1>
	
	<form action="login" method="post">
		Username : <input type="text" name="username"><br><br>
		Password : <input type="text" name="password"><br><br>
		
		<input type="submit" value="Submit"><br><br>
		
		Don't have any account? <a href="Register.jsp">Register here</a>
	</form>
</body>
</html>