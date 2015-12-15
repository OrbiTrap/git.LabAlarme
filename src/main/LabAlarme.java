package main;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.EventObject;

public abstract class LabAlarme extends EventObject{

	private static final long serialVersionUID = -765089326074937701L;
	private Calendar date = Calendar.getInstance();
	private String localisation;
	private int niveau_alarme;
	private String type;
	
public abstract String texteInfo();
	
public LabAlarme(Object source, Calendar date, String localisation, int niveau_alarme, String type) {
		super(source);
		this.date = date;
		this.localisation = localisation;
		this.niveau_alarme = niveau_alarme;
		this.type = type;
	}
//gestion de la date----------------------------------------------------------------

public String dateToString(){
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	String dateFormatted = format.format(this.date.getTime());
	return dateFormatted;
}

//getter-setter--------------------------------------------------------------------
	
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public int getNiveau_alarme() {
		return niveau_alarme;
	}
	public void setNiveau_alarme(int niveau_alarme) {
		this.niveau_alarme = niveau_alarme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
