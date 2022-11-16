package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MugimenduKolekzioaTest {
	Mugimendu m1,m2,m3,m4,m5,m6;
	MugimenduKolekzioa mk1;
	@Before
	public void setUp() throws Exception {
		m1 = new ErasoMugimendua(2,"Ur Pistola ",1,15,40);
		m2 = new ErasoMugimendua(2,"Surf",2,15,90);
		m3 = new ErasoMugimendua(2,"Burbuila Izpia",3,15,65);
		m4 = new ErasoMugimendua(1,"Energibola",10,15,75);
		m5 = new ErasoMugimendua(1,"Hosto Magikoa",11,15,60);
		m6 = new ErasoMugimendua(1,"Tormenta Florala",13,15,80);
		mk1 = MugimenduKolekzioa.getNireMugimenduKolekzioa();
	}

	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
		m3 = null;
		m4 = null;
		m5 = null;
		m6 = null;
		mk1.getNireLista().erreseteatu();
	}

	@Test
	public void testGetNireMugimenduKolekzioa() {
		assertNotNull(m1);
		assertNotNull(m2);
		assertNotNull(m3);
		assertNotNull(m4);
		assertNotNull(m5);
		assertNotNull(m6);
		assertNotNull(mk1);
	}

	@Test
	public void testListarenLuzera() {
		//lista ez du mugimendurik
		assertEquals(mk1.getNireLista().listarenLuzera(),0);
		mk1.getNireLista().addMugimendu(m1);
		mk1.getNireLista().addMugimendu(m2);
		mk1.getNireLista().addMugimendu(m3);
		mk1.getNireLista().addMugimendu(m4);
		mk1.getNireLista().addMugimendu(m5);
		mk1.getNireLista().addMugimendu(m6);
		//lista 6 mugimendu ditu
		assertEquals(mk1.getNireLista().listarenLuzera(),6);
	}

	@Test
	public void testMugimenduakEsleitu() {
		//aurre:sartutako id-a listaren barruan dago
		mk1.getNireLista().addMugimendu(m1);
		mk1.getNireLista().addMugimendu(m2);
		mk1.getNireLista().addMugimendu(m3);
		mk1.getNireLista().addMugimendu(m4);
		mk1.getNireLista().addMugimendu(m5);
		mk1.getNireLista().addMugimendu(m6);
		//mugimendu berdina da
		assertEquals(mk1.MugimenduakEsleitu(2),m2);
		//mugimendua es da berdina
		assertNotEquals(mk1.MugimenduakEsleitu(2),m4);
	}

}
