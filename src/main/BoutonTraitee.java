package main;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BoutonTraitee extends JButton {

	public int getIndexListeAlarme() {
		return indexListeAlarme;
	}

	public void setIndexListeAlarme(int indexListeAlarme) {
		this.indexListeAlarme = indexListeAlarme;
	}

	private int indexListeAlarme;
	
	public BoutonTraitee() {
		// TODO Auto-generated constructor stub
	}

	public BoutonTraitee(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public BoutonTraitee(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public BoutonTraitee(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public BoutonTraitee(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}
	
	public BoutonTraitee(String arg0, int arg1) {
		super(arg0);
		this.indexListeAlarme = arg1;
	}

}
