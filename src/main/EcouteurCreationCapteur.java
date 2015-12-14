package main;

import java.util.ArrayList;
import java.util.EventListener;

public interface EcouteurCreationCapteur extends EventListener {
	public void ecouterCapteur(ArrayList<Capteur> arg0);
	public void ecouterCapteur(Capteur arg0);
}
