package juegoVersionFinal;
public class TipoenTabla {
	//atributuak
	private static TipoenTabla nireTipoenTabla;
	private float[][] tablaTipo;
	//eraikitzailea
	private TipoenTabla() {
		tablaTipo = new float[5][5];
	}
	public static TipoenTabla getNireTipoenTabla() {
		if(nireTipoenTabla == null) {
			nireTipoenTabla = new TipoenTabla();
		}
		return nireTipoenTabla;
	}
	//gainontzeko metodoak
	public void setZenbakia(int errenkada,int zutabe,float balioa) {
		TipoenTabla.getNireTipoenTabla().tablaTipo[errenkada][zutabe] = balioa;
	}
	public float getZenbakia(int p1,int p2) {
		return tablaTipo[p1][p2];
	}
	public float kalkulatuEfectibitatea(int errenkada,int zutabe) {
		return TipoenTabla.getNireTipoenTabla().tablaTipo[errenkada][zutabe];
	}
	public void erreseteatu() {
		for(int i = 0; i<=3;i++) {
			for(int a = 0; a<=3;a++) {
				tablaTipo[i][a]= 0;
			}
		}
	}
}
