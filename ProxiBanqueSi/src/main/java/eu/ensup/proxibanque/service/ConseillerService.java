package eu.ensup.proxibanque.service;

import java.util.ArrayList;

import eu.ensup.proxibanque.dao.ConseillerDao;
import eu.ensup.proxibanque.domaine.Personne;

public class ConseillerService {

	
	ConseillerDao conseillerDao = new ConseillerDao();
	
	public boolean creationClient(Personne personne) {
		// TODO Auto-generated method stub
		conseillerDao.creationClient(personne);
		
		return true;
	}

	public Personne afficherInfoClient(String id) {
		// TODO Auto-generated method stub
		Personne personne = new Personne();
		personne = conseillerDao.afficherInfoClient(id);

		return personne;
	}

	public boolean modificationClient(Personne personne) {
		// TODO Auto-generated method stub
		conseillerDao.modificationClient(personne);
		return true;
	}

	public boolean suppressionClient(Personne personne) {
		// TODO Auto-generated method stub
		conseillerDao.suppressionClient(personne);
		return true;
	}

	public ArrayList<Personne> listeDesClients() {
		// TODO Auto-generated method stub
		Personne personne = new Personne();
		ArrayList<Personne> listePersonnes = new ArrayList<Personne>();
		listePersonnes = conseillerDao.listeDesClients();
		return listePersonnes;
	}

	
}
