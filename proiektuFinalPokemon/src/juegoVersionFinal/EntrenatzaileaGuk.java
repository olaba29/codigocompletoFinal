package juegoVersionFinal;

public class EntrenatzaileaGuk extends Entrenatzaile{
	//atributuak
	
	//eraikitzailea
	public EntrenatzaileaGuk(String pIzena, int pDirua) {
		super(pIzena, pDirua);
	}
	//gainontzeko metodoak
	@Override
	public Mugimendu erabiliMugimendu(Pokemon pPoke) {
		Integer num = Teklatua.getNireTeklatua().irakurriOsoa();
		Mugimendu erabili = pPoke.erabiliMugimendu(num);
		return erabili; 
	}
}
