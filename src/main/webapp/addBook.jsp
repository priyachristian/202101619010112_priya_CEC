<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Addition</title>
</head>
<body style="text-align: center;">
	<h1> Book Addition </h1>
	
	<form action="addBook" method="get">
		Book Name : <input type="text" name="bname"><br><br>
		Book Price : <input type="text" name="bprice"><br><br>
		Author Name: <input type="text" name="aname"><br><br>
		
		<input type="submit" value="Submit"><br><br>
		
		<a href="display_book_details">Show Book Details</a><br><br>
		
		<a href="display_book">Show Book</a><br><br>
	</form>
</body>
</html>