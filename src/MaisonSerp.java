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
		String chaine=" \nJe suis un �l�ve de Serpentard";
		return chaine;
	}
}