package main;

import java.util.Calendar;

public class LabAlarmeGaz extends LabAlarme {

	private static final long serialVersionUID = -4824861701812858434L;
	private String typeGaz;
	
	public LabAlarmeGaz(Object source, Calendar date, String localisation,
			int niveau_alarme, String type, String typeGaz) {
		super(source, date, localisation, niveau_alarme, "gaz");
		this.typeGaz = typeGaz;
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return("Une alarme de type " + this.getType() + " : " + this.getTypeGaz() + " de niveau "+ this.getNiveau_alarme() + " a été détecté dans " + this.getLocalisation() + " le : " + this.dateToString());
	}

	public String getTypeGaz() {
		return typeGaz;
	}

	public void setTypeGaz(String typeGaz) {
		this.typeGaz = typeGaz;
	}

	@Override
	public String texteInfo() {
		String texteInfo = "Salle : " + this.getLocalisation()+ "\n"
				+"Niveau : " + this.getNiveau_alarme()+ "\n"
				+"Type : " + this.getType() + "\n"
				+"Gaz : " + this.getTypeGaz() + "\n"
				+"Date : " + this.dateToString();
		return texteInfo;
	}
}
