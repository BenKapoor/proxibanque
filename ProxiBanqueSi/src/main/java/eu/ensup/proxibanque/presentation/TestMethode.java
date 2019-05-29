package eu.ensup.proxibanque.presentation;

import eu.ensup.proxibanque.domaine.Personne;
import eu.ensup.proxibanque.service.ConseillerService;

public class TestMethode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personne personne = new Personne("1", "pierre", "michel", "habite pas", 0, "aamama", 0);

		ConseillerService cs = new ConseillerService();
		String id = "1";
		//cs.suppressionClient(id);
		cs.modificationClient(personne);
	}

}
