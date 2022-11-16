package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TipoenTablaTest {

	TipoenTabla t1;
	@Before
	public void setUp() throws Exception {
		t1 = TipoenTabla.getNireTipoenTabla();
		
	}

	@After
	public void tearDown() throws Exception {
		t1.erreseteatu();
	}

	@Test
	public void testGetNireTipoenTabla() {
		assertNotNull(t1);
	}

	@Test
	public void testSetZenbakia() {
		//  aurre : balioak taulatik barne daude
		// [0,0] posizioan 1.2 jarri
		t1.setZenbakia(0, 0, (float) 1.1);
		assertEquals(t1.getZenbakia(0, 0),(float)1.1,0);
		// [3,2] posizioan 1.2 jarri
		t1.setZenbakia(3, 2, (float) 1.6);
		assertEquals(t1.getZenbakia(3, 2),(float)1.6,0);
		// [1,2] posizioan 1.2 jarri
		t1.setZenbakia(1, 2, (float) 0.3);
		assertEquals(t1.getZenbakia(1, 2),(float)0.3,0);
	}

	@Test
	public void testKalkulatuEfectibitatea() {
		//sua
		TipoenTabla.getNireTipoenTabla().setZenbakia(0, 0,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(0, 1,(float) 0.5);
		TipoenTabla.getNireTipoenTabla().setZenbakia(0, 2,(float) 2.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(0, 3,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(0, 4,(float) 1.0);
		//ura
		TipoenTabla.getNireTipoenTabla().setZenbakia(1, 0,(float) 2.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(1, 1,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(1, 2,(float) 0.5);
		TipoenTabla.getNireTipoenTabla().setZenbakia(1, 3,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(1, 4,(float) 1.0);
		//belarra
		TipoenTabla.getNireTipoenTabla().setZenbakia(2, 0,(float) 0.5);
		TipoenTabla.getNireTipoenTabla().setZenbakia(2, 1,(float) 2.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(2, 2,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(2, 3,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(2, 4,(float) 1.0);
		//normal
		TipoenTabla.getNireTipoenTabla().setZenbakia(3, 0,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(3, 1,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(3, 2,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(3, 3,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(3, 4,(float) 0.2);
		//fantasma
		TipoenTabla.getNireTipoenTabla().setZenbakia(4, 0,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(4, 1,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(4, 2,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(4, 3,(float) 0.2);
		TipoenTabla.getNireTipoenTabla().setZenbakia(4, 4,(float) 2.0);
		//[0,4] posizioko balioa
		assertEquals(t1.getZenbakia(0,4),(float)1.0,0);
		//[1,2] posizioko balioa
		assertEquals(t1.getZenbakia(1,2),(float)0.5,0);
		//[4,4] posizioko balioa
		assertEquals(t1.getZenbakia(4,4),(float)2.0,0);
		//[2,3] posizioko balioa
		assertEquals(t1.getZenbakia(2,3),(float)1.0,0);
		
	}

}
