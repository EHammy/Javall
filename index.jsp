<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate Numbers</title>
</head>
<body>
	<h1>Calculate Numbers</h1>
	<form action="getNumbersServlet" method="post">
	Enter the numbers you'd like to Calculate:
	<input type="text" name= "firstNumber" size="5">
	<input type="text" name="secondNumber" size="5">
	<input type="submit" value="Calculate Numbers">
	</form>

</body>
</html>