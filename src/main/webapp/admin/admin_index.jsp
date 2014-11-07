<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Portail Administrateur</h1>
		
		<ul>
			<li><a href="ajouterDossier">Ajouter un dossier</a></li>
			<li><a href="AjouterInfraction">Ajouter des infractions au système</a></li>
			<li><a href="../shared/listeInfraction">Visualiser la liste des infractions existantes dans le système</a></li>
			<li><a href="../shared/listeDossier">Visualiser la liste des dossiers existants dans le système</a></li>
			</ul>

		<form method="link" action="..\logout.jsp">
			<input type="submit" value="Logout"/>
		</form>
    </body>
</html>