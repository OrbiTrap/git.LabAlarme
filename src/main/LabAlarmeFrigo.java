package main;

import java.util.Calendar;

public class LabAlarmeFrigo extends LabAlarme {

	private static final long serialVersionUID = 1537561820218519804L;

	public LabAlarmeFrigo(Object source, Calendar date, String localisation,
			int niveau_alarme, String type) {
		super(source, date, localisation, niveau_alarme, "frigo");
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return("Une alarme de type " + this.getType() +" de niveau "+ this.getNiveau_alarme() + " a été détecté dans " + this.getLocalisation() + " le : " + this.dateToString());
	}

	@Override
	public String texteInfo() {
		String texteInfo = "Salle : " + this.getLocalisation()+ "\n"
				+"Niveau : " + this.getNiveau_alarme()+ "\n"
				+"Type : " + this.getType() + "\n"
				+"Date : " + this.dateToString();
		return texteInfo;
	}

}
