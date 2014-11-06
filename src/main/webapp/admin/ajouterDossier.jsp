<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <title>ajouter_dossier</title>
        <link type="text/css" rel="stylesheet" href="../css/common_css_file.css" />
</head>
<body>
	<h4>Ajouter dossier</h4>
<form method="post" action="ajouterDossier">
	<fieldset>
		<legend> Ajouter dossier </legend>
	    <label for="nom">Nom du dossier:<span class="requis">*</span></label>
	    <input type="text" id="nom" name="nom_dossier" value="" size="20" maxlength="60" />
	    <br />
	    
	    <label for="prenom">prenom du dossier:<span class="requis">*</span></label>
	    <input type="text" id="prenom" name="prenom_dossier" value="" size="20" maxlength="60" />
	    <br />
	
	    <label for="noPlaque">N° plaque:<span class="requis">*</span></label>
	    <input type="text" id="noPlaque" name="noPlaque_dossier" value="" size="20" maxlength="20" />
	    <br />
	    
	    <label for="noPermis">N° permis:<span class="requis">*</span></label>
	    <input type="text" id="noPermis" name="noPermis_dossier" value="" size="20" maxlength="20" />
	    <br />
	    
	    <input type="submit" value="Ajouter" class="sansLabel" />
	    <br />
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