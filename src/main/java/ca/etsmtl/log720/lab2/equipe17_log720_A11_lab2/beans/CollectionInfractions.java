package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.util.ArrayList;

public class CollectionInfractions {
	private ArrayList<Infraction> _listeInfraction;

	public CollectionInfractions() {
		_listeInfraction = new ArrayList<Infraction>();
	}

	public Infraction getInfraction (int index) {
		for(Infraction inf : this._listeInfraction){
			
		}
	}

	public int size() {
		return this._listeInfraction.size();
	}
	
	protected ArrayList<Infraction> getListeInfractions() {
		return _listeInfraction;
	}

}
