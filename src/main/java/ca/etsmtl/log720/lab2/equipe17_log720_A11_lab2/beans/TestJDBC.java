package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class TestJDBC {

	/* La liste qui contiendra tous les résultats de nos essais */
	private List<String> messages = new ArrayList<String>();

	public List<String> executerTests(HttpServletRequest request) {
		/* Ici, nous placerons le code de nos manipulations */
		/* ... */
		DataSource ds = null;
		Connection conn = null;
		try {
			InitialContext ic = new InitialContext(); // JNDI initial context
			ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			conn = ds.getConnection();
		} catch (SQLException se) {
			this.messages.add("Erreur lors de la connexion ...<br/>");
		} catch (NamingException ne) {
			this.messages.add("Erreur lors du naming ....<br/>");

		}
		String queryString = "";
		Statement stmt = null;

		try {
			this.messages.add("Dans le try de dossier....<br/>");
			queryString = "SELECT * FROM DOSSIERS";
			stmt = conn.createStatement();
			this.messages.add("Avant le execute query....<br/>");
			ResultSet rs = stmt.executeQuery(queryString);
			this.messages.add("Après le execute query....<br/>");

			while (rs.next()) {
				int idDossier = rs.getInt(1);

				String idUtilisateur = rs.getString(2);
				this.messages.add(idUtilisateur + "<br/>");
				String noPermis = rs.getString(2);
				String nom = rs.getString(3);
				String prenom = rs.getString(4);
				String noPlaque = rs.getString(5);
				Dossier dos = new Dossier(idDossier, idUtilisateur, noPermis,
						nom, prenom, noPlaque);
				this.messages.add(dos.afficher() + "<br/>");

			}

			this.messages
					.add("---------------------------------------------------"
					+ "fin des dossiers"
					+ "------------------------------------------------------");
			// Ajout récursif des infractions a chaque dossier
			/*
			 * BanqueInfractions banqueInfractions = new BanqueInfractions();
			 * queryString = "SELECT * FROM DOSSIERS_INFRACTIONS"; rs =
			 * stmt.executeQuery(queryString); while (rs.next()) { int idDossier
			 * = rs.getInt(1); int idInfraction = rs.getInt(2); Infraction
			 * infraction = banqueInfractions
			 * .trouverInfractionParId(idInfraction);
			 * 
			 * for (Dossier d : this._collectionDossiers.getListeDossiers()) {
			 * if (d.idDossier() == idDossier) {
			 * d.getListeInfraction().add(infraction); } }
			 * 
			 * }
			 */
		} catch (Exception ex) {

		}

		return this.messages;
	}
}
