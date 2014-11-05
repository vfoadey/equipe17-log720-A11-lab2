package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BanqueInfractions {

	private DataSource ds = null;
	private Connection conn = null;
	private Statement stmt = null;
	private String queryString;
	private CollectionInfractions _collectionInfractions;

	public BanqueInfractions() {
		this._collectionInfractions = new CollectionInfractions();
		this.initData();
	}

	public CollectionInfractions infractions() {
		return this._collectionInfractions;
	}

	public CollectionInfractions trouverInfractionsParDossier(Dossier mydossier) {

		CollectionInfractions collectionInfraction = new CollectionInfractions();

		// Recopie de la liste
		for (Infraction inf : mydossier.getListeInfraction()) {
			int flag = 0;
			for (Infraction inf2 : collectionInfraction.getListeInfractions()) {
				if (inf.id() == inf2.id()) {
					flag = 1;
					break;
				}

			}
			if (flag == 0) {
				collectionInfraction.getListeInfractions().add(inf);
			}
		}
		return collectionInfraction;

	}

	public Infraction trouverInfractionParId(int idInfraction) {
		for (Infraction infraction : this._collectionInfractions
				.getListeInfractions()) {
			if (infraction.id() == idInfraction)
				return infraction;
		}
		return null;
	}

	public void ajouterInfraction(int idInfraction, String description,
			int niveau) {

		Infraction infraction = new Infraction(idInfraction, description,
				niveau);
		this._collectionInfractions.getListeInfractions().add(infraction);
	}

	public void ajouterInfraction(String description, int niveau)
			throws NiveauHorsBornesException {

		if (niveau < 1 || niveau > 10)
			throw new NiveauHorsBornesException(
					"Le niveau doit �tre compris entre 1 et 10 inclusivement.");

		Infraction infraction = new Infraction(
				this._collectionInfractions.size() + 1, description, niveau);
		this._collectionInfractions.getListeInfractions().add(infraction);

		this.saveInfractionToDB(infraction);
	}

	// Initialisation de la connexiona a la base
	public void initDBConnection() {
		try {
			InitialContext ic = new InitialContext(); // JNDI initial context
			this.ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			// lookup
			this.conn = this.ds.getConnection(); // database connection through
			// data
			// source
		} catch (SQLException se) {

		} catch (NamingException ne) {

		}
	}

	public void closeDBConnection() {

		try {
			if (this.conn != null) {

				this.conn.close();
			}

			if (this.stmt != null) {
				this.stmt.close();
			}
		} catch (SQLException se) {

		}
	}

	private void initData() {
		// Initialisation datasource
		this.initDBConnection();
		try {
			this.queryString = "SELECT * FROM INFRACTIONS";
			this.stmt = this.conn.createStatement();
			ResultSet rs = this.stmt.executeQuery(this.queryString);

			while (rs.next()) {
				int idInfraction = rs.getInt(1);
				String description = rs.getString(2);
				int niveau = rs.getInt(3);
				this.ajouterInfraction(idInfraction, description, niveau);
			}
		} catch (SQLException se) {

		}
	}

	private int saveInfractionToDB(Infraction inf) {

		try {
			String queryString = "INSERT INTO INFRACTIONS"
					+ "(IDINFRACTION,DESCRIPTION, NIVEAU)" + "values ("
					+ inf.id() + ",'" + inf.description() + "'," + inf.niveau()
					+ ")";
			Statement stmt = this.conn.createStatement();
			return stmt.executeUpdate(queryString);
		} catch (Exception ex) {

		}
		return 0;
	}

}
