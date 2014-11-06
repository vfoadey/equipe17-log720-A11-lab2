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

public class BanqueInfractions {

	public static List<Infraction> Infractions() {
		// select *
		InitialContext ic;
		List<Infraction> lstInfraction = new ArrayList<Infraction>();
		try {
			ic = new InitialContext();
			String queryString = "SELECT * FROM Infractions";
			DataSource ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);

			while (rs.next()) {
				int idInfraction = rs.getInt(1);
				String description = rs.getString(2);
				int niveau = rs.getInt(3);

				Infraction infraction = new Infraction(idInfraction,
						description, niveau);
				lstInfraction.add(infraction);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstInfraction;
	}

	public void ajouterInfraction(String description, int niveau) {
		try {
			String queryString = "INSERT INTO INFRACTIONS"
					+ "(IDINFRACTION,DESCRIPTION, NIVEAU)" + "values ("
					+ (Infractions().size() + 1) + ",'" + description + "',"
					+ niveau + ")";
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static List<Infraction> getInfractionsForDossier(String idDossier) {
		List<Infraction> listInfraction = new ArrayList<Infraction>();
		try {
			String queryString = String
					.format("SELECT * FROM infractions i JOIN dossiers_infractions di ON i.idinfraction = di.idinfraction WHERE di.iddossier = '%s'",
							idDossier);
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);

			while (rs.next()) {
				int id = rs.getInt(1);
				String description = rs.getString(2);
				int niveau = rs.getInt(3);

				Infraction i = new Infraction(id, description, niveau);
				listInfraction.add(i);
			}

			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listInfraction;
	}
}
