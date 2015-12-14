package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

@SuppressWarnings("serial")
public class FenetreCapteur extends JFrame {

	ArrayList<Capteur> listeCapteur = new ArrayList<Capteur>();
	JComboBox<String> listeCap = new JComboBox<String>();
	ArrayList<Moniteur> listeMoniteur = new ArrayList<Moniteur>();


	public FenetreCapteur(){
		this.setTitle("Création de capteur");

		this.setSize(400,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		initComponent();
		setVisible(true);
		//pack();
	}


	public void initComponent(){

		Container contentPane = getContentPane();
		JLabel nomLabel = new JLabel("Texte de test");

		//Choix emplacement
		JPanel panLoc = new JPanel();
		panLoc.setBackground(Color.white);
		panLoc.setBorder(BorderFactory.createTitledBorder("Choix de l'emplacement"));
		panLoc.setPreferredSize(new Dimension(240, 60));
		JComboBox<String> listeSalle = new JComboBox<String>();
		JLabel labelSalle = new JLabel("Liste des salles : ");
		//listeSalle.addItem("------");
		listeSalle.addItem("B204");
		listeSalle.addItem("B206");
		listeSalle.addItem("B208");
		listeSalle.addItem("B212");
		panLoc.add(labelSalle);
		panLoc.add(listeSalle);

		//choix nom du capteur
		JPanel panNom = new JPanel();
		panNom.setBackground(Color.white);
		panNom.setBorder(BorderFactory.createTitledBorder("Choix du nom du capteur"));
		panNom.setPreferredSize(new Dimension(240, 60));
		JTextField nom = new JTextField();
		nom.setPreferredSize(new Dimension(100, 25));
		nomLabel = new JLabel("Saisir un nom : ");
		panNom.add(nomLabel);
		panNom.add(nom);

		//choix niveau d'importance
		JPanel panLevel = new JPanel();
		panLevel.setBackground(Color.white);
		panLevel.setBorder(BorderFactory.createTitledBorder("Choix du niveau d'alarme"));
		panLevel.setPreferredSize(new Dimension(320, 60));
		JRadioButton jr1 = new JRadioButton("Niveau 1");
		jr1.setSelected(true);
		JRadioButton jr2 = new JRadioButton("Niveau 2");
		JRadioButton jr3 = new JRadioButton("Niveau 3");
		ButtonGroup bg = new ButtonGroup();
		jr1.setBackground(Color.white);
		jr2.setBackground(Color.white);
		jr3.setBackground(Color.white);
		bg.add(jr1);
		bg.add(jr2);
		bg.add(jr3);
		panLevel.add(jr1);
		panLevel.add(jr2);
		panLevel.add(jr3);

		//if type == radiation choix niveau radiation
		JPanel panRad = new JPanel();
		panRad.setBackground(Color.white);
		panRad.setBorder(BorderFactory.createTitledBorder("Choix du niveau de radiation"));
		panRad.setPreferredSize(new Dimension(240, 60));
		JLabel labelRad = new JLabel("Niveau de radiation (1-100):");
		/*JTextField radlevel = new JTextField();
	    radlevel.setPreferredSize(new Dimension(50, 25));
	    panRad.add(radlevel);*/
		panRad.add(labelRad);
		//restriction des inputs
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1);
		formatter.setMaximum(100);
		// If you want the value to be committed on each keystroke instead of focus lost
		formatter.setCommitsOnValidEdit(true);
		JFormattedTextField radlevel = new JFormattedTextField(formatter);
		radlevel.setPreferredSize(new Dimension(50, 25));
		panRad.add(radlevel);

		//boutons de création du capteur
		JPanel submit = new JPanel();
		JButton submitButton = new JButton("Création");
		submit.add(submitButton);

		//bouton de génération d'alarme
		JPanel generate = new JPanel();
		JButton generateAlarmeButton = new JButton("Générer alarme");
		generate.add(generateAlarmeButton);


		//if type == gaz choix type gaz
		JPanel panGazType = new JPanel();
		panGazType.setBackground(Color.white);
		panGazType.setBorder(BorderFactory.createTitledBorder("Choix du type de gaz"));
		panGazType.setPreferredSize(new Dimension(320, 60));
		JComboBox<String> listeGaz = new JComboBox<String>();
		JLabel labelGaz = new JLabel("Choix du type de gaz : ");
		listeGaz.addItem("Méthane");
		listeGaz.addItem("Acétylène");
		listeGaz.addItem("Monoxyde de carbone");
		listeGaz.addItem("Sulfure d'hydrogène");
		panGazType.add(labelGaz);
		panGazType.add(listeGaz);

		//choix type d'alarme
		JPanel panType = new JPanel();
		panType.setBackground(Color.white);
		panType.setBorder(BorderFactory.createTitledBorder("Choix du type de capteur"));
		panType.setPreferredSize(new Dimension(320, 60));
		JComboBox<String> listeTypeCapteur = new JComboBox<String>();
		JLabel labelAlarme = new JLabel("Types : ");
		
		//Classe écoutant la liste des types de gaz
		class ItemActionListeTypeCapteur implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionListener : action sur " + listeTypeCapteur.getSelectedItem());
				if (listeTypeCapteur.getSelectedItem().equals("Gaz")){
					panGazType.setVisible(true);
				}
				else {
					panGazType.setVisible(false);					
				}
			}
		}
		
		listeTypeCapteur.addActionListener(new ItemActionListeTypeCapteur());
		

		//Classe d'écouteurs de la liste déroulante des capteurs
		class ItemActionListeCapteur implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionListener : action sur " + listeCap.getSelectedItem());
				for (int i=0; i < listeCapteur.size(); i++){
					if (listeCapteur.get(i).getNom().equals(listeCap.getSelectedItem())){
						if (listeCapteur.get(i).getClass().getName().substring(12).equals("Rad")){
							panRad.setVisible(true);
						}
						else {
							panRad.setVisible(false);
						}
					}
				}
			}
		}




		listeTypeCapteur.addItem("Incendie");
		listeTypeCapteur.addItem("Réfrigération");
		listeTypeCapteur.addItem("Radiation");
		listeTypeCapteur.addItem("Gaz");
		panType.add(labelAlarme);
		panType.add(listeTypeCapteur);

		//Liste des capteurs existants
		JPanel panListeCap = new JPanel();
		panListeCap.setBackground(Color.white);
		panListeCap.setBorder(BorderFactory.createTitledBorder("Choix du capteur"));
		panListeCap.setPreferredSize(new Dimension(320, 60));
		//JComboBox<String> listeCap = new JComboBox<String>();
		JLabel labelListeCap = new JLabel("Capteurs existants : ");
		panListeCap.add(labelListeCap);
		panListeCap.add(listeCap);
		listeCap.addActionListener(new ItemActionListeCapteur());


		//Classe écoutant le bouton de création de capteur
		class BoutonCreationListener implements ActionListener{

			//Redéfinition de la méthode actionPerformed()
			public void actionPerformed(ActionEvent arg0) {
				//affichage dans la console
				System.out.println("ActionListener : action sur le bouton de création");

				//récupération des valeurs des champs
				String emplacement = (String)listeSalle.getSelectedItem();
				String strnom = nom.getText();
				
				//On vérifie si un capteur n'a pas déjà le même nom
				boolean existant = false;
				for (int i =0; i < listeCapteur.size();i++){
					if (listeCapteur.get(i).getNom().equals(strnom)){
						existant = true;
					}
					else{
						existant = false;
					}
				}

				//création du capteur
				if(existant == false){
					if (listeTypeCapteur.getSelectedItem().equals("Incendie")){
						CapteurFeu c = new CapteurFeu(strnom,emplacement);
						listeCapteur.add(c);
						listeCap.addItem(strnom);
						for(EcouteurCreationCapteur mon:listeMoniteur){
							mon.ecouterCapteur(c);
						}
						System.out.println("Un capteur feu à été créé.");
					}
					else if (listeTypeCapteur.getSelectedItem().equals("Gaz")){
						CapteurGaz cg = new CapteurGaz(strnom,emplacement,(String)listeGaz.getSelectedItem());
						listeCapteur.add(cg);
						for(EcouteurCreationCapteur mon:listeMoniteur){
							mon.ecouterCapteur(cg);
						}
						System.out.println("Un capteur de gaz " + (String)listeGaz.getSelectedItem() + " à été créé.");
						listeCap.addItem(strnom);
					}
					else if (listeTypeCapteur.getSelectedItem().equals("Réfrigération")){
						CapteurFrigo cf = new CapteurFrigo(strnom,emplacement);
						listeCapteur.add(cf);
						for(EcouteurCreationCapteur mon:listeMoniteur){
							mon.ecouterCapteur(cf);
						}
						System.out.println("Un capteur frigo à été créé.");
						listeCap.addItem(strnom);
					}
					else if (listeTypeCapteur.getSelectedItem().equals("Radiation")){
						CapteurRad cr = new CapteurRad(strnom,emplacement);
						listeCapteur.add(cr);
						for(EcouteurCreationCapteur mon:listeMoniteur){
							mon.ecouterCapteur(cr);
						}
						System.out.println("Un capteur de radiation à été créé.");
						listeCap.addItem(strnom);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Vous ne pouvez pas créer un capteur avec le nom d'un capteur déja existant.", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		// classe de l'écouteur du bouton de génération d'alarme
		class BoutonGenerationListener implements ActionListener{

			//fonction de récupération du niveau dans le formulaire
			int niveau(){
				return (jr1.isSelected()) ? 1 : 
					(jr2.isSelected()) ? 2 : 
						(jr3.isSelected()) ? 3 : 
							1;
			}


			//Redéfinition de la méthode actionPerformed()
			public void actionPerformed(ActionEvent arg0) {
				//récupération des valeurs
				int niveauAlarme = niveau();
				@SuppressWarnings("unused")
				String gazAlarme = (String)listeGaz.getSelectedItem();

				//affichage dans la console
				System.out.println("ActionListener : action sur le bouton de génération d'alarme");

				//génération de l'alarme
				for (int i=0; i < listeCapteur.size(); i++){
					if (listeCapteur.get(i).getNom().equals(listeCap.getSelectedItem())){
						if (listeCapteur.get(i).getClass().getName().substring(12).equals("Feu")){
							listeCapteur.get(i).generateEvent(niveauAlarme);
						}
						else if (listeCapteur.get(i).getClass().getName().substring(12).equals("Gaz")){
							listeCapteur.get(i).generateEvent(niveauAlarme);
						}
						else if (listeCapteur.get(i).getClass().getName().substring(12).equals("Frigo")){
							listeCapteur.get(i).generateEvent(niveauAlarme);
						}
						else if (listeCapteur.get(i).getClass().getName().substring(12).equals("Rad")){
							int radLvlAlarme = Integer.parseInt(radlevel.getText());
							listeCapteur.get(i).generateEvent(niveauAlarme, radLvlAlarme);
						}
					}
				}

			}
		}

		//Ajout de l'écouteur au bouton de création du capteur
		submitButton.addActionListener(new BoutonCreationListener());

		//Ajout de l'écouteur au bouton de génération d'alarme
		generateAlarmeButton.addActionListener(new BoutonGenerationListener());



		//Ajout des composants aux Jpanels------------------------------------------------

		//panneau de création capteur
		JPanel creCapteur = new JPanel();
		creCapteur.setBorder(BorderFactory.createTitledBorder("Création du capteur"));
		//creCapteur.setLayout(new WrapLayout());
		creCapteur.setPreferredSize(new Dimension(350, 320));
		creCapteur.add(panNom);
		creCapteur.add(panLoc);
		creCapteur.add(panType);
		creCapteur.add(panGazType);
		panGazType.setVisible(false);
		creCapteur.add(submitButton);

		//panneau génération alarme
		JPanel genAlarme = new JPanel();
		genAlarme.setBorder(BorderFactory.createTitledBorder("Génération de l'Alarme"));
		//genAlarme.setLayout(new WrapLayout());
		genAlarme.setPreferredSize(new Dimension(350, 260));
		genAlarme.add(panListeCap);
		genAlarme.add(panLevel);
		genAlarme.add(panRad);
		panRad.setVisible(false);
		genAlarme.add(generateAlarmeButton);

		//Ajout dans un Jpanel global
		JPanel content = new JPanel();
		content.add(creCapteur);
		content.add(genAlarme);

		//Ajout au contentPane
		contentPane.add(content);
		//contentPane.add(creCapteur, BorderLayout.NORTH);
		//contentPane.add(genAlarme, BorderLayout.SOUTH);


		//Classe interne implémentant l'interface ItemListener
		@SuppressWarnings("unused")
		class ItemState implements ItemListener{
			public void itemStateChanged(ItemEvent e) {
				System.out.println("événement déclenché sur : " + e.getItem());
			}               
		}
		@SuppressWarnings("unused")
		class ItemAction1 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionListener : action sur " + listeTypeCapteur.getSelectedItem());
			}
		}
	}

	//méthode permettant d'ajouter un capteur à la liste
	public void ajoutCapteur(Capteur cap){
		this.listeCapteur.add(cap);
		listeCap.addItem(cap.getNom());				
	}
	
	//méthode permettant d'ajouter un moniteur à la liste des moniteurs
	public void ajoutMoniteur(Moniteur mon){
		this.listeMoniteur.add(mon);		
	}

	//getter de la liste des capteurs
	public ArrayList<Capteur> getListeCapteur() {
		return listeCapteur;
	}
	
}


