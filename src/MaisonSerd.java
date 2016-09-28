public class MaisonSerd extends Poudlard {

	
	//Constructeurs
	
	
	public MaisonSerd(String unNomEleve, String unNumeroI) {
		super(unNomEleve, unNumeroI);
	}
	
	public MaisonSerd(String unNomEleve) {
		super(unNomEleve);
	}
	
	@Override
	public String parler() {
		String chaine="\nJe suis un élève de Serdaigle";
		return chaine;
	}
}