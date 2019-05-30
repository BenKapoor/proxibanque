package eu.ensup.proxibanque.domaine;

import java.sql.Date;

public class Compte {

	private String numCompte;
	private Float solde;
	private Date dateOuverture;
	private boolean type;
	
	public Compte() {
		super();
	}
	
	

	public Compte(String numCompte, Float solde, Date dateOuverture, boolean type) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.type = type;
	}



	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture + ", type="
				+ type + "]";
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
	
}
