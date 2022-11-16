package juegoVersionFinal;

import java.util.Iterator;

public class Pokemon {
	//atributuak
	private String izena ;
	private int id;
	private float bizitza;
	private float maxBizitza;
	private float eraso;
	private float abiadura;
	private ListaMugimenduak listaMugimendu;
	private int tipoa;
	private float defentsa;
	//eraikitzailea
	public Pokemon(String pIzena,int pId,float pBizitza, float pEraso, float pAbiadura, float pDefentsa,int pTipoa) {
		this.izena = pIzena;
		this.id = pId;
		this.bizitza = pBizitza;
		this.eraso = pEraso;
		this.abiadura = pAbiadura;
		this.defentsa = pDefentsa;
		this.tipoa = pTipoa;
		this.listaMugimendu = new ListaMugimenduak();
	}
	//gett-er and sett-er
	public void setListaMugimendu(ListaMugimenduak pListaMugimendu) {
		this.listaMugimendu = pListaMugimendu;
	}
	public void setEraso(float booster) {
		Pokemon poke = Pokedex.getNirePokedex().getNirelista().bilatuPokemonIdz(this.getId());
		try {
			this.eraso = this.eraso*booster;
			if(booster < 1.0) {
				if(this.eraso < 0.5*poke.getEraso()) {
					throw new ErasoGutxiegiException();
				}
			}
			else {
				if(this.eraso > 2*poke.getEraso()) {
					throw new ErasoGehiegiException();
				}
			}
		}catch(ErasoGehiegiException e) {
			e.mezuaInprimatu();
			this.eraso = 2*poke.getEraso();
		}catch(ErasoGutxiegiException e) {
			e.mezuaInprimatu();
			this.eraso = (float) (0.5*poke.getEraso());
		}
	}
	public void setDefentsa(float booster) {
		Pokemon poke = Pokedex.getNirePokedex().getNirelista().bilatuPokemonIdz(this.getId());
		try {
			this.defentsa = this.defentsa*booster;
			if(booster < 1.0) {
				if(this.defentsa < 0.5*poke.getDefentsa()) {
					throw new DefentsaGutxiegiException();
				}
			}
			else {
				if(this.defentsa > 2*poke.getDefentsa()) {
					throw new DefentsaGehiegiException();
				}
			}
		}catch(DefentsaGehiegiException e) {
			e.mezuaInprimatu();
			this.defentsa = 2*poke.getDefentsa();
		}catch(DefentsaGutxiegiException e) {
			e.mezuaInprimatu();
			this.defentsa = (float) (0.5*poke.getDefentsa());
		}
	}
	public String tipoaItzuli(int pZenb) {
		String ema = "";
		if(pZenb==0) {
			ema = "sua";
		}
		if(pZenb==1) {
			ema = "ura";
		}
		if(pZenb==2) {
			ema = "belarra";
		}
		if(pZenb==3) {
			ema = "normal";
		}
		if(pZenb==4) {
			ema = "fantasma";
		}
		return ema;
	}
	public void setAbiadura(float booster) {
		Pokemon poke = Pokedex.getNirePokedex().getNirelista().bilatuPokemonIdz(this.getId());
		try {
			this.abiadura = this.abiadura*booster;
			if(booster < 1.0) {
				if(this.abiadura < 0.5*poke.getAbiadura()) {
					throw new AbiaduraGutxiegiException();
				}
			}
			else {
				if(this.abiadura > 2*poke.getAbiadura()) {
					throw new AbiaduraGehiegiException();
				}
			}
		}catch(AbiaduraGehiegiException e) {
			e.mezuaInprimatu();
			this.abiadura = 2*poke.getAbiadura();
		}catch(AbiaduraGutxiegiException e) {
			e.mezuaInprimatu();
			this.abiadura = (float) (0.5*poke.getAbiadura());
		}
	}
	public void setMaxBizitza(float pBizitza) {
		this.maxBizitza=pBizitza;
	}
	public void setBizitza(float booster) {
		Pokemon poke = Pokedex.getNirePokedex().getNirelista().bilatuPokemonIdz(this.getId());
		try {
			this.bizitza = this.bizitza*booster;
			if(this.bizitza > poke.getBizitza()) {
				throw new BizitzaGehiegiException();
			}
		}catch(BizitzaGehiegiException e) {
			e.mezuaInprimatu();
			this.bizitza = poke.getBizitza();
		}
	}
	public void BizitzaErrekuperatu(float pBizitza) {
		this.bizitza=pBizitza;
	}
	public void erasoEgin(float pPotentzia,float pEfizientzia,float pEraso,float pDefentsa,float pMugimenduaEtaPokemonTipoBera) {
		this.bizitza = (float) (this.bizitza - (pMugimenduaEtaPokemonTipoBera*pEfizientzia*(((21.0*pPotentzia*pEraso)/(25.0*pDefentsa))+2.0)));
	}
	public float getBizitza() {
		return this.bizitza;
	}
	public float getMaxBizitza() {
		return this.maxBizitza;
	}
	public float getAbiadura() {
		return this.abiadura;
	}
	public int getId() {
		return this.id;
	}
	public String getIzena() {
		return this.izena;
	}
	public float getEraso() {
		return this.eraso;
	}
	public float getDefentsa() {
		return this.defentsa;
	}
	public int getTipoa() {
		return this.tipoa;
	}
	public ListaMugimenduak getNireLista() {
		return this.listaMugimendu;
	}
	//gainontzeko metodoak
	public Mugimendu erabiliMugimendu(Integer zenb) {
		int i = 1;
		Mugimendu emaitza = null;
		boolean aurkitua = false;
		Iterator<Mugimendu> itr = this.listaMugimendu.getIteradorea();
		while(i <= 4 && !aurkitua){
			Mugimendu mugi = itr.next();
			if(i==zenb) {
				aurkitua = true;
				emaitza = mugi;
			}
			i = i + 1;
		}
		return emaitza;
	}

