package juegoVersionFinal;
public class MugimenduBerezia extends Mugimendu {
	//atributuak
	private float booster;
	private String estadistika;
	private boolean niriDa;
	//eraikitzailea
	public MugimenduBerezia(int pTipo, String pDeskripzioa, int pId,int pPrezioa,float pBooster, String pEstadistika,boolean pNiriDa) {
		super(pTipo,pDeskripzioa,pId,pPrezioa);
		this.booster = pBooster;
		this.estadistika = pEstadistika;
		this.niriDa = pNiriDa;
	}
	//gainontzeko metodoak
	public float getBooster() {
		return this.booster;
	}

	public String getEstadistika() {
		return this.estadistika;
	}
	public boolean getNiriDa() { //booster-a erasoa egiten duen pokemonari edo besteari den jakiteko
		return this.niriDa;
	}
}