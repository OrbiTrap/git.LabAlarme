package main;

@SuppressWarnings("serial")
public class MoniteurA extends Moniteur{

	public MoniteurA(String nom) {
		super(nom);
		this.type = "A";
		this.types.add("feu");
		this.types.add("gaz");
	}
}
