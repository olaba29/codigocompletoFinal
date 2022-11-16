package juegoVersionFinal;

public class EntrenatzaileaBot extends Entrenatzaile{
	//atributuak
	
	//eraikitzailea
	public EntrenatzaileaBot(String pIzena, int pDirua) {
		super(pIzena, pDirua);
	}
	//gainontzeko metodoak
	public Mugimendu erabiliMugimendu(Pokemon pPoke){
		int zenbakiAleatorioa = (int) (Math.random()*4+1);//1-4 zenbaki aleatorio bat sortzeko mugimendu hori erabiltzeko
		Mugimendu erabilitakoa = pPoke.erabiliMugimendu(zenbakiAleatorioa); //erabiliko duzun erasoa mugimendua gordetzeko
		return erabilitakoa;
	}
}
