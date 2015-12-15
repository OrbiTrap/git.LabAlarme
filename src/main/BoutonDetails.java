package main;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class BoutonDetails extends JButton {

	private static final long serialVersionUID = -8709676661631429691L;
	private int indexListeAlarme;
	
	public BoutonDetails() {
		// TODO Auto-generated constructor stub
	}

	public BoutonDetails(Icon arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BoutonDetails(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BoutonDetails(Action arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BoutonDetails(String arg0, Icon arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public BoutonDetails(String arg0, int arg1) {
		super(arg0);
		this.indexListeAlarme = arg1;
	}

	/**
	 * @return the indexListeAlarme
	 */
	public int getIndexListeAlarme() {
		return indexListeAlarme;
	}

	/**
	 * @param indexListeAlarme the indexListeAlarme to set
	 */
	public void setIndexListeAlarme(int indexListeAlarme) {
		this.indexListeAlarme = indexListeAlarme;
	}
	

}
