<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language= "java" contentType="text/html; charset=UTF-8" pageEncoding= "UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach items="${requestScope.allpets}" var="currentpet"> 
<tr>
	<td><input type="radio" name="id" value="${currentpet.id}"></td>
	<td>${currentpet.name}</td>
	<td>${currentpet.breed}</td>
	<td>${currentpet.weight}</td>
</tr>
</c:forEach>
</table>

</body>
</html>