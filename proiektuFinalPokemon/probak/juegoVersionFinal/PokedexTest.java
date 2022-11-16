package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PokedexTest {
	Pokedex px1;
	Pokemon p1,p2,p3;
	Mugimendu m1,m2,m3,m4,m5,m6;
	MugimenduKolekzioa mk1;
	@Before
	public void setUp() throws Exception {
		px1 = Pokedex.getNirePokedex();
		p1 = new Pokemon("Venusaur",1,270,152,148,153,0);
		p2 = new Pokemon("Tangela",2,240,103,112,211,0); 
		p3 = new Pokemon("Exeggutor",3,300,175,103,157,0);
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
		px1.erreseteatu();
		p1 = null;
		p2 = null;
		p3 = null;
		m1 = null;
		m2 = null;
		m3 = null;
		m4 = null;
		m5 = null;
		m6 = null;
		mk1.getNireLista().erreseteatu();
	}

	@Test
	public void testGetNirePokedex() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
		assertNotNull(px1);
		assertNotNull(m1);
		assertNotNull(m2);
		assertNotNull(m3);
		assertNotNull(m4);
		assertNotNull(m5);
		assertNotNull(m6);
		assertNotNull(mk1);
	}


	@Test
	public void testListaLuzera() {
		//lista ez du pokemon-erik
		assertEquals(px1.getNirelista().listarenLuzera(),0);
		//3 pokemon sartuz
		px1.getNirelista().addPokemon(p1);
		px1.getNirelista().addPokemon(p2);
		px1.getNirelista().addPokemon(p3);
		assertEquals(px1.getNirelista().listarenLuzera(),3);
	}
 
	@Test
	public void testSortuPokemon() {
		mk1.getNireLista().addMugimendu(m1);
		mk1.getNireLista().addMugimendu(m2);
		mk1.getNireLista().addMugimendu(m3);
		mk1.getNireLista().addMugimendu(m4);
		mk1.getNireLista().addMugimendu(m5);
		mk1.getNireLista().addMugimendu(m6);
		px1.getNirelista().addPokemon(p1);
		px1.getNirelista().addPokemon(p2);
		px1.getNirelista().addPokemon(p3);
		assertEquals(px1.sortuPokemon(3),p3);
	}
	@Test
	public void testErreseteatu() {
		px1.getNirelista().addPokemon(p1);
		px1.getNirelista().addPokemon(p2);
		px1.getNirelista().addPokemon(p3);
		assertEquals(px1.getNirelista().listarenLuzera(),3);
		px1.erreseteatu();
		//hutsik dagoela konprobatuz
		assertEquals(px1.getNirelista().listarenLuzera(),0);
	}
}
