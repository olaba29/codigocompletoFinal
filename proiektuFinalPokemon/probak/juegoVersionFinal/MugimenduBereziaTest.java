package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MugimenduBereziaTest {

	MugimenduBerezia mb1,mb2,mb3;
	@Before
	public void setUp() throws Exception {
		mb1 = new MugimenduBerezia(4,"Agilitatea (Abiadura igo)",50,15,(float)1.1,"Abiadura",true);
		mb2 = new MugimenduBerezia(4,"Barrera (Defentsa igo)",49,15,(float)0.9,"Defentsa",false);
		mb3 = new MugimenduBerezia(5,"Masa Kosmikoa (Defentsa igo)",48,15,(float)1.08,"Defentsa",true);
	}

	@After
	public void tearDown() throws Exception {
		mb1 = null;
		mb2 = null;
		mb3 = null;
	}

	@Test
	public void testMugimenduBerezia() {
		assertNotNull(mb1);
		assertNotNull(mb2);
		assertNotNull(mb3);
	}

	@Test
	public void testGetBooster() {
		//booster berdina da
		assertEquals(mb1.getBooster(),(float) 1.1,0);
		//booster ez da berdina
		assertNotEquals(mb3.getBooster(),(float) 1.1,0);
	}

	@Test
	public void testGetEstadistika() {
		//estadistika berdina da
		assertEquals(mb1.getEstadistika(),"Abiadura");
		//estadistika ez da berdina
		assertNotEquals(mb3.getEstadistika(),"Erasoa");
	}

	@Test
	public void testGetNiriDa() {
		//niriDa true da
		assertTrue(mb1.getNiriDa());
		//niriaDa false da
		assertFalse(mb2.getNiriDa());
}

}
