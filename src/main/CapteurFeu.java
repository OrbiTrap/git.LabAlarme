package main;

import java.util.Calendar;


public class CapteurFeu extends Capteur {
	
	public CapteurFeu(String nom, String localisation) {
		super(nom, localisation);
		// TODO Auto-generated constructor stub
	}

	public void generateEvent(){
		Calendar date = Calendar.getInstance();
		int random = (int)(Math.random() * (3+1-1)) + 1;
		
		LabAlarmeFeu a = new LabAlarmeFeu(this, date, this.getLocalisation(), random, "feu");
		
		for(EcouteurAlarme l:ecouteurs){
			l.afficheAlarme(a);
		}
	}
	
	public void generateEvent(int niveau){
		Calendar date = Calendar.getInstance();
		LabAlarmeFeu a = new LabAlarmeFeu(this, date, this.getLocalisation(), niveau, "feu");
		for(EcouteurAlarme l:ecouteurs){
			l.afficheAlarme(a);
		}
	}

	@Override
	public void generateEvent(int a, int b) {
		// TODO Auto-generated method stub
		
	}
	
}
