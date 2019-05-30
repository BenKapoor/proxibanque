package eu.ensup.proxibanque.service;

import java.util.ArrayList;

import eu.ensup.proxibanque.dao.GerantDao;
import eu.ensup.proxibanque.domaine.Personne;

public class GerantService {

	GerantDao gerantDao = new GerantDao();
	
	//Renvoie la liste des conseillers
	public ArrayList<Personne> listeDesConseillers() {
		
		ArrayList<Personne> listePersonnes = new ArrayList<Personne>();
		listePersonnes = gerantDao.listeDesConseillers();
		return listePersonnes;
	}
}
