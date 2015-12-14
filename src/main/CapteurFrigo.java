package main;

import java.util.Calendar;

public class CapteurFrigo extends Capteur {
	
	public CapteurFrigo(String nom, String localisation) {
		super(nom, localisation);
		// TODO Auto-generated constructor stub
	}

	public void generateEvent(){
		Calendar date = Calendar.getInstance();
		int random = (int)(Math.random() * (3+1-1)) + 1;
		LabAlarmeFrigo a = new LabAlarmeFrigo(this, date, this.getLocalisation(), random, "arrêt du groupe réfrigérant");
		for(EcouteurAlarme l:ecouteurs){
			l.afficheAlarme(a);
		}
	}
	
	public void generateEvent(int niveau){
		Calendar date = Calendar.getInstance();
		LabAlarmeFrigo a = new LabAlarmeFrigo(this, date, this.getLocalisation(), niveau, "arrêt du groupe réfrigérant");
		for(EcouteurAlarme l:ecouteurs){
			l.afficheAlarme(a);
		}
	}

	@Override
	public void generateEvent(int a, int b) {
		// TODO Auto-generated method stub
		
	}
	
}
