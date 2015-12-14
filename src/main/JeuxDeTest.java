package main;

import java.awt.Dimension;
import java.awt.Toolkit;

public class JeuxDeTest {

	public JeuxDeTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//récupération des dimensions du moniteur
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		
		//création de la fenêtre
		FenetreCapteur creaCapteur = new FenetreCapteur();
		creaCapteur.setLocation(2*width/3, height/5);
		
		
		//création des capteurs
		/*CapteurFeu capFeu = new CapteurFeu("Capteur d'incendie", "B214");
		creaCapteur.ajoutCapteur(capFeu);
		CapteurRad capRad = new CapteurRad("Capteur de radiation","B206");
		creaCapteur.ajoutCapteur(capRad);
		CapteurFrigo capFrigo = new CapteurFrigo("Capteur de réfrigération","B208");
		creaCapteur.ajoutCapteur(capFrigo);
		CapteurGaz capGaz = new CapteurGaz("Capteur de gaz","B212","Acétylène");
		creaCapteur.ajoutCapteur(capGaz);
		*/
		
		//gestion du moniteur
		MoniteurA monA = new MoniteurA("Pompiers");
		MoniteurB monB = new MoniteurB("Service environement");
		creaCapteur.ajoutMoniteur(monA);
		creaCapteur.ajoutMoniteur(monB);
		monA.setLocation(width/10, height/5);
		monB.setLocation(width/10, height/5+360);

		//génération des alarmes
		/*capRad.generateEvent();
		capFeu.generateEvent();
		capFrigo.generateEvent();
		capGaz.generateEvent();
		 */
		
		//tests
		//System.out.println(capFeu.getClass().getName().substring(12));
		
	}

}
