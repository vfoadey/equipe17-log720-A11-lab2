package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.util.ArrayList;

public class CollectionDossiers {
	private ArrayList<Dossier> _listeDossiers;

	public CollectionDossiers() {
		this._listeDossiers = new ArrayList<Dossier>();
	}

	public Dossier getDossier(int index) {

		for (Dossier d : this._listeDossiers) {
			if (d.idDossier() == index)
				return d;
		}

		return null;
	}

	public int size() {
		return this._listeDossiers.size();
	}

	public ArrayList<Dossier> getListeDossiers() {
		return this._listeDossiers;
	}

}
