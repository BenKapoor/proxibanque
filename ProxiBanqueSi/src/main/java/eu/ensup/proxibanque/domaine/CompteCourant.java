package eu.ensup.proxibanque.domaine;

public class CompteCourant extends Compte {

	private float decouvert;

	public CompteCourant(float decouvert) {
		super();
		this.decouvert = decouvert;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + "]";
	}

	public float getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}
	
	
}
