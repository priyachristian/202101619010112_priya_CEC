<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body style="text-align: center;">
	<h1> Register Page </h1>
	
	<form action="register" method="post">
		Username : <input type="text" name="username"><br><br>
		Password : <input type="text" name="password"><br><br>
		First Name : <input type="text" name="fname"><br><br>
		Last Name : <input type="text" name="lname"><br><br>
		Contact : <input type="text" name="contact"><br><br>
		Email : <input type="text" name="email"><br><br>
		
		<input type="submit" value="Submit"><br><br>
		
		Have you already register? <a href="Login.jsp">Login</a><br><br>
	</form>
</body>
</html>