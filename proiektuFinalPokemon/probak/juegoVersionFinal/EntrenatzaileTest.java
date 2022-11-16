package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EntrenatzaileTest {
	Pokedex px1;
	MugimenduKolekzioa mk1;
	Entrenatzaile e1,e2;
	Pokemon p1,p2;
	Mugimendu m1,m2,m3,m4,m5,m6,m7,m8;
	@Before
	public void setUp() throws Exception {
		px1 = Pokedex.getNirePokedex();
		e1 = new EntrenatzaileaBot("Iker",20);
		e2 = new EntrenatzaileaGuk("Unai",20);
		p1 = new Pokemon("Venusaur",1,270,152,148,153,0);
		p2 = new Pokemon("Tangela",2,240,103,112,211,0); 
		m1 = new ErasoMugimendua(2,"Ur Pistola ",1,15,40);
		m2 = new ErasoMugimendua(2,"Surf",2,15,90);
		m3 = new ErasoMugimendua(2,"Burbuila Izpia",3,15,65);
		m4 = new ErasoMugimendua(1,"Energibola",10,15,75);
		m5 = new ErasoMugimendua(1,"Hosto Magikoa",11,15,60);
		m6 = new ErasoMugimendua(1,"Tormenta Florala",13,15,80);
		m7 = new ErasoMugimendua(3,"Lanzallamas",17,15,90);
		m8 = new ErasoMugimendua(3,"Su Ukabila",18,15,75);
		mk1 = MugimenduKolekzioa.getNireMugimenduKolekzioa();
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		m1 = null;
		m2 = null;
		m3 = null;
		m4 = null;
		m5 = null;
		m6 = null;
		m7 = null;
		m8 = null;
		e1 = null;
		e2 = null;
		px1.erreseteatu();
		mk1.getNireLista().erreseteatu();
	}

	@Test
	public void testEntrenatzaile() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(m1);
		assertNotNull(m2);
		assertNotNull(m3);
		assertNotNull(m4);
		assertNotNull(m5);
		assertNotNull(m6);
		assertNotNull(m7);
		assertNotNull(m8);
		assertNotNull(e1);
		assertNotNull(e2);
		assertNotNull(px1);
		assertNotNull(mk1);
	}

	@Test 
	public void testSetIzena() {
		//izena ondo dago
		e1.setIzena("Iker Etxeba");
		assertEquals(e1.getIzena(),"Iker Etxeba");
		//izena txarto dago
		assertNotEquals(e2.getIzena(),"Iker");
	}

	@Test
	public void testEkipoaSortu() {
		assertEquals(e2.getNireListaPokemon().getNireLista().size(),0);
		px1.getNirelista().addPokemon(p1);
		px1.getNirelista().addPokemon(p2);
		mk1.getNireLista().addMugimendu(m1);
		mk1.getNireLista().addMugimendu(m2);
		mk1.getNireLista().addMugimendu(m3);
		mk1.getNireLista().addMugimendu(m4);
		mk1.getNireLista().addMugimendu(m5);
		mk1.getNireLista().addMugimendu(m6);
		mk1.getNireLista().addMugimendu(m7);
		mk1.getNireLista().addMugimendu(m8);
		e2.EkipoaSortu(1);
		assertEquals(e2.getNireListaPokemon().getNireLista().size(),1);
	}

	@Test
	public void testErabiliMugimendu() {
		//aurre:erabilitako mugimendua 1-4 zenbakiaren artean egongo da beti(bestela exception bat saltatuko luke)
		//p1 bigarren mugimendua erabiliko du
		p1.getNireLista().addMugimendu(m1);
		p1.getNireLista().addMugimendu(m2);
		p1.getNireLista().addMugimendu(m3);
		assertEquals(p1.erabiliMugimendu(2),m2);
		//p1-ek lehengo mugimendua erabiliko du
		assertEquals(p1.erabiliMugimendu(1),m1);
		
	}

}
