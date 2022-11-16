package juegoVersionFinal;
public class MugimenduKolekzioa {
	//atributuak
	private static MugimenduKolekzioa nMugimenduKolekzioa = null;
	private ListaMugimenduak listaMugimendu;
	//eraikitzailea
	private MugimenduKolekzioa() {
		this.listaMugimendu = new ListaMugimenduak();
	}

	public static MugimenduKolekzioa getNireMugimenduKolekzioa() {
		if(nMugimenduKolekzioa == null) {
			nMugimenduKolekzioa = new MugimenduKolekzioa();
		}
		return nMugimenduKolekzioa;
		
	}
	//gainontzeko metodoak
	public ListaMugimenduak getNireLista() {
		return this.listaMugimendu;
	}
	public int listarenLuzera() {
		return listaMugimendu.listarenLuzera();
	}
	public Mugimendu MugimenduakEsleitu(int mugimenduId) {
		return listaMugimendu.bilatuMugimenduIdz(mugimenduId);
	}
}