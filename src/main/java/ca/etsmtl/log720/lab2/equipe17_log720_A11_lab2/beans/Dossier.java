package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dossier {

	private int _idDossier;
	private String _numeroPermis;
	private String _idUtilisateur;
	private String _nom;
	private String _prenom;
	private String _numeroPlaque;
	private ArrayList<Integer> _listeReaction;
	private ArrayList<Infraction> _listeInfraction;

	public Dossier(int idDossier, String idUtilisateur, String numeroPermis,
			String nom, String prenom, String noPlaque) {
		this._idDossier = idDossier;
		this._numeroPermis = numeroPermis;
		this._idUtilisateur = idUtilisateur;
		this._nom = nom;
		this._prenom = prenom;
		this._numeroPlaque = noPlaque;
		this._listeReaction = new ArrayList<Integer>();
		this._listeInfraction = new ArrayList<Infraction>();
	}

	public int idDossier() {
		return this._idDossier;
	}

	public String idUtilisateur() {
		return this._idUtilisateur;
	}

	public String nom() {
		return this._nom;
	}

	public String noPermis() {
		return this._numeroPermis;
	}

	public String noPlaque() {
		return this._numeroPlaque;
	}

	public String prenom() {
		return this._prenom;
	}

	public int niveau() {
		if (this._listeInfraction.size() == 0)
			return 0;

		BanqueInfractions banqueInfractions = new BanqueInfractions();

		int highest = 0;
		for (Infraction inf : this._listeInfraction) {
			if (inf.niveau() > highest) {
				highest = inf.niveau();
			}
		}
		return highest;
	}

	public ArrayList<Infraction> getListeInfraction() {
		return this._listeInfraction;
	}

	public HashMap<Infraction, Integer> getFrequencyMapInfraction() {
		HashMap<Infraction, Integer> frequencymap = new HashMap<Infraction, Integer>();

		for (Infraction Inf : this._listeInfraction) {
			if (frequencymap.containsKey(Inf)) {
				frequencymap.put(Inf, frequencymap.get(Inf) + 1);
			} else {
				frequencymap.put(Inf, 1);
			}
		}
		return frequencymap;
	}

	public int[] getListeReaction() {
		return this.convertIntegers(this._listeReaction);
	}

	public void ajouterReactionAListe(int idReaction) {
		this._listeReaction.add(idReaction);
	}

	public void ajouterInfractionAListe(Infraction idInfraction) {
		this._listeInfraction.add(idInfraction);
	}

	public String afficher() {
		return String
				.format("Dossier %d : %s - %s - %s - %s - %s - %d infractions - %d reactions",
						this._idDossier, this._idUtilisateur, this._nom,
						this._prenom, this._numeroPlaque, this._numeroPermis,
						this._listeInfraction.size(),
						this._listeReaction.size());
	}

	private int[] convertIntegers(List<Integer> integers) {
		int[] ret = new int[integers.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = integers.get(i).intValue();
		}
		return ret;
	}

}
