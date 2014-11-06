<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link type="text/css" rel="stylesheet" href="../css/common_css_file.css" />
<title>Insert title here</title>
</head>
<body>
Ajouter une infraction dans cette page
<form action="AjouterInfraction" method="post">
	<fieldset>
		<table>
			<tr>
				<td>Description :</td>
				<td>
					<input id="txtDescription" name="txtDescription" type="text"/>
				</td>
			</tr>
			<tr>
				<td>Niveau</td>
				<td>
					<input type="text" name="txtNiveau"/>
				</td>
			</tr>
		</table>
		
		<input type="submit" value="submit"/> 
	</fieldset>
</form>
<%
	final String message = (String) request.getAttribute("message") == null ? "" : (String) request.getAttribute("message");
%>
<%= message %>

<form method="link" action="..\logout.jsp">
	<input type="submit" value="Logout"/>
</form>
</body>
</html>