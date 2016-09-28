public class MaisonGrif extends Poudlard {

	
	//Constructeurs
	
	
	public MaisonGrif(String unNomEleve, String unNumeroI) {
		super(unNomEleve, unNumeroI);
	}
	
	public MaisonGrif(String unNomEleve) {
		super(unNomEleve);
	}
	@Override
	public String parler() {
		String chaine="\nJe suis un élève de Gryffondor.";
		return chaine;
	}
}