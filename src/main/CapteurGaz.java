package main;

import java.util.Calendar;

public class CapteurGaz extends Capteur {

	private String gaz;
	
	public CapteurGaz(String nom, String localisation, String gaz) {
		super(nom, localisation);
		this.gaz = gaz;
	}

	public void generateEvent(){
		Calendar date = Calendar.getInstance();
		int random = (int)(Math.random() * (3+1-1)) + 1;
		
		LabAlarmeGaz a = new LabAlarmeGaz(this, date, this.getLocalisation(), random, "gaz", this.gaz);
		
		for(EcouteurAlarme l:ecouteurs){
			l.afficheAlarme(a);
		}
	}
	
	public void generateEvent(int niveau){
		Calendar date = Calendar.getInstance();
		LabAlarmeGaz a = new LabAlarmeGaz(this, date, this.getLocalisation(), niveau, "gaz", this.gaz);
		for(EcouteurAlarme l:ecouteurs){
			l.afficheAlarme(a);
		}
	}
		@Override
	public void generateEvent(int a, int b) {
		// TODO Auto-generated method stub
		
	}
//getters and setters	
	public String getGaz() {
		return gaz;
	}

	public void setGaz(String gaz) {
		this.gaz = gaz;
	}


	
	

}
