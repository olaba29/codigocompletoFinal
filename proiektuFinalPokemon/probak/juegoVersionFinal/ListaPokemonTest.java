package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaPokemonTest {

	ListaPokemon l1;
	Pokemon p1,p2,p3;
	Mugimendu m1,m2,m3,m4,m5,m6;
	MugimenduKolekzioa mk1;
	@Before
	public void setUp() throws Exception {
		l1 = new ListaPokemon();
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
		p1 = null;
		p2 = null;
		p3 = null;
		l1.erreseteatu();
		m1 = null;
		m2 = null;
		m3 = null;
		m4 = null;
		m5 = null;
		m6 = null;
		mk1.getNireLista().erreseteatu();
	}

	@Test
	public void testListaPokemon() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
		assertNotNull(l1);
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
		//lista ez du pokemon-erik
		assertEquals(l1.listarenLuzera(),0);
		//3 pokemon sartuz
		l1.addPokemon(p1);
		l1.addPokemon(p2);
		l1.addPokemon(p3);
		assertEquals(l1.listarenLuzera(),3);
	}

	@Test
	public void testAddPokemon() {
		//lista ez du pokemon-erik
		assertEquals(l1.listarenLuzera(),0);
		//pokemon bat gehituz
		l1.addPokemon(p1);
		assertEquals(l1.listarenLuzera(),1);
	}

	@Test
	public void testRemovePokemon() {
		//3 pokemon sartuz
		l1.addPokemon(p1);
		l1.addPokemon(p2);
		l1.addPokemon(p3);
		assertEquals(l1.listarenLuzera(),3);
		//pokemon bat kenduz
		l1.removePokemon(p3);
		assertEquals(l1.listarenLuzera(),2);
	}

	@Test
	public void testSortuPokemon() {
		mk1.getNireLista().addMugimendu(m1);
		mk1.getNireLista().addMugimendu(m2);
		mk1.getNireLista().addMugimendu(m3);
		mk1.getNireLista().addMugimendu(m4);
		mk1.getNireLista().addMugimendu(m5);
		mk1.getNireLista().addMugimendu(m6);
		l1.addPokemon(p1);
		l1.addPokemon(p2);
		l1.addPokemon(p3);
		assertEquals(l1.SortuPokemon(3),p3);
	}

	@Test
	public void testImprimatuPokemon() {
		l1.addPokemon(p1);
		l1.addPokemon(p2);
		l1.addPokemon(p3);
		assertNotNull(l1);
		System.out.println("===============================================================");
	    System.out.println("Ondorengo pokemon-en informazioa agertu beharko litzateke:\n");
	    System.out.println("Venusaur,tangela,exeggutor");
	    System.out.println("Eta zure programak zera dio:\n");
	    l1.imprimatuPokemon();
	}

}
