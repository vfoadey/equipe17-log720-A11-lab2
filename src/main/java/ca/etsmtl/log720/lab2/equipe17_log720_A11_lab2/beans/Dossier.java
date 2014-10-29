package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dossier {
	
	private int  	_idDossier;	
	private String 	_numeroPermis;
	private String	_idUtilisateur;
	private String 	_nom;
	private String 	_prenom;
	private String	_numeroPlaque;
	private ArrayList<Integer> _listeReaction;
	private ArrayList<Integer> _listeInfraction;

	public Dossier(String numeroPermis, String idUtilisateur, String nom, String prenom, String noPlaque) {
		this._numeroPermis = numeroPermis;
		this._idUtilisateur = idUtilisateur;
		this._nom = nom;
		this._prenom = prenom;
		this._numeroPlaque = noPlaque;
		this._listeReaction = new ArrayList<Integer>();
		this._listeInfraction = new ArrayList<Integer>();
	}
	
	
	public int idDossier() {
		return this._idDossier;		
	}
	
	public String idUtilisateur(){
		return this._idUtilisateur;
	}

	public String nom() {
		return _nom;
	}

	public String noPermis() {
		return this._numeroPermis;
	}

	public String noPlaque() {
		return this._numeroPlaque;
	}

	public String prenom() {
		return _prenom;
	}
	
	public int niveau() {
		if (_listeInfraction.size() == 0) {
			return 0;
		}

		BanqueInfractions banqueInfractions = new BanqueInfractions();

		int highest = 0;
		for (Integer infractionId : _listeInfraction) {
			Infraction infraction = banqueInfractions.trouverInfractionParId(infractionId);
			if (infraction.niveau() > highest) {
				highest = infraction.niveau();
			}
		}
		return highest;
	}

	public int[] getListeInfraction() {
		return convertIntegers(_listeInfraction);
	}

	public HashMap<Integer, Integer>  getFrequencyMapInfraction() {
		HashMap<Integer ,Integer> frequencymap = new HashMap<Integer,Integer>();
		
		for(Integer Inf :_listeInfraction) {
		  if(frequencymap.containsKey(Inf)) {
		    frequencymap.put(Inf, frequencymap.get(Inf)+1);
		  }
		  else{ frequencymap.put(Inf, 1); }
		}
		return frequencymap;
	}
	
	public ArrayList<Integer> CloneArrayList(ArrayList<Integer> list){
		ArrayList<Integer> clone = new ArrayList<Integer>();
		for(Integer i : list) clone.add(i);
		return clone;
	}
	

	public int[] getListeReaction() {
		return convertIntegers(_listeReaction);
	}

	public void ajouterReactionAListe(int idReaction) {
		this._listeReaction.add(idReaction);
	}

	public void ajouterInfractionAListe(int idInfraction) {
		this._listeInfraction.add(idInfraction);
	}

	public String _toString() {
		return String.format("Dossier %d : %s - %s - %s - %s - %d infractions - %d reactions", this._idDossier, this._nom, this._prenom, this._numeroPermis,
				this._numeroPlaque, this._listeInfraction.size(), this._listeReaction.size());
	}

	private int[] convertIntegers(List<Integer> integers) {
		int[] ret = new int[integers.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = integers.get(i).intValue();
		}
		return ret;
	}

	
}
