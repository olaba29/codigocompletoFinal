package juegoVersionFinal;
import java.util.ArrayList;
import java.util.Iterator;

public class Denda {
	// Atributuak
	private static Denda nireDenda;
	private ListaMugimenduak lista;

	// eraikitzailea
	private Denda() {
		lista = new ListaMugimenduak();
	}

	public static Denda getNireDenda() {
		if (nireDenda == null) {
			nireDenda = new Denda();
		}
		return nireDenda;
	}
	public ListaMugimenduak getnireListaMugi() {
		return this.lista;
	}
	private void mugimenduakEsleitu() {
		int[] listaZenb = new int[4];
		boolean dago = false;
		int i = 1;
		int loop = 0;
		while(i<=4) { 
			int zenbAleatorio = (int) (Math.random()*MugimenduKolekzioa.getNireMugimenduKolekzioa().listarenLuzera());
			while(loop <= 3 && !dago) {
				if(listaZenb[loop]==zenbAleatorio) {
					dago = true;
				}
				loop = loop + 1;
			}
			if(!dago) {
				Mugimendu mugimendua = MugimenduKolekzioa.getNireMugimenduKolekzioa().MugimenduakEsleitu(zenbAleatorio); //aleatorioki erabakitako mugimendua aldagai batean gordetzeko
				this.lista.addMugimendu(mugimendua); // dendan mugimenduak gordetzeko
				i = i + 1;
			}
			else {
				dago = false;
			}
			loop = 0;
		}
	}
	public Mugimendu erosiMugimendu() {
		this.mugimenduakEsleitu();
		int kont = 0;
		boolean denaOndo = false;
		Mugimendu erosteko = null;
		while (kont < 5 && !denaOndo) {
			Denda.getNireDenda().mugimenduakInprimatu();
			System.out.println("Sartu erosi nahi duzun megimenduaren zenbakia:");
			int aukeratua = Teklatua.getNireTeklatua().irakurriOsoa();
			erosteko = this.lista.hartuXPosiziokoMugimendua(aukeratua);
			System.out.println("Mugimendu hau erosi nahi duzu?");
			if (erosteko instanceof MugimenduBerezia) {
				System.out.println(((MugimenduBerezia) erosteko).getDeskripzioa());
				System.out.println("Mugimendu honek zure " + ((MugimenduBerezia) erosteko).getEstadistika() + " " + ((MugimenduBerezia) erosteko).getBooster() + " bider aldatzen du");
				System.out.println(((MugimenduBerezia) erosteko).getPrezioa() + "$ kostatzen du");
				System.out.println("");
			} else {
				System.out.println(((ErasoMugimendua) erosteko).getDeskripzioa());
				System.out.println("Mugimendu honek honako potentzia du " + ((ErasoMugimendua) erosteko).getPotentzia());
				System.out.println(((ErasoMugimendua) erosteko).getPrezioa() + "$ kostatzen du");
				System.out.println("");
			}

			System.out.println("Sartu mugimenduaren zenbakia berriz erosketa konfirmatu nahi baduzu:");
			int konfirmatu = Teklatua.getNireTeklatua().irakurriOsoa();
			if (aukeratua == konfirmatu) {
				denaOndo = true;
			}
			kont = kont + 1;	
		}
		if(denaOndo) {
			return erosteko;
		}
		else {
			return  null;
		}
	}

	private void mugimenduakInprimatu() {
		Iterator<Mugimendu> itr = this.lista.getIteradorea();
		while (itr.hasNext()) {
			Mugimendu unekoa = itr.next();
			if (unekoa instanceof MugimenduBerezia) {
				System.out.println(((MugimenduBerezia) unekoa).getDeskripzioa());
				// System.out.println(((MugimenduBerezia) erosteko).getBooster());
				// System.out.println(((MugimenduBerezia) erosteko).getEstadistika());
				System.out.println("Mugimendu honek zure " + ((MugimenduBerezia) unekoa).getEstadistika() + " "
						+ ((MugimenduBerezia) unekoa).getBooster() + " bider aldatzen du");
				System.out.println(((MugimenduBerezia) unekoa).getPrezioa() + "$ kostatzen du");
				System.out.println("");
			} else {
				System.out.println(((ErasoMugimendua) unekoa).getDeskripzioa());
				System.out.println(
						"Mugimendu honek honako potentzia du " + ((ErasoMugimendua) unekoa).getPotentzia());
				System.out.println(((ErasoMugimendua) unekoa).getPrezioa() + "$ kostatzen du");
				System.out.println("");
			}
		}
	}
	public void erreseteatu() {
		this.lista.getNireLista().clear();
	}
}
