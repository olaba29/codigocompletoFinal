package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MugimenduTest {
	Mugimendu m1,m2,m3;
	@Before
	public void setUp() throws Exception {
		m1 = new ErasoMugimendua(2,"Ur Pistola ",1,15,40);
		m2 = new ErasoMugimendua(2,"Surf",2,15,90);
		m3 = new ErasoMugimendua(2,"Burbuila Izpia",3,15,65);
	}

	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
		m3 = null;
	}
	
	@Test
	public void testMugimendu() {
		assertNotNull(m1);
		assertNotNull(m2);
		assertNotNull(m3);
	}

	@Test
	public void testIdBerdinaDu() {
		//id berdina du
		assertTrue(m1.idBerdinaDu(1));
		//ez du id berdinik
		assertFalse(m2.idBerdinaDu(5));
	}

}
