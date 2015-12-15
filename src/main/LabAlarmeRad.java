package main;

import java.util.Calendar;

public class LabAlarmeRad extends LabAlarme {

	private static final long serialVersionUID = 2216683135652513711L;
	private int radlevel;

	public LabAlarmeRad(Object source, Calendar date, String localisation,
			int niveau_alarme, String type, int radlevel) {
		super(source, date, localisation, niveau_alarme, type);
		this.radlevel = radlevel;
	}
	
	public String toString(){
		return("Une alarme de type " + this.getType() + " de niveau "+ this.getNiveau_alarme() + " d'un niveau de radiation de "+ this.getRadlevel() + " a été détecté dans " + this.getLocalisation() + " le : " + this.dateToString());
	}

	public int getRadlevel() {
		return radlevel;
	}

	public void setRadLvl(int radlevel) {
		this.radlevel = radlevel;
	}

	@Override
	public String texteInfo() {
		String texteInfo = "Salle : " + this.getLocalisation()+ "\n"
				+"Niveau : " + this.getNiveau_alarme()+ "\n"
				+"Type : " + this.getType() + "\n"
				+"Niveau de radiation : "+ this.radlevel+ "\n"
				+"Date : " + this.dateToString();
		return texteInfo;
	}

}
