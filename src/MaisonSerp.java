public class MaisonSerp extends Poudlard {

	
	
	//Constructeurs
	
	public MaisonSerp(String unNomEleve, String unNumeroI) {
		super(unNomEleve, unNumeroI);
	}
	
	public MaisonSerp(String unNomEleve) {
		super(unNomEleve);
	}
	
	@Override
	public String parler() {
		String chaine=" \nJe suis un élève de Serpentard";
		return chaine;
	}
}