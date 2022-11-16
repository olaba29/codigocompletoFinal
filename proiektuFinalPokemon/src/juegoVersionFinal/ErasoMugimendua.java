package juegoVersionFinal;

public class ErasoMugimendua extends Mugimendu {
	//atributuak
	private int potentzia;
	//eraikitzailea
	public ErasoMugimendua(int pTipo, String pDeskripzioa, int pId,int pPrezioa, int pPotentzia) {
		super(pTipo,pDeskripzioa,pId,pPrezioa);
		this.potentzia = pPotentzia;
	}
	//gainontzeko metodoak
	public int getPotentzia() {
		return this.potentzia;
	}
}