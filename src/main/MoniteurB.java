package main;

@SuppressWarnings("serial")
public class MoniteurB extends Moniteur{

	public MoniteurB(String nom) {
		super(nom);
		this.type = "B";
		this.types.add("rad");
		this.types.add("frigo");
	}
}
