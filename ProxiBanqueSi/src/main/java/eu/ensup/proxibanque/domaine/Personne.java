package eu.ensup.proxibanque.domaine;

public class Personne {

	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String ville;
	private int telephone;
	
	public Personne() {
		super();
	}

	public Personne(String id, String nom, String prenom, String adresse, int codePostal, String ville, int telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", ville=" + ville + ", telephone=" + telephone + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
}
