package eu.ensup.proxibanque.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import eu.ensup.proxibanque.domaine.Compte;
import eu.ensup.proxibanque.domaine.Personne;

public class ConseillerDao extends AccesBd {

	ResultSet rs = null;

	public boolean creationClient(Personne personne) {
		// TODO Auto-generated method stub
		seConnecter();
		try {
			String sql = "INSERT INTO personne(`id`,`nom`,`prenom`,`adresse`, "
					+ "`codePostal`, `ville`, `telephone`) values"
					+ "('"+ personne.getId() +"','"+ personne.getNom() +"','"+ personne.getPrenom() +"',"
					+ "'"+ personne.getAdresse() +"','"+ personne.getCodePostal() +"',"
					+ "'"+ personne.getVille() +"','"+ personne.getTelephone() +"');";	

			st.executeQuery(sql);

		} catch (Exception e) {
			return false;
		}
		seDeconnecter();
		return true;

	}

	public Personne afficherInfoClient(String id) {
		// TODO Auto-generated method stub
		Personne personne = new Personne();

		seConnecter();
		try {
			ResultSet result = this.seConnecter().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE id = " + id);
			if(result.first())
				personne = new Personne(
						id,
						result.getString("nom"),
						result.getString("prenom"),
						result.getString("adresse"),
						result.getInt("codePostal"),
						result.getString("ville"),
						result.getInt("telephone")
						);         
		} catch (SQLException e) {
			e.printStackTrace();
		}
		seDeconnecter();
		return personne;
	}

	public boolean modificationClient(Personne personne) {

		seConnecter();
		try {

			String sql = " UPDATE `personne` SET nom = '" + personne.getNom() + "' , prenom = '" + personne.getPrenom()
					+ "' , adresse = '" + personne.getAdresse() + "' , CodePostal = '" + personne.getCodePostal()
					+ "' , ville = '" + personne.getVille() + "' , telephone = '" + personne.getTelephone()
					+ "' WHERE id = '" + personne.getId() + "'";
			System.out.println("Ligne update");

			// Etape 4 : exécution requête
			st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		seDeconnecter();
		return true;
	}

	public boolean suppressionClient(String id) {
		seConnecter();
		try {

			String sql = "DELETE from personne WHERE id ='" + id + "'";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		seDeconnecter();
		return true;
	}

	public ArrayList<Personne> listeDesClients() {

		String id;
		String nom;
		String prenom;
		String adresse;
		int codePostal;
		String ville;
		int telephone;
		ArrayList<Personne> listePersonne = new ArrayList<Personne>();

		seConnecter();
		try {

			String sql = "SELECT * from personne, client WHERE personne.id = client.idPersonne";

			rs = st.executeQuery(sql);

			while (rs.next()) {

				id = rs.getString("id");
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				adresse = rs.getString("adresse");
				codePostal = rs.getInt("codePostal");
				ville = rs.getString("ville");
				telephone = rs.getInt("telephone");

				Personne personne = new Personne(id, nom, prenom, adresse, codePostal, ville, telephone);
				listePersonne.add(personne);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

		seDeconnecter();
		return listePersonne;
	}
	}
	
	public ArrayList<Compte> listeDesComptes(String id) {
		String numCompte;
		Float solde;
		Date dateOuverture;
		boolean type;
		
		ArrayList<Compte> listeCompte = new ArrayList<Compte>();

		seConnecter();
		try {

			String sql = "SELECT numCompte, solde, dateOuverture, type from compte, client WHERE compte.idClient = client.idPersonne ORDER BY compte.numCompte";

			rs = st.executeQuery(sql);

			while (rs.next()) {

				numCompte = rs.getString("numCompte");
				System.out.println(numCompte);
				solde = rs.getFloat("solde");
				System.out.println(solde);
				java.sql.Date dbSqlDate = rs.getDate("dateOuverture");
				System.out.println(dbSqlDate);
				type = rs.getBoolean("type");
				System.out.println(type);

				Compte compte = new Compte(numCompte, solde, dbSqlDate, type);
				System.out.println(compte);
				listeCompte.add(compte);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

		seDeconnecter();
		return listeCompte;
	}
	
}