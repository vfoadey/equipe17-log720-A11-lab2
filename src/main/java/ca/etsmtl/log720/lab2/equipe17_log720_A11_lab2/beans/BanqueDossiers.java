package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BanqueDossiers {

	public BanqueDossiers() {

	}

	public List<Dossier> dossiers() {
		InitialContext ic;
		List<Dossier> lstDossier = new ArrayList<Dossier>();

		try {
			ic = new InitialContext();
			String queryString = "SELECT * FROM DOSSIERS";
			DataSource ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);

			while (rs.next()) {
				int idDossier = rs.getInt(1);
				String idUtilisateur = rs.getString(2);
				String noPermis = rs.getString(3);
				String nom = rs.getString(4);
				String prenom = rs.getString(5);
				String noPlaque = rs.getString(6);

				Dossier dos = new Dossier(idDossier, idUtilisateur, noPermis,
						nom, prenom, noPlaque);
				lstDossier.add(dos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lstDossier;
	}

	public static Dossier getDossier(String id) {
		Dossier dossier = null;
		try {
			String queryString = String.format(
					"SELECT * FROM dossiers WHERE iddossier='%s'", id);
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);

			while (rs.next()) {
				int idDossier = rs.getInt(1);
				String idUtilisateur = rs.getString(2);
				String noPermis = rs.getString(3);
				String nom = rs.getString(4);
				String prenom = rs.getString(5);
				String noPlaque = rs.getString(6);

				dossier = new Dossier(idDossier, idUtilisateur, noPermis, nom,
						prenom, noPlaque);
				return dossier;
			}

			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dossier;
	}

	public String ajouterDossier(String IdUser, String noPermis, String nom,
			String prenom, String noPlaque) {
		String test = "";
		if (!validatePermis(noPermis)) {
			return "Numero de permis non unique!";
		}
		try {
			String queryString = "INSERT INTO DOSSIERS"
					+ "(iddossier, idutilisateur, numeropermis, nom, prenom, numeroplaque)"
					+ "values (" + (dossiers().size() + 1) + ",'" + IdUser
					+ "','" + noPermis + "','" + nom + "','" + prenom + "','"
					+ noPlaque + "')";
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(queryString);
			conn.close();
			return test;
		} catch (Exception ex) {
			return ex.getMessage();
		}
	}

	private static int size() {
		try {
			String queryString = "SELECT COUNT(*) FROM dossiers_infractions";
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);

			while (rs.next()) {
				return rs.getInt(1);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return 0;
	}

	public static void ajouterInfraction(String idDossier, String idInfraction) {
		try {
			String queryString = String.format("INSERT INTO dossiers_infractions VALUES (%d, '%s', %d)", size() + 1, idDossier, Integer.parseInt(idInfraction));
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(queryString);
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public boolean validatePermis(String permis) {
		for (Dossier dossier : dossiers()) {
			if (dossier.noPermis().equals(permis))
				return false;
		}
		return true;
	}
}
