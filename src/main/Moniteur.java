package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import javafx.scene.control.ScrollPane;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Moniteur extends JFrame implements EcouteurAlarme,EcouteurCreationCapteur {

	private static final long serialVersionUID = 4730710537549902418L;
	protected String type;
	protected String nom;
	protected ArrayList<String> types = new ArrayList<String>();
	private ArrayList<LabAlarme> listeAlarmes = new ArrayList<LabAlarme>();
	private ArrayList<JPanelAlarme> listePanelAlarme = new ArrayList<JPanelAlarme>();
	private ArrayList<BoutonTraitee> listeBouton = new ArrayList<BoutonTraitee>();
	private JTextArea zoneTexte = new JTextArea(150,75);
	private JPanel mainPanel = new JPanel();

	JPanel panel = new JPanel();
	JScrollPane scrollPane = new JScrollPane(panel);
	
	
	public Moniteur(String nom) {
		super();
		this.nom = nom;
		this.setTitle("Moniteur d'alarme : " + this.nom);
		this.setSize(1000,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		initComponent();
		setVisible(true);
		//pack();
	}
	//Corps de la fonction issue de écouteuralarme----------------------------

	public void afficheAlarme(LabAlarme event) {
		boolean typeExiste = false;
		for (int j = 0 ; j< types.size(); j++){
			if (event.getType().equals(types.get(j))){
				typeExiste = true;
			}
		}
		System.out.println(event.getType());
		System.out.println(this.types);

		if(typeExiste){
			//Affichage dans la console et la zone de texte
			System.out.println(event.toString());
			zoneTexte.append("\r\n" + event.toString());
			//ajout à la liste des évènements
			listeAlarmes.add(event);

			//JLabel de l'alarme
			JLabel nomEvent = new JLabel (event.getClass().getName().substring(14) + " en " + event.getLocalisation());

			//creation d'un nouveau JPanel contenant l'alarme
			int index = listeAlarmes.size();
			JPanelAlarme a = new JPanelAlarme(index-1);
			a.add(nomEvent);
			JButton bd =new JButton("Détails");
			BoutonTraitee bt =new BoutonTraitee("Traitée",index);
			listeBouton.add(bt);
			bt.setEnabled(false);
			a.add(bd);
			a.add(bt);
			panel.add(a);
			scrollPane.setViewportView(panel);

			String texteInfo = event.texteInfo();

			//Classe d'écouteurs de bouton details
			class EcouteurBoutonDetails implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, texteInfo, "Détails", JOptionPane.INFORMATION_MESSAGE);
					bt.setEnabled(true);
				}
			}

			//Classe d'écouteurs de bouton traitee
			class EcouteurBoutonTraitee implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					zoneTexte.append("\r\n Alerte traitée" );
					listeAlarmes.remove(bt.getIndexListeAlarme()-1);
					panel.remove(panel.getComponent(bt.getIndexListeAlarme()-1));
					scrollPane.setViewportView(panel);
					JOptionPane.showMessageDialog(null, "L'alarme a été traitée", "Traitement", JOptionPane.INFORMATION_MESSAGE);

					for(int i = bt.getIndexListeAlarme(); i < listeBouton.size(); i++){
						listeBouton.get(i).setIndexListeAlarme(listeBouton.get(i).getIndexListeAlarme()-1);
					}
				}
			}
			bt.addActionListener(new EcouteurBoutonTraitee());
			bd.addActionListener(new EcouteurBoutonDetails());
			listePanelAlarme.add(a);
			
			//génération d'une boîte de dialogue
			JOptionPane.showMessageDialog(null, "Un danger a été détécté !", "Alerte !", JOptionPane.WARNING_MESSAGE);

		}
	}

	//fonction de récupération de la liste des capteurs existants et de mise en écoute
	public void ecouterCapteurs(ArrayList<Capteur> arg0){
		for ( int i = 0; i < arg0.size(); i++){
			arg0.get(i).ajouterEcouteur(this);
		}
	}

	//Fonction permettant d'initialiser les composants------------------------
	public void initComponent(){
		Container contentPane = getContentPane();

		//JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 600));
		//JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		scrollPane.setBorder(BorderFactory.createTitledBorder("Liste des alarmes non traitées"));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 30, 300, 50);
		scrollPane.setViewportView(panel);

		//Scrollpane de la console
		JScrollPane scrolltext = new JScrollPane(zoneTexte);
		DefaultCaret caret = (DefaultCaret)zoneTexte.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrolltext.setPreferredSize(new Dimension(750, 110));
		scrolltext.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrolltext.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrolltext.setBounds(50, 30, 300, 50);
		scrolltext.setPreferredSize(new Dimension(670, 290));

		//Panel contenant le ScrollPane de la console
		JPanel texte = new JPanel();
		texte.setBorder(BorderFactory.createTitledBorder("Console"));
		texte.add(scrolltext);
		zoneTexte.setPreferredSize(new Dimension(650, 200));

		//Panel principal contenant tout
		//JPanel mainPanel = new JPanel();
		mainPanel.add(scrollPane);
		mainPanel.add(scrolltext);
		contentPane.add(mainPanel);
	}

	//getters-setters---------------------------------------------------------	

	public ArrayList<String> getListeTypes() {
		return this.types;
	}

	public void ajouterType(String type) {
		this.types.add(type);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public void ecouterCapteur(ArrayList<Capteur> arg0) {
		for ( int i = 0; i < arg0.size(); i++){
			arg0.get(i).ajouterEcouteur(this);
		}
	}
	@Override
	public void ecouterCapteur(Capteur arg0) {
		arg0.ajouterEcouteur(this);	
	}

}
