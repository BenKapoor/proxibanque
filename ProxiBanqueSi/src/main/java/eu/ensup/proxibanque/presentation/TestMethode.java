package eu.ensup.proxibanque.presentation;

import java.util.ArrayList;

import eu.ensup.proxibanque.domaine.Compte;
import eu.ensup.proxibanque.domaine.Personne;
import eu.ensup.proxibanque.service.ConseillerService;
import eu.ensup.proxibanque.service.GerantService;

public class TestMethode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personne personne = new Personne("1", "pierre", "michel", "habite pas", 0, "aamama", 0);

		ConseillerService cs = new ConseillerService();
		String id = "1";
		
		GerantService gs = new GerantService();
		
		// Les deux méthodes fonctionnent
		// cs.suppressionClient(id);
		// cs.modificationClient(personne);

		// Retourne une liste de Client
		// ArrayList<Personne> listePersonne = new ArrayList<Personne>();
		// listePersonne = cs.listeDesClients();

		// Retourne une liste de Conseiller
		 //ArrayList<Personne> listePersonne = new ArrayList<Personne>();
		 //listePersonne = gs.listeDesConseillers();
		 //System.out.println(listePersonne);
		
		// Retourne une liste de compte d'un client
		//ArrayList<Compte> listeCompte = new ArrayList<Compte>();
		//listeCompte = cs.listeDesComptes("1");
		//System.out.println(listeCompte);
	}

}
