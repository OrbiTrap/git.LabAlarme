package main;

import java.util.EventListener;

public interface EcouteurAlarme extends EventListener {
	public void afficheAlarme(LabAlarme event);
}
