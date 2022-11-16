package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaEntrenatzaileTest {
	ListaEntrenatzaile le1;
	EntrenatzaileaBot e1,e2;
	EntrenatzaileaGuk g1;
	Pokemon p1,p2,p3;
	Mugimendu m1,m2,m3,m4,m5,m6,m7,m8;
	@Before
	public void setUp() throws Exception {
		le1 = ListaEntrenatzaile.getNireListaEntrenatzaile();
		e1 = new EntrenatzaileaBot("Iker",20);
		e2 = new EntrenatzaileaBot("Unai",20);
		g1 = new EntrenatzaileaGuk("Jonas",20);
		p1 = new Pokemon("Venusaur",1,270,152,148,153,0);
		p2 = new Pokemon("Tangela",2,240,103,112,211,0); 
		p3 = new Pokemon("Exeggutor",3,300,175,103,157,0);
		m1 = new ErasoMugimendua(2,"Ur Pistola ",1,15,40);
		m2 = new ErasoMugimendua(2,"Surf",2,15,90);
		m3 = new ErasoMugimendua(2,"Burbuila Izpia",3,15,65);
		m4 = new ErasoMugimendua(1,"Energibola",10,15,75);
		m5 = new ErasoMugimendua(1,"Hosto Magikoa",11,15,60);
		m6 = new ErasoMugimendua(1,"Tormenta Florala",13,15,80);
		m7 = new ErasoMugimendua(3,"Lanzallamas",17,15,90);
		m8 = new ErasoMugimendua(3,"Su Ukabila",18,15,75);
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		p3 = null;
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
		g1 = null;
		le1.getLista().clear();
	}

	@Test
	public void testGetNireListaEntrenatzaile() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
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
		assertNotNull(g1);
		assertNotNull(le1);
	}

	@Test
	public void testBorrokatu() {
		//pokemon-ei mugimenduak esleituko diegu
		//pokemon 1
		p1.getNireLista().addMugimendu(m1);
		p1.getNireLista().addMugimendu(m2);
		p1.getNireLista().addMugimendu(m3);
		p1.getNireLista().addMugimendu(m4);
		//pokemon 2
		p2.getNireLista().addMugimendu(m5);
		p2.getNireLista().addMugimendu(m6);
		p2.getNireLista().addMugimendu(m7);
		p2.getNireLista().addMugimendu(m8);
		//pokemon 3
		p3.getNireLista().addMugimendu(m1);
		p3.getNireLista().addMugimendu(m2);
		p3.getNireLista().addMugimendu(m7);
		p3.getNireLista().addMugimendu(m8);
		//entrenatzaile bakoitzari pokemon bat esleituko diegu
		e1.getNireListaPokemon().addPokemon(p1);
		e2.getNireListaPokemon().addPokemon(p2);
		g1.getNireListaPokemon().addPokemon(p3);
		//probak egiteko soilik 2 entrenatzaileen kontra borrokatuko dugu eta ez da dendarik egongo
		le1.getLista().add(e1);
		le1.getLista().add(e2);
		le1.setPertsonaje(g1);
		assertNotNull(le1);
	    System.out.println("===============================================================");
        System.out.println("Ondorengo partidaren informazioa agertu beharko litzateke galtzen baduzu:\n");
        System.out.println("galdu duzu");
        System.out.println("Eta zure programak zera dio:\n");
        String[] prueba = new String[10];
		ListaEntrenatzaile.main(prueba);
	}
}


