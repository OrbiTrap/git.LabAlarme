package main;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public class JPanelAlarme extends JPanel {

	private static final long serialVersionUID = 2060421530571648374L;
	int index = 0;
	public JPanelAlarme(int i) {
		super();
		this.index = i;
		// TODO Auto-generated constructor stub
	}

	public JPanelAlarme(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public JPanelAlarme(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public JPanelAlarme(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	

}
