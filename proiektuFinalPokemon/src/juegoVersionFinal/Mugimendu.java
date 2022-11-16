package juegoVersionFinal;
public abstract class Mugimendu {
	//atributuak
	private int tipoa;
	private String deskripzioa;
	private int id;
	private int prezioa;
	//eraikitzailea
	public Mugimendu(int pTipo, String pDeskripzioa, int pId,int pPrezioa) {
		this.tipoa = pTipo;
		this.deskripzioa = pDeskripzioa;
		this.id = pId;
		this.prezioa = pPrezioa;
	}
	//gainontzeko metodoak
	public int getTipoa() {
		return this.tipoa;
	}

	public int getId() {
		return this.id;
	}
	public int getPrezioa() {
		return this.prezioa;
	}
	public String getDeskripzioa() {
		return this.deskripzioa;
	}

	public boolean idBerdinaDu(int pId) {
		boolean emaitza = false;
		if(this.getId() == pId) {
			emaitza = true;
		}
		return emaitza;
	}

}
