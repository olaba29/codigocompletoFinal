package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DendaTest {
	Denda d1;
	Mugimendu m1,m2,m3,m4;

	@Before
	public void setUp() throws Exception {
		d1 = Denda.getNireDenda();
		m1 = new ErasoMugimendua(2,"Ur Pistola ",1,15,40);
		m2 = new ErasoMugimendua(2,"Surf",2,15,90);
		m3 = new ErasoMugimendua(2,"Burbuila Izpia",3,15,65);
		m4 = new ErasoMugimendua(1,"Energibola",10,15,75);

	}

	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
		m3 = null;
		m4 = null;
		d1.erreseteatu();

	}

	@Test
	public void testGetNireDenda() {
		assertNotNull(m1);
		assertNotNull(m2);
		assertNotNull(m3);
		assertNotNull(m4);
		assertNotNull(d1);
	}

	@Test
	public void testErosiMugimendu() {
		//erosimugiemendu metodoko lehen lerroa komentatu dugu proba hau egiteko eta mugimenduak eskuz sartu ditugu dendan, aleatorioki izan beharrean
		d1.getnireListaMugi().addMugimendu(m1);
		d1.getnireListaMugi().addMugimendu(m2);
		d1.getnireListaMugi().addMugimendu(m3);
		d1.getnireListaMugi().addMugimendu(m4);
		//teklatutik 4 bi aldiz(konfirmatzeko) sartuz gero
		assertEquals(d1.erosiMugimendu(),m4);
		//5 saiakera egin ondoren ez badugu ezer erosten null 
		assertNull(d1.erosiMugimendu());
	}

}
