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
			<li>Ajouter un dossier</li>
			<li>Ajouter des infractions au système</li>
			<li>Visualiser la liste des infractions existantes dans le système</li>
			<li>Visualiser la liste des dossiers existants dans le système</li>
			<li>Sélectionner un dossier -> Visualiser les infractions d’un dossier</li>
			<li>Fermeture de la session pour permettre la ré-ouverture sous un autre compte</li>
		</ul>

		<form method="link" action="..\logout.jsp">
			<input type="submit" value="Logout"/>
		</form>
    </body>
</html>