package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

public class Infraction {
	private String _description;
	private int _niveau;
	private int _id;

	public Infraction(int id, String description, int niveau) {
		this._id = id;
		this._description = description;
		this._niveau = niveau;
	}

	public int id() {
		return this._id;
	}

	public String description() {
		return this._description;
	}

	public int niveau() {
		return this._niveau;
	}

	public String afficher() {
		return String.format("Infraction %d: %s :: niveau %d.", this._id,
				this._description, this._niveau);
	}

}
