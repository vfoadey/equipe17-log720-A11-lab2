<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.Dossier" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des Dossiers</h1>

<table border="1">
<tr><th>Nom</th><th>Prenom</th><th>Numero permis</th><th>Numero plaque</th></tr>
<c:forEach var="dossier" items="${dossiers}">
	<tr>
		<td><a href="detailDossier?id=${dossier.idDossier()}">${dossier.nom()}</a></td>
		<td>${dossier.prenom()}</td>
		<td>${dossier.noPermis()}</td>
		<td>${dossier.noPlaque()}</td>
	</tr>
</c:forEach>

<form method="link" action="..\logout.jsp">
	<input type="submit" value="Logout"/>
</form>
</body>
</html>