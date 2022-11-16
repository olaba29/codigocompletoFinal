package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EntrenatzaileaGukTest {
	EntrenatzaileaGuk e1;
	Pokemon p1;
	Mugimendu m1,m2,m3,m4;
	@Before
	public void setUp() throws Exception {
		e1 = new EntrenatzaileaGuk("Iker",20);
		p1 = new Pokemon("Venusaur",1,270,152,148,153,0);
		m1 = new ErasoMugimendua(2,"Ur Pistola ",1,15,40);
		m2 = new ErasoMugimendua(2,"Surf",2,15,90);
		m3 = new ErasoMugimendua(2,"Burbuila Izpia",3,15,65);
		m4 = new ErasoMugimendua(1,"Energibola",10,15,75);
	}

	@After
	public void tearDown() throws Exception {
		e1 = null;
		p1 = null;
		m1 = null;
		m2 = null;
		m3 = null;
		m4 = null;
	}

	@Test
	public void testErabiliMugimendu() {
		p1.getNireLista().addMugimendu(m1);
		p1.getNireLista().addMugimendu(m2);
		p1.getNireLista().addMugimendu(m3);
		p1.getNireLista().addMugimendu(m4);
		//teklatutik 4 zenbakia sartuz
		assertEquals(e1.erabiliMugimendu(p1),m4);
		//teklatutik 2 zenbakia sartuz
		assertNotEquals(e1.erabiliMugimendu(p1),m4);
	}

	@Test
	public void testEntrenatzaileaGuk() {
		assertNotNull(e1);
		assertNotNull(p1);
		assertNotNull(m1);
		assertNotNull(m2);
		assertNotNull(m3);
		assertNotNull(m4);
	}

}
