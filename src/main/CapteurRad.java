package main;

import java.util.Calendar;

public class CapteurRad extends Capteur {

	//private int radlevel;
	
	public CapteurRad(String nom, String localisation) {
		super(nom, localisation);
		//int radlevel = (int)(Math.random() * (100+1-1)) + 1;
		//this.radlevel = radlevel;
	}

	public void generateEvent(){
		Calendar date = Calendar.getInstance();
		int random = (int)(Math.random() * (3+1-1)) + 1;
		int randomRad = (int)(Math.random() * (100+1-1)) + 1;
		
		LabAlarmeRad a = new LabAlarmeRad(this, date, this.getLocalisation(), random, "rad", randomRad);
		
		for(EcouteurAlarme l:ecouteurs){
			l.afficheAlarme(a);
		}
	}
	
	public void generateEvent(int niveau, int niveauRad){
		Calendar date = Calendar.getInstance();
		LabAlarmeRad a = new LabAlarmeRad(this, date, this.getLocalisation(), niveau, "rad", niveauRad);
		for(EcouteurAlarme l:ecouteurs){
			l.afficheAlarme(a);
		}
	}
	
	@Override
	public void generateEvent(int a) {
		// TODO Auto-generated method stub
		
	}
	
//getters and setters
/*
	public int getRadlevel() {
		return radlevel;
	}

	public void setRadlevel(int radlevel) {
		this.radlevel = radlevel;
	}
*/
}
