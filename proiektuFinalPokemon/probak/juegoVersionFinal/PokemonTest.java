package juegoVersionFinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PokemonTest {

	Pokemon p1,p2,p3;
	Mugimendu m1,m2,m3,m4,m5,m6;
	MugimenduKolekzioa mk1;
	@Before
	public void setUp() throws Exception {
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
		m1 = null;
		m2 = null;
		m3 = null;
		m4 = null;
		m5 = null;
		m6 = null;
	}

	@Test
	public void testPokemon() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
		assertNotNull(m1);
		assertNotNull(m2);
		assertNotNull(m3);
		assertNotNull(m4);
		assertNotNull(m5);
		assertNotNull(m6);
	}

	@Test
	public void testErasoEgin() {
		//efizientzia eta mugiemnduaren eraso potentzia asmatu egin ditugu probak egiteko
		//p2 pokemon-a p1 pokemonari erasotzen dio 100 potentzia duen erasoarekin (efizientzia 1.0)
		p1.erasoEgin((float)100.0,(float) 1.0,(float) 103.0,(float) 153.0,(float) 1.0);
		assertEquals(p1.getBizitza(),(float)211.45097,0);
		//p3 pokemon-a p2 pokemonari erasotzen dio 80 potentzia duen erasoarekin (efizientzia 2.0)
		p2.erasoEgin((float)80.0,(float) 2.0,(float) 175.0,(float) 211.0,(float) 1.0);
		assertEquals(p2.getBizitza(),(float)124.53081,0);
		//p1 pokemon-a p3 pokemonari erasotzen dio 80 potentzia duen erasoarekin (efizientzia 0.5)
		p3.erasoEgin((float)150.0,(float)0.5,(float) 153.0,(float) 175.0,(float) 1.0);
		assertEquals(p3.getBizitza(),(float)243.92,0);
		
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

	@Test 
	public void testMugimenduakEsleitu() {
		mk1.getNireLista().addMugimendu(m1);
		mk1.getNireLista().addMugimendu(m2);
		mk1.getNireLista().addMugimendu(m3);
		mk1.getNireLista().addMugimendu(m4);
		mk1.getNireLista().addMugimendu(m5);
		mk1.getNireLista().addMugimendu(m6);
		//p1 pokemon-ak ez du mugimendurik
		assertEquals(p1.getNireLista().listarenLuzera(),0);
		//p1 pokemon-ari mugimenduak esleitu eta gero 4 ditu
		p1.MugimenduakEsleitu();
		assertEquals(p1.getNireLista().listarenLuzera(),4);
	}

	@Test
	public void testIdBerdinaDu() {
		//id berdina du
		assertTrue(p1.idBerdinaDu(1));
		//ez du id berdinik
		assertFalse(p2.idBerdinaDu(5));
	}
 
	@Test
	public void testMugimenduakImprimatu() {
		  p1.getNireLista().addMugimendu(m1);
		  p1.getNireLista().addMugimendu(m2);
		  p1.getNireLista().addMugimendu(m3);
		  p1.getNireLista().addMugimendu(m4);
		  assertNotNull(p1.getNireLista());
		  System.out.println("===============================================================");
	      System.out.println("Ondorengo mugimenduen informazioa agertu beharko litzateke:\n");
	      System.out.println("Ur Pistola,Surf,Burbuila Izpia,Energibola");
	      System.out.println("Eta zure programak zera dio:\n");
	      //p1.getNireLista().mugimenduakInprimatu();
	}
}
