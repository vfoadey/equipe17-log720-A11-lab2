<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil</title>
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/connexion.css" />
    </head>
    <body>
        <form method="post" action="j_security_check">
            <fieldset>
                <legend>Connexion</legend>
                <p>Connecter vous avec votre identifiant et votre mot de passe</p>

                <label for="identifiant">Identifiant<span class="requis">*</span></label>
                <input type="text" id="identifiant" name="j_username" value="" size="20" maxlength="60" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="j_password" value="" size="20" maxlength="20" />
                <br />
				
                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>