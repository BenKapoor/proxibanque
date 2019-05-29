package eu.ensup.proxibanque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eu.ensup.proxibanque.domaine.Personne;


public class ConseillerDao extends AccesBd {

	ResultSet rs = null;

	// SALAM LES RAYES
	public boolean creationClient(Personne personne) {
		// TODO Auto-generated method stub
		return true;
	}

	public Personne afficherInfoClient(String id) {
		// TODO Auto-generated method stub
		Personne personne = new Personne();
		return personne;
	}

	public boolean modificationClient(Personne personne) {
		
		seConnecter();
		try {

			String sql = " UPDATE `personne` SET nom = '" + personne.getNom() + "' , prenom = '" + personne.getPrenom()
					+ "' , adresse = '" + personne.getAdresse() + "' , CodePostal = '" 
					+ personne.getCodePostal() + "' , ville = '" + personne.getVille() 
					+ "' , telephone = '" + personne.getTelephone() 
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

		seConnecter();
		try {

			String sql = "SELECT * from personne";

			rs = st.executeQuery(sql);

			while (rs.next()) {

				int id1 = rs.getInt("id");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");

				System.out.println(
						"Nous avons lid: " + id1 + " qui est lenom de: " + name + " avec un prenom de " + prenom);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		seDeconnecter();
		return null;
	}

}
