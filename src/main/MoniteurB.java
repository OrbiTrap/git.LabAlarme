package main;

public class MoniteurB extends Moniteur{

	private static final long serialVersionUID = 7415354017367758688L;

	public MoniteurB(String nom) {
		super(nom);
		this.type = "B";
		this.types.add("rad");
		this.types.add("frigo");
	}
}
