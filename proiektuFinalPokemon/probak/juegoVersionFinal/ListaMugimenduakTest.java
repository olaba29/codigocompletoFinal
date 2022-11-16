package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaMugimenduakTest {
	Mugimendu m1,m2,m3,m4,m5,m6;
	ListaMugimenduak l1;
	Pokemon p1,p2,p3;
	@Before
	public void setUp() throws Exception {
		m1 = new ErasoMugimendua(2,"Ur Pistola ",1,15,40);
		m2 = new ErasoMugimendua(2,"Surf",2,15,90);
		m3 = new ErasoMugimendua(2,"Burbuila Izpia",3,15,65);
		m4 = new ErasoMugimendua(1,"Energibola",10,15,75);
		m5 = new ErasoMugimendua(1,"Hosto Magikoa",11,15,60);
		m6 = new ErasoMugimendua(1,"Tormenta Florala",13,15,80);
		l1 = new ListaMugimenduak();
		p1 = new Pokemon("Venusaur",1,270,152,148,153,0);
		p2 = new Pokemon("Tangela",2,240,103,112,211,0); 
		p3 = new Pokemon("Exeggutor",3,300,175,103,157,0);
	}

	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
		m3 = null;
		m4 = null;
		m5 = null;
		m6 = null;
		l1.erreseteatu();
	}

	@Test
	public void testListaMugimenduak() {
		assertNotNull(m1);
		assertNotNull(m2);
		assertNotNull(m3);
		assertNotNull(m4);
		assertNotNull(m5);
		assertNotNull(m6);
		assertNotNull(l1);
	}

	@Test
	public void testListarenLuzera() {
		//lista ez du mugimendurik
		assertEquals(l1.listarenLuzera(),0);
		l1.addMugimendu(m1);
		l1.addMugimendu(m2);
		l1.addMugimendu(m3);
		l1.addMugimendu(m4);
		l1.addMugimendu(m5);
		l1.addMugimendu(m6);
		//lista 6 mugimendu ditu
		assertEquals(l1.listarenLuzera(),6);
	}

	@Test
	public void testAddMugimendu() {
		//lista ez du mugimendurik
		assertEquals(l1.listarenLuzera(),0);
		l1.addMugimendu(m1);
		//lista 1 mugimendu ditu
		assertEquals(l1.listarenLuzera(),1);
	}

	@Test
	public void testRemoveMugimendu() {
		//lista 6 mugimendu ditu
		l1.addMugimendu(m1);
		l1.addMugimendu(m2);
		l1.addMugimendu(m3);
		l1.addMugimendu(m4);
		l1.addMugimendu(m5);
		l1.addMugimendu(m6);
		//mugimendu bi kenduz listatik
		l1.removeMugimendu(m6);
		l1.removeMugimendu(m5);
		assertEquals(l1.listarenLuzera(),4);
	}

	@Test
	public void testBilatuMugimenduIdz() {
		l1.addMugimendu(m1);
		l1.addMugimendu(m2);
		l1.addMugimendu(m3);
		l1.addMugimendu(m4);
		l1.addMugimendu(m5);
		l1.addMugimendu(m6);
		//mugimendu id-a listan dago
		assertEquals(l1.bilatuMugimenduIdz(11),m5);
		//mugimendu id-a ez dago listan
		assertNull(l1.bilatuMugimenduIdz(17));
	}

	@Test
	public void testAldatuMugimendu() {
		//pokemon-ari 4 mugimendu esleituko diogu
		p1.getNireLista().addMugimendu(m1);
		p1.getNireLista().addMugimendu(m2);
		p1.getNireLista().addMugimendu(m3);
		p1.getNireLista().addMugimendu(m4);
		//m3 m5-arekin aldatuko dugu
		p1.getNireLista().aldatuMugimendu(m5, 3);
		assertEquals(p1.getNireLista().getNireLista().get(2),m5);
	}

	@Test
	public void testHartuXPosiziokoMugimendua() {
		//pokemon-ari 4 mugimendu esleituko diogu
		p1.getNireLista().addMugimendu(m1);
		p1.getNireLista().addMugimendu(m2);
		p1.getNireLista().addMugimendu(m3);
		p1.getNireLista().addMugimendu(m4);
		assertEquals(p1.getNireLista().getNireLista().get(2),m3);
	}

	@Test
	public void testMugimenduakInprimatu() {
		  l1.addMugimendu(m1);
		  l1.addMugimendu(m2);
		  l1.addMugimendu(m3);
		  l1.addMugimendu(m4);
		  assertNotNull(l1.getNireLista());
		  System.out.println("===============================================================");
	      System.out.println("Ondorengo mugimenduen informazioa agertu beharko litzateke:\n");
	      System.out.println("Ur Pistola,Surf,Burbuila Izpia,Energibola");
	      System.out.println("Eta zure programak zera dio:\n");
	      //l1.mugimenduakInprimatu();
	}

	@Test
	public void testErreseteatu() {
		l1.addMugimendu(m1);
		l1.addMugimendu(m2);
		l1.addMugimendu(m3);
		l1.addMugimendu(m4);
		assertEquals(l1.listarenLuzera(),4);
		l1.erreseteatu();
		assertEquals(l1.listarenLuzera(),0);
	}

}
