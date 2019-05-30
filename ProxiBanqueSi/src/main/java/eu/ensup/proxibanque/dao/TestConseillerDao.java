package eu.ensup.proxibanque.dao;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eu.ensup.proxibanque.domaine.Personne;
import eu.ensup.proxibanque.service.ConseillerService;

public class TestConseillerDao {

	@Mock
	private ConseillerDao conseillerDaoMock;
	
	@InjectMocks
	private ConseillerService conseillerServiceMock;
	
	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void TestCreationClient()
	{
		//ConseillerDao dao = new ConseillerDao();
		
		Personne personne = new Personne("AAZZZZ", "Aziz", "Aziz", "19 rue d'Aziz", 45555, "Aziz-sur-mer", 0102030405);
		when(conseillerDaoMock.creationClient(personne)).thenReturn(true);
		
		assertEquals(true, conseillerServiceMock.creationClient(personne));
		
		// pour tester après création dao
		//when(dao.creationClient(personne)).thenReturn(true);
		//assertEquals(true, dao.creationClient(personne));
	}
	
	@Test
	public void TestAfficherInfoClient()
	{
		String id = "AAZZZZ";
		Personne personne = new Personne("AAZZZZ", "Aziz", "Aziz", "19 rue d'Aziz", 45555, "Aziz-sur-mer", 0102030405);
		when(conseillerDaoMock.afficherInfoClient(id)).thenReturn(personne);
		
		assertEquals(id, conseillerServiceMock.afficherInfoClient(id).getId());
		
		// pour tester après création dao
		//when(dao.afficherInfoClient(id)).thenReturn(personne);
		//assertEquals(id, dao.afficherInfoClient(id).getId());
	}
	
	@Test
	public void TestModificationClient()
	{
		String id = "AAZZZZ";
		Personne personne = new Personne("AAZZZZ", "Aziz", "Aziz", "19 rue d'Aziz", 45555, "Aziz-sur-mer", 0102030405);
		when(conseillerDaoMock.modificationClient(personne)).thenReturn(true);
		
		assertEquals(true, conseillerServiceMock.modificationClient(personne));
		
		// pour tester après création dao
		//when(dao.modificationClient(personne)).thenReturn(true);
		//assertEquals(true, dao.modificationClient(personne));
	}
	
	@Test
	public void TestSuppressionClient()
	{
		String id = "AAZZZZ";
		Personne personne = new Personne("AAZZZZ", "Aziz", "Aziz", "19 rue d'Aziz", 45555, "Aziz-sur-mer", 0102030405);
		when(conseillerDaoMock.suppressionClient(id)).thenReturn(true);
		
		assertEquals(true, conseillerServiceMock.suppressionClient(id));	
	}
	@Test
	public void TestListeDesClients()
	{
		ArrayList<Personne> listePersonne = new ArrayList<Personne>();
		Personne personne = new Personne("AAZZZZ", "Aziz", "Aziz", "19 rue d'Aziz", 45555, "Aziz-sur-mer", 0102030405);
		Personne personne2 = new Personne("AAZZZZ", "Abdou", "Abdou", "19 rue d'Aziz", 45555, "Abdou-sur-mer", 0102030405);
		listePersonne.add(personne);
		listePersonne.add(personne2);
		
		when(conseillerDaoMock.listeDesClients()).thenReturn(listePersonne);
		
		assertEquals(2, conseillerServiceMock.listeDesClients().size());
	}
}
