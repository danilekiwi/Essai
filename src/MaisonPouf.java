public class MaisonPouf extends Poudlard {

	
	
	//Constructeurs
	
	public MaisonPouf(String unNomEleve, String unNumeroI) {
		super(unNomEleve, unNumeroI);
	}
	
	public MaisonPouf(String unNomEleve) {
		super(unNomEleve);
	}
	
	@Override
	public String parler() {
		String chaine=" \nJe suis un élève de Poufsouffle";
		return chaine;
	}
}