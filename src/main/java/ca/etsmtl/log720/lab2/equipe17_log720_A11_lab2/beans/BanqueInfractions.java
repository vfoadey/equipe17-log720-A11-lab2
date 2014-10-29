package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

public class BanqueInfractions {
	
	private static final String SAVE_FILE = "../../data/BanqueInfraction.txt";

	private CollectionInfractionsImpl _collectionInfraction;

	public BanqueInfractionsImpl() {
		_collectionInfraction = new CollectionInfractionsImpl();
		initData();
	}

	public CollectionInfraction infractions() {
		return toCollectionInfractionCORBA(this._collectionInfraction);
	}

	public CollectionInfraction trouverInfractionsParDossier(Dossier mydossier) {
		CollectionInfractionsImpl collectionInfraction = new CollectionInfractionsImpl();

		int[] infractions = mydossier.getListeInfraction();

		for (int i = 0; i < infractions.length; i++) {
			for (InfractionImpl infraction : _collectionInfraction.getListeInfractions()) {
				if (infractions[i] == infraction.id()) {
					collectionInfraction.getListeInfractions().add(infraction);
				}
			}
		}

		return toCollectionInfractionCORBA(collectionInfraction);
	}

	public Infraction trouverInfractionParId(int idInfraction) {
		for (InfractionImpl infraction : _collectionInfraction.getListeInfractions()) {
			if (infraction.id() == idInfraction) {
				return toInfractionCORBA(infraction);
			}
		}
		return null;
	}

	public void ajouterInfraction(String description, int niveau) throws NiveauHorsBornesException {

		if (niveau < 1 || niveau > 10) {
			throw new NiveauHorsBornesException("Le niveau doit être compris entre 1 et 10 inclusivement.");
		}

		InfractionImpl infraction = new InfractionImpl(_collectionInfraction.size(), description, niveau);
		_collectionInfraction.getListeInfractions().add(infraction);

		saveChangesToFile();
	}

	private Infraction toInfractionCORBA(InfractionImpl infraction) {
		try {
			POA rootpoa = Server._poa;
			org.omg.CORBA.Object obj = rootpoa.servant_to_reference(infraction);
			return InfractionHelper.narrow(obj);
		} catch (Exception ex) {
			System.out.println("Erreur retour de l'object Infraction: " + ex);
			return null;
		}
	}

	private CollectionInfraction toCollectionInfractionCORBA(CollectionInfractionsImpl collection) {
		try {
			POA rootpoa = Server._poa;
			org.omg.CORBA.Object obj = rootpoa.servant_to_reference(collection);
			return CollectionInfractionHelper.narrow(obj);
		} catch (Exception ex) {
			System.out.println("Erreur retour de l'object CollectionInfraction: " + ex);
			return null;
		}
	}

	private void initData() {
		try {
			File saveFile = new File(SAVE_FILE);
			BufferedReader br = new BufferedReader(new FileReader(saveFile));
			String line;
			while ((line = br.readLine()) != null) {

				String[] strings = line.split(";");

				InfractionImpl infraction = new InfractionImpl(Integer.parseInt(strings[0]), strings[1], Integer.parseInt(strings[2]));

				_collectionInfraction.getListeInfractions().add(infraction);
			}
			br.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		System.out.println(String.format("*** Finished BanqueInfractions initialization : %d files created. ***", _collectionInfraction
				.getListeInfractions().size()));
	}
	
	private void saveChangesToFile() {
		clearFileContent();

		try {
			File fout = new File(SAVE_FILE);
			FileOutputStream fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			int id = 0;
			for (InfractionImpl infraction : _collectionInfraction.getListeInfractions()) {

				bw.write(String.format("%d;%s;%d;", id++, infraction.description(), infraction.niveau()));
				bw.newLine();
			}

			bw.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private void clearFileContent() {
		try {
			PrintWriter writer = new PrintWriter(new File(SAVE_FILE));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

}
