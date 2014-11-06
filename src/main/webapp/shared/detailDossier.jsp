<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.Dossier"
	import="ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.Infraction"
	import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Visualisation du dossier :
		<%=((Dossier) request.getAttribute("dossier")).nom()%></h1>

	<%
		Dossier dossier = (Dossier) request.getAttribute("dossier");
		List<Infraction> infractions = (List<Infraction>) request
				.getAttribute("infractions");
		List<Infraction> listbox = (List<Infraction>) request
				.getAttribute("listbox");
	%>

	<table border="1">
		<tr>
			<td>Nom</td>
			<td>
				<%
					out.println(dossier.nom());
				%>
			</td>
		</tr>
		<tr>
			<td>Prenom</td>
			<td>
				<%
					out.println(dossier.prenom());
				%>
			</td>
		</tr>
		<tr>
			<td>Permis</td>
			<td>
				<%
					out.println(dossier.noPermis());
				%>
			</td>
		</tr>
		<tr>
			<td>Plaque</td>
			<td>
				<%
					out.println(dossier.noPlaque());
				%>
			</td>
		</tr>
	</table>

	<table border="1">
		<c:forEach var="infraction" items="${infractions}">
			<tr>
				<td>${infraction.description()}</td>
				<td>${infraction.niveau()}</td>
			</tr>
		</c:forEach>
	</table>


	<%
		if (request.isUserInRole("policier")) {
	%>
	<form action="detailDossier" method="post">
	<input type="hidden" value= "<%
					out.print(dossier.idDossier());
				%>" name="idDossier"/>
	<select name="idInfraction">
		<c:forEach var="infraction" items="${listbox}">
			<option value="${infraction.id()}">${infraction.description()}</option>
		</c:forEach>
	</select>
	
	<input type="submit" value="Ajouter" />
	</form>
	<%
		}
	%>
	
<form method="link" action="..\logout.jsp">
	<input type="submit" value="Logout"/>
</form>
</html>