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

	private DataSource ds = null;
	private Connection conn = null;
	private Statement stmt = null;
	private String queryString;
	private int initFlag = 0;

	public BanqueDossiers() {
		
	}

	public List<Dossier> dossiers() {
		//select *
		InitialContext ic;
		List<Dossier> lstDossier = new ArrayList<Dossier>();
		try {
			ic = new InitialContext();
		queryString = "SELECT * FROM DOSSIERS";
		ds = (DataSource) ic
				.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
		conn = ds.getConnection();
		ResultSet rs = stmt.executeQuery(queryString);
		
		while (rs.next()) {
			int idDossier = rs.getInt(1);
			String idUtilisateur = rs.getString(2);			
			String noPermis = rs.getString(2);
			String nom = rs.getString(3);
			String prenom = rs.getString(4);
			String noPlaque = rs.getString(5);
			Dossier dos = new Dossier(idDossier, idUtilisateur, noPermis,
					nom, prenom, noPlaque);
			lstDossier.add(dos);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstDossier;
	}

	public void ajouterDossier(String IdUser, String noPermis, String nom, String prenom, String noPlaque){
		try {
			String queryString = "INSERT INTO DOSSIER"
					+ "(idutilisateur, numeropermis, nom, prenom, numeroplaque)" + "values ('"
					+ IdUser + "','" + noPermis + "','" + nom + "','" + prenom + "','" + noPlaque
					+ "')";
			InitialContext ic = new InitialContext();;
			ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			conn = ds.getConnection();
			Statement stmt = this.conn.createStatement();
			stmt.execute(queryString);			 
		} catch (Exception ex) {

		}
	}	
}
