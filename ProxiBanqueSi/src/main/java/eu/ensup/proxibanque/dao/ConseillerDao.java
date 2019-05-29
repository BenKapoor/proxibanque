package eu.ensup.proxibanque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

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
		}

		seDeconnecter();
		return listePersonne;
}
}