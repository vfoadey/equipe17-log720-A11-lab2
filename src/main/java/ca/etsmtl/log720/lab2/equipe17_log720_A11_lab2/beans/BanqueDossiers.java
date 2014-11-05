package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BanqueDossiers {

	private CollectionDossiers _collectionDossiers;
	private DataSource ds = null;
	private Connection conn = null;
	private Statement stmt = null;
	private String queryString;
	private int initFlag = 0;

	public BanqueDossiers() {
		this._collectionDossiers = new CollectionDossiers();
		this.initData();
	}

	public CollectionDossiers dossiers() {
		return this._collectionDossiers;
	}

	public CollectionDossiers trouverDossiersParPlaque(String plaque) {
		CollectionDossiers collection = new CollectionDossiers();

		for (Dossier dossier : this._collectionDossiers.getListeDossiers()) {
			if (dossier.noPlaque().equals(plaque)) {
				collection.getListeDossiers().add(dossier);
			}
		}

		return collection;

	}

	public CollectionDossiers trouverDossiersParNom(String nom, String prenom) {
		CollectionDossiers collection = new CollectionDossiers();

		if (nom.equals("")) {
			for (Dossier dossier : this._collectionDossiers.getListeDossiers()) {
				if (dossier.prenom().equals(prenom)) {
					collection.getListeDossiers().add(dossier);
				}
			}
		} else if (prenom.equals("")) {
			for (Dossier dossier : this._collectionDossiers.getListeDossiers()) {
				if (dossier.nom().equals(nom)) {
					collection.getListeDossiers().add(dossier);
				}
			}
		} else {
			for (Dossier dossier : this._collectionDossiers.getListeDossiers()) {
				if (dossier.nom().equals(nom)
						&& dossier.prenom().equals(prenom)) {
					collection.getListeDossiers().add(dossier);
				}
			}
		}

		return collection;
	}

	public Dossier trouverDossierParPermis(String noPermis) {
		for (Dossier dossier : this._collectionDossiers.getListeDossiers()) {
			if (dossier.noPermis().equals(noPermis))
				return dossier;
		}
		return null;
	}

	public Dossier trouverDossierParId(int idDossier) {
		return this._collectionDossiers.getListeDossiers().get(idDossier);

	}

	public void ajouterDossier(String noPermis, String idUtilisateur,
			String nom, String prenom, String noPlaque)
					throws NoPermisExisteDejaException {
		for (Dossier dossier : this._collectionDossiers.getListeDossiers()) {
			if (dossier.noPermis().equals(noPermis))
				throw new NoPermisExisteDejaException(
						"Le numéro de permis est deja utiliser dans un autre dossier");
		}

		Dossier d = new Dossier(this._collectionDossiers.size() + 1, noPermis,
				idUtilisateur, nom, prenom, noPlaque);
		this._collectionDossiers.getListeDossiers().add(d);
		this.saveDossierToDB(d);
	}

	public void ajouterDossier(int idDossier, String noPermis,
			String idUtilisateur, String nom, String prenom, String noPlaque) {

		Dossier d = new Dossier(idDossier, noPermis, idUtilisateur, nom,
				prenom, noPlaque);
		this._collectionDossiers.getListeDossiers().add(d);
		if (this.initFlag == 0) {
			this.saveDossierToDB(d);
		}
	}

	public void ajouterInfractionAuDossier(int idDossier, int idInfraction)
			throws InvalidIdException {
		BanqueInfractions banqueInfraction = new BanqueInfractions();
		for (Dossier dossier : this._collectionDossiers.getListeDossiers()) {
			if (dossier.idDossier() == idDossier) {
				dossier.ajouterInfractionAListe(banqueInfraction
						.trouverInfractionParId(idInfraction));
				try {
					this.initDBConnection();
					this.queryString = "INSERT (idDossier, idInfraction) INTO DOSSIERS_INFRACTION"
							+ "values (" + idDossier + "," + idInfraction + ")";
					this.stmt.executeUpdate(this.queryString);

				} catch (SQLException se) {

				} finally {
					this.closeDBConnection();
				}
				return;
			}
		}

		throw new InvalidIdException("Le ID du dossier fournis n'existe pas.");
	}

	// Initialisation de la connexiona a la base
	public void initDBConnection() {
		try {
			InitialContext ic = new InitialContext(); // JNDI initial context
			this.ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			// lookup
			this.conn = this.ds.getConnection(); // database connection through
			// datasource

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
		// mettre le flag a 1
		this.initFlag = 1;
		try {
			this.queryString = "SELECT * FROM DOSSIERS";
			this.stmt = this.conn.createStatement();
			ResultSet rs = this.stmt.executeQuery(this.queryString);

			while (rs.next()) {
				int idDossier = rs.getInt(1);
				String idUtilisateur = rs.getString(2);
				String noPermis = rs.getString(3);
				String nom = rs.getString(4);
				String prenom = rs.getString(5);
				String noPlaque = rs.getString(6);
				this.ajouterDossier(idDossier, noPermis, idUtilisateur, nom,
						prenom, noPlaque);
			}

			// Ajout récursif des infractions a chaque dossier
			BanqueInfractions banqueInfractions = new BanqueInfractions();
			this.queryString = "SELECT * FROM DOSSIERS_INFRACTIONS";
			rs = this.stmt.executeQuery(this.queryString);
			while (rs.next()) {
				int idDossier = rs.getInt(2);
				int idInfraction = rs.getInt(3);
				Infraction infraction = banqueInfractions
						.trouverInfractionParId(idInfraction);

				for (Dossier d : this._collectionDossiers.getListeDossiers()) {
					if (d.idDossier() == idDossier) {
						d.getListeInfraction().add(infraction);
					}
				}

			}
		} catch (Exception ex) {

		} finally {

			this.closeDBConnection();
		}
		this.initFlag = 0;

	}

	// Ajouter une instance de dossier a la table Dossier
	private int saveDossierToDB(Dossier d) {

		try {
			String queryString = "INSERT INTO DOSSIERS"
					+ "(IDDOSSIER,IDUTILISATEUR,NUMEROPERMIS, NOM, PRENOM, NUMEROPLAQUE)"
					+ "values (" + d.idDossier() + ",'" + d.idUtilisateur()
					+ "','" + d.noPermis() + "','" + d.nom() + "','"
					+ d.prenom() + "','" + d.noPlaque() + "')";
			Statement stmt = this.conn.createStatement();
			return stmt.executeUpdate(queryString);
		} catch (Exception ex) {

		}
		return 0;
	}

	public int deleteDossierFromDB(Dossier d) throws SQLException {

		try {
			this.initDBConnection();
			this.queryString = "DELETE FROM DOSSIER WHERE" + "DOSSIER.ID ="
					+ d.idDossier();
			return this.stmt.executeUpdate(this.queryString);
		} catch (SQLException se) {

		} finally {
			this.closeDBConnection();
		}

		return 0;

	}

}