	public void MugimenduakEsleitu() {
		if(this.getNireLista().listarenLuzera()==0) { //para que no le ponga mas de 4 ataques a cada pokemon
			int[] listaZenb = new int[4];
			boolean dago = false;
			int i = 1;
			int loop = 0;
			Mugimendu mugimendua = null;
			boolean lehenErasoMugimendua = false;//honekin pokemon bakoitza erasomugimendu bat izango duela bermatuko dugu
			while(i<=4) { 
				int zenbAleatorio = (int) (Math.random()*MugimenduKolekzioa.getNireMugimenduKolekzioa().listarenLuzera());
				while(loop <= 3 && !dago) {
					if(listaZenb[loop]==zenbAleatorio) {
						dago = true;
					}
					loop = loop + 1;
				}
				if(!dago) {
					mugimendua = MugimenduKolekzioa.getNireMugimenduKolekzioa().MugimenduakEsleitu(zenbAleatorio); //aleatorioki erabakitako mugimendua bariable batean gordetzeko
					if(!lehenErasoMugimendua) {//gutxienez eraso bat eraso mugimenduarena izateko
						if(mugimendua instanceof ErasoMugimendua && this.getTipoa()==mugimendua.getTipoa()) {
							this.listaMugimendu.addMugimendu(mugimendua); // uneko pokemonari bere lista mugimenduan gordetzeko
						}
						else {
							if(this.getTipoa()==1) {
								zenbAleatorio = (int) Math.floor(Math.random()*(14-8+1)+8);
								mugimendua = MugimenduKolekzioa.getNireMugimenduKolekzioa().MugimenduakEsleitu(zenbAleatorio);
								this.listaMugimendu.addMugimendu(mugimendua);
							}
							else if(this.getTipoa()==2) {
								zenbAleatorio = (int) Math.floor(Math.random()*(7-1+1)+1);
								mugimendua = MugimenduKolekzioa.getNireMugimenduKolekzioa().MugimenduakEsleitu(zenbAleatorio);
								this.listaMugimendu.addMugimendu(mugimendua);
							}
							else if(this.getTipoa()==3) {
								zenbAleatorio = (int) Math.floor(Math.random()*(21-15+1)+15);
								mugimendua = MugimenduKolekzioa.getNireMugimenduKolekzioa().MugimenduakEsleitu(zenbAleatorio);
								this.listaMugimendu.addMugimendu(mugimendua);
							}
							else if(this.getTipoa()==4) {
								zenbAleatorio = (int) Math.floor(Math.random()*(28-22+1)+22);
								mugimendua = MugimenduKolekzioa.getNireMugimenduKolekzioa().MugimenduakEsleitu(zenbAleatorio);
								this.listaMugimendu.addMugimendu(mugimendua);
							}
							else {
								zenbAleatorio = (int) Math.floor(Math.random()*(35-29+1)+29);
								mugimendua = MugimenduKolekzioa.getNireMugimenduKolekzioa().MugimenduakEsleitu(zenbAleatorio);
								this.listaMugimendu.addMugimendu(mugimendua);
							}
						}
						lehenErasoMugimendua = true;
						i = i + 1;
					}
					else {
						this.listaMugimendu.addMugimendu(mugimendua);
						i = i + 1;
					}
					listaZenb[i-2]=zenbAleatorio;
				}
				else {
					dago = false;
				}
				loop = 0;
			}
		}
	}
	public boolean idBerdinaDu(int pId) {
		boolean emaitza = false;
		if(this.getId() == pId) {
			emaitza = true;
		}
		return emaitza;
	}
	public void mugimenduakImprimatu() {
		Iterator<Mugimendu>	itr = this.listaMugimendu.getIteradorea();
		while(itr.hasNext()) {
			Mugimendu unekoa = itr.next();
			if(unekoa instanceof MugimenduBerezia) {
				System.out.println(((MugimenduBerezia)unekoa).getDeskripzioa());
				System.out.println(((MugimenduBerezia)unekoa).getBooster());
				System.out.println(((MugimenduBerezia)unekoa).getEstadistika());
			}
			else {
				System.out.println(((ErasoMugimendua)unekoa).getDeskripzioa());
				System.out.println(((ErasoMugimendua)unekoa).getPotentzia());
			}
		}
	}
	public void printBarra() {
	    float largo = 20*(this.bizitza/this.maxBizitza);
	    int cont=0;
	    while (cont<largo) {
	        System.out.print("#");
	        cont++;
	    }
	    while (cont<20) {
	        System.out.print("·");
	        cont++;
	    }
	}
}