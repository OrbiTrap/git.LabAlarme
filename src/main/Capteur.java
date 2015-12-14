package main;

import java.util.ArrayList;

public abstract class Capteur {

	private String nom;
	private String localisation;
	protected ArrayList<EcouteurAlarme> ecouteurs = new ArrayList<EcouteurAlarme>();

	public abstract void generateEvent();
	public abstract void generateEvent(int a);
	public abstract void generateEvent(int a, int b);

	public Capteur(String nom, String localisation) {
		super();
		this.nom = nom;
		this.localisation = localisation;
	}

	// getters setters----------------------------------------
	public ArrayList<EcouteurAlarme> getListeEcouteurs() {
		return this.ecouteurs;
	}

	public void ajouterEcouteur(EcouteurAlarme ecouteur) {
		this.ecouteurs.add(ecouteur);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

}
