<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import = "ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.Infraction" 
    %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des Infractions</h1>

<table border="1">
<tr><th>Description</th><th>Niveau</th></tr>
<c:forEach var="infraction" items="${infractions}">
	<tr>
		<td>${infraction.description()}</td>
		<td>${infraction.niveau()}</td>
	</tr>
</c:forEach>
</table>

<form method="link" action="..\logout.jsp">
	<input type="submit" value="Logout"/>
</form>
</body>
</html>