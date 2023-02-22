<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action="navigationServlet">
<table>
<c:forEach items = "${requestScope.allStudents}" var = "currentstudent">
<tr>
<td><input type = "radio" name="id" value="${currentstudent.id}"> </td>
<td>${currentstudent.student}</td>
<td>${currentattendance.attendance}</td>
</tr>
</c:forEach>
</table>
<input type ="submit" value = "edit" name="doThisToStudent">
<input type ="submit" value = "delete" name="doThisToStudent">
<input type ="submit" value = "add" name="doThisToStudent">
</form>
</body>
</html>