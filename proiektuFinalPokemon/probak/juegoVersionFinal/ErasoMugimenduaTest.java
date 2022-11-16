package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ErasoMugimenduaTest {

	ErasoMugimendua e1,e2;
	@Before
	public void setUp() throws Exception {
		e1 = new ErasoMugimendua(5,"Itzal Ukabila",29,15,60);
		e2 = new ErasoMugimendua(5,"Garra Itzaltsua",30,15,90);
	}

	@After
	public void tearDown() throws Exception {
		e1 = null;
		e2 = null;
	}

	@Test
	public void testErasoMugimendua() {
		assertNotNull(e1);
		assertNotNull(e2);
	}

	@Test
	public void testGetPotentzia() {
		//potentzia ondo hartu
		assertEquals(e1.getPotentzia(),60);
		//potentzia txarto hartu
		assertNotEquals(e1.getPotentzia(),90);
	}

}
