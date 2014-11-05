<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"    
    import = "ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.Dossier"
    import = "java.util.ArrayList"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selection Dossier</title>
</head>
<body>
	<form action="SelectionDossier" method="post">
	<jsp:useBean id="dossiers" class="ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.BanqueDossiers" scope="page"/>
	Dossier :
		<Select>
			<c:forEach var="dossier" items="${dossiers.Dossiers()}">
     			<option>${dossier.Prenom} ${dossier.Nom} </option>
   			</c:forEach>
		</Select>
		<input type="submit"/>
	</form>
	<= dossier.Dossiers()[0].afficher();>
</body>
</html>