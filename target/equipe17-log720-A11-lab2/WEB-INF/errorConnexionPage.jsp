<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil</title>
        <link type="text/css" rel="stylesheet" href="../connexion.css" />
    </head>
    <body>
        <form method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
				<p class="errorText">Accès refuser !</p>
                <p>Connecter vous avec votre identifiant et votre mot de passe</p>

                <label for="identifiant">Identifiant<span class="requis">*</span></label>
                <input type="text" id="identifiant" name="identifiant" value="" size="20" maxlength="60" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br />
				
                <input type="submit" value="connexion" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>