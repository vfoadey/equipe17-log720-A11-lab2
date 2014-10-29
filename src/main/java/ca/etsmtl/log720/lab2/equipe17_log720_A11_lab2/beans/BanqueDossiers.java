package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class BanqueDossiers {
	
	private CollectionDossiers _collectionDossiers;
	DataSource ds = null;
    Connection conn = null;
    private int initFlag = 0;

	public BanqueDossiers() {
		_collectionDossiers = new CollectionDossiers();
		initData();
	}

	public CollectionDossiers dossiers() {
		return this._collectionDossiers;
	}

	public CollectionDossiers trouverDossiersParPlaque(String plaque) {
		CollectionDossiers collection = new CollectionDossiers();

		for (Dossier dossier : _collectionDossiers.getListeDossiers()) {
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
			for (Dossier dossier : _collectionDossiers.getListeDossiers()) {
				if (dossier.nom().equals(nom)) {
					collection.getListeDossiers().add(dossier);
				}
			}
		} else {
			for (Dossier dossier : _collectionDossiers.getListeDossiers()) {
				if (dossier.nom().equals(nom) && dossier.prenom().equals(prenom)) {
					collection.getListeDossiers().add(dossier);
				}
			}
		}
		
		return  collection;
	}

	public Dossier trouverDossierParPermis(String noPermis) {
		for (Dossier dossier : this._collectionDossiers.getListeDossiers()) {
			if (dossier.noPermis().equals(noPermis)) {
				return dossier;
			}
		}
		return null;
	}

	public Dossier trouverDossierParId(int idDossier) {
		return this._collectionDossiers.getListeDossiers().get(idDossier);
		
	}

	public void ajouterDossier(int idDossier, String noPermis, String idUtilisateur, String nom, String prenom, String noPlaque) throws NoPermisExisteDejaException {
		for (Dossier d : _collectionDossiers.getListeDossiers()) {
			if (d.noPermis().equals(noPermis) || (d.idDossier() == idDossier)) {
				throw new NoPermisExisteDejaException("Le numéro de permis est deja utiliser dans un autre dossier");
			}
		}
		
		Dossier d = new Dossier(noPermis, idUtilisateur, nom, prenom, noPlaque);
		_collectionDossiers.getListeDossiers().add(d);
		if(initFlag == 0) saveToDB(d);
	}

	public void ajouterInfractionAuDossier(int idDossier, int idInfraction) throws InvalidIdException {
		for(Dossier d : this._collectionDossiers.getListeDossiers()) {
			if(d.idDossier() == idDossier) {
				d.ajouterInfractionAListe(idInfraction);
			}
		}
	}

    //Initialisation de la connexiona a la base
    public void initDBConnection() throws ServletException {
      try {
        InitialContext ic = new InitialContext();  // JNDI initial context
        ds = (DataSource) ic.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI lookup
        conn = ds.getConnection();  // database connection through data source
      }
      catch (SQLException se) {
        throw new ServletException(se);
      }
      catch (NamingException ne) {
        throw new ServletException(ne);
      }
    }

    private void initData() {
    	//Initialisation datasource
    	initDBConnection();
    	//mettre le flag a 1
    	initFlag = 1;
    	try {
		String queryString ="SELECT * FROM DOSSIERS";
		Statement stmt = conn.createStatement();
		ResultSet  rs = stmt.executeQuery(queryString);
		
		while(rs.next()){
			int idDossier = rs.getInt(1);
			String idUtilisateur = rs.getString(2);
			String noPermis = rs.getString(2);
			String nom = rs.getString(3);
			String prenom = rs.getString(4);
			String  noPlaque = rs.getString(5);
			this.ajouterDossier(idDossier, noPermis, idUtilisateur, nom, prenom, noPlaque);	
			}
		}
		catch(Exception ex){
			
		}
    	initFlag = 0;
	
    }

	private void saveAllDossierListToDB() {
			int flag = 0;
			try{
			for(int i = 0; i<= this._collectionDossiers.getListeDossiers().size(); i++){
				Dossier d = this._collectionDossiers.getListeDossiers().get(i);
				
				String queryString ="INSERT INTO DOSSIERS"+
						"(NUMEROPERMIS, IDUTILISATEUR, NOM, PRENOM, NUMEROPLAQUE)" +
						"values ("+ d.noPermis()+","+ d.idUtilisateur()+","+ d.nom()+","+ d.prenom()+","+d.noPlaque()+")";
				Statement stmt = conn.createStatement();
				flag = stmt.executeUpdate(queryString);
			}
			} catch(Exception ex){
				
			}
				
		}
	
	//Ajouter une instance de dossier a la table Dossier
	private int saveToDB(Dossier d) {
		
		try{
			String queryString ="INSERT INTO DOSSIERS"+
					"(IDDOSSIER,NUMEROPERMIS, IDUTILISATEUR, NOM, PRENOM, NUMEROPLAQUE)" +
					"values ("+ d.idDossier()+","+ d.noPermis()+","+ d.idUtilisateur()+","+ d.nom()+","+ d.prenom()+","+d.noPlaque()+")";
			Statement stmt = conn.createStatement();
			return stmt.executeUpdate(queryString);		
			} catch(Exception ex) {
			
		}
		return 0;
	}

	private void clearFileContent() {
		
	}

}
