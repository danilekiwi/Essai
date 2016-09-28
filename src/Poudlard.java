public abstract class Poudlard {

	//Attributs privés
	
	private String nomEleve; 
	private String numeroI;
	

	//Constructeur
	public Poudlard(String unNomEleve){
		this.nomEleve = unNomEleve;
	}
	
	public Poudlard(String unNomEleve, String unNumeroI){
		this.nomEleve = unNomEleve;
		this.numeroI = unNumeroI;
	}
	
	

	public Poudlard(){
	}
	
	//Accesseurs
	//Nom
	public String getNomEleve() {
		return nomEleve;
	}
	public void setNomBateau(String unNomEleve) {
		this.nomEleve = unNomEleve;
	}

	//Numero Immatriculation
	public String getNumeroI() {
		return numeroI;
	}
	public void settype(String unNumeroI) {
		this.numeroI = unNumeroI;
	}
	
	//Chaine
	public String toString(){
		String chaine = "";
		chaine+= " Nom :  " + this.nomEleve;
		chaine+= " \n Maison : " + this.numeroI;
		return chaine;
	}
	
	//Méthode
	public abstract String parler();
}