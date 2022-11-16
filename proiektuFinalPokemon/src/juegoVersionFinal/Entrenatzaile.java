package juegoVersionFinal;

public abstract class Entrenatzaile {
	//atributuak
	private ListaPokemon listaPokemon;
	private String izena;
	private int dirua;
	//eraikitzailea
	public Entrenatzaile(String pIzena,int pDirua) {
			this.izena = pIzena;
			this.dirua = pDirua;
			this.listaPokemon = new ListaPokemon();
	}
	//gainontzeko metodoak
	public ListaPokemon getNireListaPokemon() {
		return this.listaPokemon;
	}
	public String getIzena() {
		return this.izena;
	}
	public int getDirua() {
		return this.dirua;
	}
	public void setDirua(int pDirua) {
		this.dirua=this.dirua+pDirua;
	}
	protected void setIzena(String pIzena){
		this.izena=pIzena;
	}
	public void EkipoaSortu(int zenbatPokemon) {
		int[] listaZenb = new int[4];
		int loop = 0;
		boolean dago = false;
		int i = 1;
		while(i<=zenbatPokemon) { 	
			int numAleatorio = (int) (Math.random()*Pokedex.getNirePokedex().listaLuzera());
			while (loop <= 3 && !dago) {
				if(listaZenb[loop]== numAleatorio) {
					dago = true;
				}
				loop = loop + 1;
			}
			if(!dago) { 
				listaZenb[i] = numAleatorio;
				Pokemon unekoa = Pokedex.getNirePokedex().sortuPokemon(numAleatorio);
				Pokemon kopia = new Pokemon(unekoa.getIzena(),unekoa.getId(),unekoa.getBizitza(),unekoa.getEraso(),unekoa.getAbiadura(),unekoa.getDefentsa(),unekoa.getTipoa());
				kopia.setMaxBizitza(unekoa.getBizitza());
				kopia.setListaMugimendu(unekoa.getNireLista());
				listaPokemon.addPokemon(kopia);
				i = i + 1;
			}
			else {
				dago = false;
			}
			loop = 0;
		}
	}
	public abstract Mugimendu erabiliMugimendu(Pokemon pPoke);
}