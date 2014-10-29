<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>errorConnexionPage</title>
        <link type="text/css" rel="stylesheet" href="connexion.css" />
    </head>
    <body>
        <form method="post" action="Connexion">
            <fieldset>
                <legend>errorConnexionPage</legend>
                <p class="ErrorText">Accès refusé !</p>
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