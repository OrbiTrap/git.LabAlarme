package main;

public class MoniteurA extends Moniteur{

	private static final long serialVersionUID = 6299979885301742199L;

	public MoniteurA(String nom) {
		super(nom);
		this.type = "A";
		this.types.add("feu");
		this.types.add("gaz");
	}
}
