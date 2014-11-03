package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.util.ArrayList;

public class CollectionInfractions {
	private ArrayList<Infraction> _listeInfraction;

	public CollectionInfractions() {
		this._listeInfraction = new ArrayList<Infraction>();
	}

	public Infraction getInfraction(int index) {
		for (Infraction inf : this._listeInfraction) {
			if (inf.id() == index)
				return inf;
		}
		return null;
	}

	public int size() {
		return this._listeInfraction.size();
	}

	public ArrayList<Infraction> getListeInfractions() {
		return this._listeInfraction;
	}

}
