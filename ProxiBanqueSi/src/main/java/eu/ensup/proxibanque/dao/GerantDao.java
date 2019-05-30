package eu.ensup.proxibanque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eu.ensup.proxibanque.domaine.Personne;

public class GerantDao extends AccesBd {

	ResultSet rs = null;
	
	public ArrayList<Personne> listeDesConseillers() {

		String id;
		String nom;
		String prenom;
		String adresse;
		int codePostal;
		String ville;
		int telephone;
		ArrayList<Personne> listeConseiller = new ArrayList<Personne>();

		seConnecter();
		try {

			String sql = "SELECT * from personne WHERE not exists (select * from client WHERE personne.id = client.idPersonne)";

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
				listeConseiller.add(personne);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

		seDeconnecter();
		return listeConseiller;
}
	
}
