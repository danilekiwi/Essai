import java.util.ArrayList;
public class Maison{
	//Attribut
	private ArrayList<Poudlard> listeEleve;
	
	//Constructeur
	public Maison(){
		this.listeEleve = new ArrayList<Poudlard>();
	}
	//Supprimer un élève
	public String supprimerEleve(String unNomEleve, String unNumeroI){
		int i=0;
		String chaine="";
		while(i<this.listeEleve.size() && !listeEleve.get(i).getNomEleve().equals(unNomEleve)){
			i=i+1;
		}
			if(i<this.listeEleve.size()){
				this.listeEleve.remove(i);
				chaine="L'élève a été supprimer";
			}
			else{
				chaine="L'élève à supprimer n'existe pas.";
			}
		return chaine;		
	}
	
	//Rechercher un Eleve
	public String rechercheEleve(String unNomEleve,String unNumeroI){
		int i;
		int compteur=0;
		String chaine="";
		for(i=0;i<this.listeEleve.size();i++){
			if(listeEleve.get(i).getNomEleve().equals(unNomEleve)){
				chaine="Trouvé à l'index "+i;
				compteur=compteur+1;
			}
		}
		if(compteur==0){
			chaine="Introuvable";
		}
		return chaine;
	}
	
	//Arriver
	public void arriver(Poudlard unPoudlard){
		int i = 0;
		this.listeEleve.add(unPoudlard);
		i = i + 1;
	}
	
	//Partir
	public void partir(Poudlard unPoudlard){
		this.listeEleve.remove(unPoudlard);
		
	}
	
	//Présentation des Guildes
	public String presenter(){
		String chaine=" ";
		if(this.listeEleve.size()==0){
			chaine="Poudlard n'a encore aucun élève.";
		}
		else{
			for(int i=0;i<this.listeEleve.size();i++){
				chaine+="\nJe me présente :"+this.listeEleve.get(i).toString()+"\n";
				chaine+=this.listeEleve.get(i).parler()+"\n";
			}
		}
		return chaine;
	}
	
}