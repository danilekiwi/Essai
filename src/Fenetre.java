import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Fenetre extends JFrame implements ActionListener{
	private JPanel panel ;
	private JPanel panel2=new JPanel() ;
	private JPanel panel3=new JPanel() ;
	private JMenuBar jmb = new JMenuBar();
	private JButton btnClic=new JButton("Ajouter un �l�ve.");
	private JButton btnClic2=new JButton("Supprimer un �l�ve.");
	private JButton btnClic3=new JButton("Voir les �l�ves pr�sent � Poudlard.");
	private JButton btnClic4=new JButton("Rechercher un �l�ve.");
	private Maison maMaison = new Maison();
	private JTextField jtfNomRecherche= new JTextField(10);
	private JLabel resultatRecherche = new JLabel ();
	private JTextField jtfNomSupprimer= new JTextField(10);
	private JLabel resultatSuppression = new JLabel ();
	private JButton btnAjouter = new JButton("Ajouter");
	private JTextField jtfNomEleve= new JTextField(10);
	private JButton btnEleveGrif=new JButton("Eleve de Gryffondor");
	private JButton btnEleveSerp=new JButton("Eleve de Serpentard");
	private JButton btnEleveSerd=new JButton("Eleve de Serdaigle");
	private JButton btnElevePouf=new JButton("Eleve de Poufsouffle");
	private String numeroI;
	private JLabel resultatAjout = new JLabel ();
	private JButton btnSupprimer = new JButton("Supprimer");
	JButton btnRechercher = new JButton("Rechercher");
	
	
	
	public Fenetre(){
		this.setTitle("Poudlard"); // Donner un titre � la fen�tre
		/* La m�thode setLocationRelativeTo permet de d�terminer le positionnement de la fen�tre. Si
		le param�tre est null, la fen�tre sera centr�e.*/
		this.setLocationRelativeTo(null);
		
		this.setContentPane(new AfficheImage("Poudlard.jpg"));
		
		// Fermeture de la fen�tre lorsque l'on clique sur la croix (sinon la fen�tre sera ferm�e mais le programme toujours en cours d'ex�cution)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* La m�thode setSize permet de d�terminer la taille. Les deux param�tres correspondent
		respectivement � la largeur puis � la hauteur, le tout exprim� en pixels.*/
		this.setSize(700, 300);
		this.setResizable(true); // On interdit le redimensionnement de la fen�tre
		
		
		btnClic.addActionListener(new ActionAjouter());
		btnClic2.addActionListener(new ActionSupprimer());
		btnClic3.addActionListener(new ActionAfficher());
		btnClic4.addActionListener(new ActionRechercher());
		
		panel = new JPanel ( ) ;
		panel.setLayout(new BorderLayout());
		
		panel.add(panel2, BorderLayout.CENTER);
		panel.add(panel3, BorderLayout.NORTH);
		
		//TEST JMenuBar
		JMenuBar jmb = new JMenuBar();
		JMenu ajt = new JMenu("Ajouter un �l�ve.");
		jmb.add(ajt);
		JMenu supp = new JMenu("Supprimer un �l�ve.");
		jmb.add(supp);
		JMenu rch = new JMenu("Rechercher un �l�ve.");
		jmb.add(rch);
	/*	panel2.setLayout(new FlowLayout());
		panel2.add(btnClic);
		panel2.add(btnClic2);
		panel2.add(btnClic3);
		panel2.add(btnClic4);*/
		
		panel3.setLayout(new BorderLayout());
		/*this.getContentPane().add(panel);*/
		this.getContentPane().add(jmb);
			
		this.setVisible(true); // Par d�faut la fen�tre est invisible. Derni�re instruction du constructeur
	}
	
	
	public void ChangerPanelAjouter(){
		btnEleveGrif.setEnabled(true);
		btnEleveSerp.setEnabled(true);
		btnEleveSerd.setEnabled(true);
		btnElevePouf.setEnabled(true);
		btnAjouter.setEnabled(false);
		resultatAjout.setText(" ");
		JPanel panelAjout=new JPanel();
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionRetour());
		btnAjouter.addActionListener(new ActionCreerEleve());
		
		JLabel lblNom=new JLabel("Entrez le nom de l'�l�ve : ");
		btnEleveGrif.addActionListener(new ActionMaisonChoisi());
		btnEleveSerp.addActionListener(new ActionMaisonChoisi());		
		btnEleveSerd.addActionListener(new ActionMaisonChoisi());
		btnElevePouf.addActionListener(new ActionMaisonChoisi());
		
		JPanel panelNom=new JPanel();
		panelNom.setLayout(new FlowLayout());
		panelNom.add(lblNom);
		panelNom.add(jtfNomEleve);
		panelNom.add(btnAjouter);
		
		
		JPanel panelnumeroI=new JPanel();
		panelnumeroI.setLayout(new FlowLayout());
		panelnumeroI.add(btnEleveGrif);
		panelnumeroI.add(btnEleveSerp);
		panelnumeroI.add(btnEleveSerd);
		panelnumeroI.add(btnElevePouf);

		
		JPanel hautPanel=new JPanel();
		hautPanel.setLayout(new BorderLayout());
		hautPanel.add(panelnumeroI, BorderLayout.NORTH);
		hautPanel.add(panelNom, BorderLayout.CENTER);
		
		
		panelAjout.setLayout(new BorderLayout());
		panelAjout.add(hautPanel, BorderLayout.NORTH);
		panelAjout.add(resultatAjout, BorderLayout.CENTER);
		panelAjout.add(btnRetour, BorderLayout.SOUTH);

		this.setContentPane(panelAjout);
		this.revalidate();
	}
		
	public void ChangerPanelSupprimer(){
		btnEleveGrif.setEnabled(true);
		btnEleveSerp.setEnabled(true);
		btnEleveSerd.setEnabled(true);
		btnElevePouf.setEnabled(true);
		btnSupprimer.setEnabled(false);
		resultatSuppression.setText(" ");
		
		JPanel panelSupprimer=new JPanel();
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionRetour());
		JPanel panelNomSupp=new JPanel();
		JLabel lblNomSupp=new JLabel("Entrez le nom de l'�l�ve � supprimer : ");
		
		btnSupprimer.addActionListener(new ActionSupprimer2());
		btnEleveGrif.addActionListener(new ActionMaisonChoisi());
		btnEleveSerp.addActionListener(new ActionMaisonChoisi());
		btnEleveSerd.addActionListener(new ActionMaisonChoisi());
		btnElevePouf.addActionListener(new ActionMaisonChoisi());

		
		JPanel panelnumeroISupp = new JPanel();
		panelnumeroISupp.setLayout(new FlowLayout());
		panelnumeroISupp.add(btnEleveGrif);
		panelnumeroISupp.add(btnEleveSerp);
		panelnumeroISupp.add(btnEleveSerd);
		panelnumeroISupp.add(btnElevePouf);
		
		
		panelNomSupp.setLayout(new FlowLayout());
		panelNomSupp.add(lblNomSupp);
		panelNomSupp.add(jtfNomSupprimer);
		panelNomSupp.add(btnSupprimer);
		
		JPanel panelHautSupp = new JPanel();
		panelHautSupp.setLayout(new BorderLayout());
		panelHautSupp.add(panelnumeroISupp, BorderLayout.NORTH);
		panelHautSupp.add(panelNomSupp, BorderLayout.CENTER);
		
		panelSupprimer.setLayout(new BorderLayout());
		panelSupprimer.add(panelHautSupp, BorderLayout.NORTH);
		panelSupprimer.add(resultatSuppression, BorderLayout.CENTER);
		panelSupprimer.add(btnRetour, BorderLayout.SOUTH);
		
		this.setContentPane(panelSupprimer);
		this.revalidate();
		
	}
	
	public void ChangerPanelAfficher(){
		JTextArea afficherContenu = new JTextArea();
		afficherContenu.setText(" ");
		JScrollPane BarreDeroulement = new JScrollPane(afficherContenu,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setPreferredSize(new Dimension(450,110));
		JPanel panelAfficher=new JPanel();
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionRetour());
		
		JLabel presentation =new JLabel("Voici les �l�ves pr�sents � Poudlard :");
		afficherContenu.setText(maMaison.presenter());
		afficherContenu.setEditable(false);
		
		panelAfficher.setLayout(new BorderLayout());
		panelAfficher.add(presentation, BorderLayout.NORTH); 
		panelAfficher.add(BarreDeroulement, BorderLayout.CENTER); 
		panelAfficher.add(btnRetour, BorderLayout.SOUTH); 
		
		this.setContentPane(panelAfficher);
		this.revalidate();
	}
	
	public void ChangerPanelRechercher(){
		btnEleveGrif.setEnabled(true);
		btnEleveSerp.setEnabled(true);
		btnEleveSerd.setEnabled(true);
		btnElevePouf.setEnabled(true);
		btnRechercher.setEnabled(false);
		resultatRecherche.setText(" ");
		JPanel panelRechercher=new JPanel();
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionRetour());
		JLabel lblNomRecherche=new JLabel("Entrez le nom de l'�l�ve rechercher : ");
		
		
		btnRechercher.addActionListener(new ActionRechercher2());
		btnEleveGrif.addActionListener(new ActionMaisonChoisi());
		btnEleveSerp.addActionListener(new ActionMaisonChoisi());
		btnEleveSerd.addActionListener(new ActionMaisonChoisi());
		btnElevePouf.addActionListener(new ActionMaisonChoisi());
		
		JPanel panelnumeroIRecherche = new JPanel();
		panelnumeroIRecherche.setLayout(new FlowLayout());
		panelnumeroIRecherche.add(btnEleveGrif);
		panelnumeroIRecherche.add(btnEleveSerp);
		panelnumeroIRecherche.add(btnEleveSerd);
		panelnumeroIRecherche.add(btnElevePouf);
		
		JPanel panelNomRecherche=new JPanel();
		panelNomRecherche.setLayout(new FlowLayout());
		panelNomRecherche.add(lblNomRecherche);
		panelNomRecherche.add(jtfNomRecherche);
		panelNomRecherche.add(btnRechercher);
		
		JPanel panelHautRecherche=new JPanel();
		panelHautRecherche.setLayout(new BorderLayout());
		panelHautRecherche.add(panelnumeroIRecherche, BorderLayout.NORTH);
		panelHautRecherche.add(panelNomRecherche, BorderLayout.CENTER);
		
		panelRechercher.setLayout(new BorderLayout());
		panelRechercher.add(panelHautRecherche, BorderLayout.NORTH);
		panelRechercher.add(resultatRecherche, BorderLayout.CENTER);
		panelRechercher.add(btnRetour, BorderLayout.SOUTH);
		
		this.setContentPane(panelRechercher);
		this.revalidate();
	
	}
	
	public void ChangerPanelRetour(){
		this.setContentPane(panel);
		this.revalidate();
	}
	
	public class ActionCreerEleve implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(numeroI){
			
			case "EleveGrif":
				Poudlard unPoudlardGrif = new MaisonGrif(jtfNomEleve.getText(), numeroI);
				maMaison.arriver(unPoudlardGrif);
				btnAjouter.setEnabled(false);
				resultatAjout.setText("L'�l�ve de Gryffondor a �t� ajout�.");
			break;
			
			case "EleveSerp":
				Poudlard unPoudlardSerp = new MaisonSerp(jtfNomEleve.getText(), numeroI);
				maMaison.arriver(unPoudlardSerp);
				btnAjouter.setEnabled(false);
				resultatAjout.setText("L'�l�ve de Serpentard a �t� ajout�.");
			break;
			
			case "EleveSerd":
				Poudlard unPoudlardSerd = new MaisonSerd(jtfNomEleve.getText(), numeroI);
				maMaison.arriver(unPoudlardSerd);
				btnAjouter.setEnabled(false);
				resultatAjout.setText("L'�l�ve de Serdaigle a �t� ajout�.");
			break;
			
			case "ElevePouf":
				Poudlard unPoudlardPouf = new MaisonPouf(jtfNomEleve.getText(), numeroI);
				maMaison.arriver(unPoudlardPouf);
				btnAjouter.setEnabled(false);
				resultatAjout.setText("L'�l�ve de Poufsouffle a �t� ajout�.");
			break;
			
		}
		}
	}

	public class ActionMaisonChoisi implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==btnEleveGrif){
				btnEleveGrif.setEnabled(false);
				btnEleveSerp.setEnabled(true);
				btnEleveSerd.setEnabled(true);
				btnAjouter.setEnabled(true);
				btnSupprimer.setEnabled(true);
				btnRechercher.setEnabled(true);
				numeroI="EleveGrif";
			}
			else{
				if(arg0.getSource()==btnEleveSerp){
					btnEleveGrif.setEnabled(true);
					btnEleveSerp.setEnabled(false);
					btnEleveSerd.setEnabled(true);
					btnAjouter.setEnabled(true);
					btnSupprimer.setEnabled(true);
					btnRechercher.setEnabled(true);
					numeroI="EleveSerp";
				}
				else{
					if(arg0.getSource()==btnEleveSerd){
						btnEleveGrif.setEnabled(true);
						btnEleveSerp.setEnabled(true);
						btnEleveSerd.setEnabled(false);
						btnAjouter.setEnabled(true);
						btnSupprimer.setEnabled(true);
						btnRechercher.setEnabled(true);
						numeroI="EleveSerd";
					}
					else{
						if(arg0.getSource()==btnElevePouf){
							btnEleveGrif.setEnabled(true);
							btnEleveSerp.setEnabled(true);
							btnEleveSerd.setEnabled(true);
							btnElevePouf.setEnabled(false);
							btnAjouter.setEnabled(true);
							btnSupprimer.setEnabled(true);
							btnRechercher.setEnabled(true);
							numeroI="ElevePouf";
						}

					}

				}
			}
		}
	}
		
	public class ActionSupprimer2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(jtfNomSupprimer.getText()!=null && numeroI!=null){
				resultatSuppression.setText(maMaison.supprimerEleve(jtfNomSupprimer.getText(),numeroI));
			}
			else{
				resultatSuppression.setText("Bateau Introuvable");
			}
		}
	}
	
	public class ActionRechercher2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			resultatRecherche.setText(maMaison.rechercheEleve(jtfNomRecherche.getText(),numeroI));
		}
	}
	
	public class ActionAjouter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Fenetre.this.ChangerPanelAjouter();
		}
	}
	
	public class ActionSupprimer implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Fenetre.this.ChangerPanelSupprimer();
		}
	}
	
	public class ActionAfficher implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Fenetre.this.ChangerPanelAfficher();
		}
	}
	
	public class ActionRechercher implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Fenetre.this.ChangerPanelRechercher();
		}
	}
	
	public class ActionRetour implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Fenetre.this.ChangerPanelRetour();
		}	
	}
	
	public void actionPerformed(ActionEvent arg0) {
	}

	class AfficheImage extends JPanel
	{
	    // D�claration de la propri�t� fond de type Image
	    private Image fond;

	    // Cr�ation du constructeur de la classe
	    AfficheImage(String s)
	    {
	        // Permet de charger une image
	        fond = getToolkit().getImage(s);
	    }
	    
	   /* Cette m�thode est appel�e  automatiquement lors du chargement ou du redimensionnement 
	        de la fen�tre*/
	    
	   //Override
	    public void paintComponent(Graphics g)
	    {
	        super.paintComponent(g);
	        g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
	    }
	}
	
}
