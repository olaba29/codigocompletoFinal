package juegoVersionFinal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;


public class ListaEntrenatzaile {
	//atributuak
	private static ListaEntrenatzaile listaEntrenatzaile = null;
	private EntrenatzaileaGuk pertsonajea = null;
	private ArrayList<Entrenatzaile> lista;
	// eraikitzailea
	private ListaEntrenatzaile() {
		this.lista = new ArrayList<Entrenatzaile>();
	}
	public static ListaEntrenatzaile getNireListaEntrenatzaile() {
			if(listaEntrenatzaile == null) {
				listaEntrenatzaile = new ListaEntrenatzaile();
			}
			return listaEntrenatzaile;
	}
	//gainontzeko metodoak
	public ArrayList<Entrenatzaile> getLista() {
		return this.lista;
	}
	public void setPertsonaje(EntrenatzaileaGuk pPertson) {
		this.pertsonajea = pPertson;
	}
	public void erreseteatu() {
		this.lista.clear();
	}
	private void borrokatu() {
		boolean lehengoAldia = true;//pa que no cambie nuestro pokemon todo el rato
		Iterator<Entrenatzaile> itrEntrenatzaileak = this.getIteradorea();
		boolean ondoGoaz = true;//gure pokemon guztiak hiltzen direnean partida amaitzeko
		boolean pokemonGeratuAurkariari = true;
		Iterator<Pokemon> gureEkipo = pertsonajea.getNireListaPokemon().getIteradorea(); //gure ekipoko pokemon-ak hartzeko
		Pokemon gurePoke = null;
		int i = 2; 
		int ronda = 1;
		while(itrEntrenatzaileak.hasNext() && ondoGoaz) {
			pokemonGeratuAurkariari = true;
			Entrenatzaile unekoa = itrEntrenatzaileak.next(); //entrenatzaileak banak hartzen joateko
			Iterator<Pokemon> unekoaEkipoa = unekoa.getNireListaPokemon().getIteradorea(); //uneko entrenatzailearen ekipoa hartzeko
			Pokemon unekoPoke = null;
			System.out.println("|                                                    |");
			System.out.println("|Jolasten ari zaren ronda hurrengoa da: "+ ronda + "            |");
			System.out.println("|                                                    |");
			System.out.println("Aurkariak "+ unekoa.getNireListaPokemon().listarenLuzera()+" pokemon ditu");
			while( ondoGoaz && pokemonGeratuAurkariari) {
				if(lehengoAldia || unekoPoke == null) {
					if (lehengoAldia) {
						unekoPoke = unekoaEkipoa.next();
						gurePoke = gureEkipo.next();
						lehengoAldia = false;
					}
					else { //pa cuando pases de ronda no de null
						unekoPoke = unekoaEkipoa.next();
					}
				}
				if(ondoGoaz) {
					PokemonIrudiak.getNirePokemonIrudia().printPokemon(unekoPoke.getIzena());
					System.out.println("Aurkakoaren pokemon-a: "+unekoPoke.getIzena()+" tipoa: "+ unekoPoke.tipoaItzuli(unekoPoke.getTipoa()));
					unekoPoke.printBarra();
					System.out.print("[" + Math.floor(unekoPoke.getBizitza()) + "/" + unekoPoke.getMaxBizitza() + "]");
					System.out.println();
					System.out.println("----------------");
					System.out.println("|atakea:"+Math.floor(unekoPoke.getEraso()) + "  |");
					System.out.println("|defentsa:"+Math.floor(unekoPoke.getDefentsa()) + "|");
					System.out.println("|abiadura:"+Math.floor(unekoPoke.getAbiadura()) + "|");
					System.out.println("----------------");
					PokemonIrudiak.getNirePokemonIrudia().printPokemon(gurePoke.getIzena());
					System.out.println("Gure pokemon-a :"+gurePoke.getIzena()+" tipoa: "+ gurePoke.tipoaItzuli(gurePoke.getTipoa()));
					gurePoke.printBarra();
					System.out.print("[" + Math.floor(gurePoke.getBizitza()) + "/" + gurePoke.getMaxBizitza() + "]");
					System.out.println();
					System.out.println("----------------");
					System.out.println("|atakea:"+Math.floor(gurePoke.getEraso()) + "  |");
					System.out.println("|defentsa:"+Math.floor(gurePoke.getDefentsa()) + "|");
					System.out.println("|abiadura:"+Math.floor(gurePoke.getAbiadura()) + "|");
					System.out.println("----------------");
					//kontrakoen txanda
					if(unekoPoke.getAbiadura() > gurePoke.getAbiadura()) {
						System.out.println("aurkakoa lehengoa");
						Mugimendu erabilitakoa = unekoa.erabiliMugimendu(unekoPoke);
						System.out.println(unekoPoke.getIzena()+" hurrengoa erabili du "+erabilitakoa.getDeskripzioa());
						erasoTurnoa(unekoPoke,gurePoke,erabilitakoa,unekoPoke.getTipoa(),gurePoke.getTipoa(),unekoPoke.getEraso(),gurePoke.getDefentsa());
						if(gurePoke.getBizitza()>0) { //lehenik pokemon-a bizirik dagoen jakiteko
							System.out.println("Gure pokemon-aren bizitza berria:"+gurePoke.getBizitza());
							gurePoke.mugimenduakImprimatu(); 
							Mugimendu erabili = pertsonajea.erabiliMugimendu(gurePoke);
							erasoTurnoa(gurePoke,unekoPoke,erabili,unekoPoke.getTipoa(),gurePoke.getTipoa(),gurePoke.getEraso(),unekoPoke.getDefentsa());	
							System.out.println(gurePoke.getIzena()+" hurrengoa erabili du "+erabili.getDeskripzioa());
							if(unekoPoke.getBizitza() <= 0){
								if(unekoaEkipoa.hasNext()) {
									unekoPoke = unekoaEkipoa.next(); //kontrakoaren uneko pokemon-a
								}
								else {
									System.out.println("uneko entrenatzailea pokemon gabe dago");
									ronda = ronda + 1;
									pokemonGeratuAurkariari = false;
								}
							}
						}
						else {
							if(gureEkipo.hasNext()) { //pokemon bat hiltzean hurrengoa sartzeko
								System.out.println("gure pokemona:"+ i);
								gurePoke = gureEkipo.next(); //kontrakoaren uneko pokemon-a
								i = i + 1;
							}
							else {
								File txt4= new File ("res/galdu.txt");
								irakurri(txt4);
								Teklatua.getNireTeklatua().irakurriEnter();
								ondoGoaz = false;
							}
						}
					}
					else {
						System.out.println("guk lehengoa");
						gurePoke.mugimenduakImprimatu();
						Mugimendu erabili = pertsonajea.erabiliMugimendu(gurePoke);
						erasoTurnoa(gurePoke,unekoPoke,erabili,gurePoke.getTipoa(),unekoPoke.getTipoa(),gurePoke.getEraso(),unekoPoke.getDefentsa());
						System.out.println(gurePoke.getIzena()+" hurrengoa erabili du "+erabili.getDeskripzioa());
						if(unekoPoke.getBizitza()>0) {//lehenik pokemon-a bizirik dagoen jakiteko
							System.out.println("Aurkakoaren pokemon-aren bizitza berria:"+unekoPoke.getBizitza());
							Mugimendu erabilitakoa = unekoa.erabiliMugimendu(unekoPoke);
							erasoTurnoa(unekoPoke,gurePoke,erabilitakoa,unekoPoke.getTipoa(),gurePoke.getTipoa(),unekoPoke.getEraso(),gurePoke.getDefentsa());
							System.out.println(unekoPoke.getIzena()+" hurrengoa erabili du "+erabilitakoa.getDeskripzioa());
							if(gurePoke.getBizitza() <= 0) {
								if(gureEkipo.hasNext()) { //pokemon bat hiltzean hurrengoa sartzeko
									System.out.println("gure pokemona:"+ i);
									gurePoke = gureEkipo.next(); //kontrakoaren uneko pokemon-a
									i = i + 1;
								}
								else {
									File txt4= new File ("res/galdu.txt");
									irakurri(txt4);
									Teklatua.getNireTeklatua().irakurriEnter();
									ondoGoaz = false;
								}
							}
						}
						else {
							if(unekoaEkipoa.hasNext()) {
								unekoPoke = unekoaEkipoa.next(); //kontrakoaren uneko pokemon-a
							}
							else {
								System.out.println("uneko entrenatzailea pokemon gabe dago");
								pertsonajea.setDirua(unekoa.getDirua());
								System.out.println("dirua:"+ pertsonajea.getDirua());
								ronda = ronda + 1;
								pokemonGeratuAurkariari = false;
							}
						}
					}
				}
				cls();
			}
			if((ronda==5|| ronda==10||ronda==15)&& ondoGoaz) {
				if(pertsonajea.getDirua()>=15) {
					System.out.println("zerbait erosi nahi duzu?");
					System.out.println("bai -> b");
					String erabaki = Teklatua.getNireTeklatua().irakurriString();
					if(erabaki.equals("b")){
						Mugimendu pMugi = Denda.getNireDenda().erosiMugimendu();
						if(pMugi != null) {
							gurePoke.mugimenduakImprimatu();
							System.out.println("zein mugimendu aldatu nahi duzu?");
							int aukera = Teklatua.getNireTeklatua().irakurriOsoa();
							gurePoke.getNireLista().aldatuMugimendu(pMugi, aukera);
						}
					}				
				}
				else {
					System.out.println("ez duzu diru nahikorik!!");
				}
			}
			if(ronda==10) {  //10. rondan pokemonei bizitza puntuak berreskuratzeko
				int a = 0;
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("Pokemon guztiak berreskuratu egin dira, berriro zure lehenengo pokemon-a aterako duzu!!");
				System.out.println("---------------------------------------------------------------------------------------");
				while(a<=2) {
					this.pertsonajea.getNireListaPokemon().getNireLista().get(a).BizitzaErrekuperatu(this.pertsonajea.getNireListaPokemon().getNireLista().get(a).getMaxBizitza());
					a++;
				}
				gureEkipo = pertsonajea.getNireListaPokemon().getIteradorea(); 
				gurePoke = gureEkipo.next();
			}
		}
		if(ondoGoaz) {
			File txt3= new File ("res/Irabazi.txt");
			irakurri(txt3);
			Teklatua.getNireTeklatua().irakurriEnter();
		}
		this.erreseteatu();
		pertsonajea = null;
	}
	private void erasoTurnoa(Pokemon p1,Pokemon p2,Mugimendu erabilitakoa,int tipo1,int tipo2,float pEraso,float pDefentsa) {//p1 eraso egiten duen pokemon-a eta p2 erasoa jasotzen duena. erabilitakoa, p1 erabilitako mugimendua 
		if(erabilitakoa instanceof MugimenduBerezia) {
			float booster = ((MugimenduBerezia) erabilitakoa).getBooster();
			String estadistika = ((MugimenduBerezia) erabilitakoa).getEstadistika();
			if(estadistika.equals("Atake")) {
				if(((MugimenduBerezia) erabilitakoa).getNiriDa()) {
					p1.setEraso(booster);
				}
				else {
					p2.setEraso(booster);
				}
			}
			else if (estadistika.equals("Defentsa")) {
				if(((MugimenduBerezia) erabilitakoa).getNiriDa()) {
					p1.setDefentsa(booster);
				}
				else {
					p2.setDefentsa(booster);
				}
			}
			else if (estadistika.equals("Abiadura")) {
				if(((MugimenduBerezia) erabilitakoa).getNiriDa()) {
					p1.setAbiadura(booster);
				}
				else {
					p2.setAbiadura(booster);
				}
			}
			else {
				p1.setBizitza(booster);
			}
		}
		else if(erabilitakoa instanceof ErasoMugimendua) {
			float erasoa = ((ErasoMugimendua) erabilitakoa).getPotentzia();
			int erasoTipoa = ((ErasoMugimendua)erabilitakoa).getTipoa();
			float efizientzia = TipoenTabla.getNireTipoenTabla().kalkulatuEfectibitatea(tipo1, tipo2); //bi pokemon tipoen 
			float mugimenduaEtaPokemonTipoBera =(float) 1.0;
			if(erasoTipoa == p1.getTipoa()) {
				mugimenduaEtaPokemonTipoBera = (float) 1.5; // erabilitako mugimendua pokemonaren berdina bada, eraso mina*1.5
				p2.erasoEgin(erasoa,efizientzia,pEraso,pDefentsa,mugimenduaEtaPokemonTipoBera);
			}
			else {
				p2.erasoEgin(erasoa,efizientzia,pEraso,pDefentsa,mugimenduaEtaPokemonTipoBera);
			}
		}
	}
	private void EntrenatzaileakSortu() {
		int zenbatPokemon  = 0;
		String pIzena = "juanjo";
		int pDirua = 5; //con la denda
		for(int i=1;i<=20;i++) {
			if(i%5 == 0) { //soilik 5-10-15-20 rondetako entrenatzaileei 3 pokemon esleitzeko 
					zenbatPokemon = 3;
			}
			else {
				zenbatPokemon = 1;
			}
			EntrenatzaileaBot unekoa = new EntrenatzaileaBot(pIzena,pDirua);
			unekoa.EkipoaSortu(zenbatPokemon); 
			lista.add(unekoa);
		}
	}
	
	private void pertsonajeaSortu() { // gure pertsonajearen ekipoa sortzeko, 3 pokemon-ekin
		int zenbatPokemon = 3;
		if(pertsonajea == null) {
			pertsonajea =  new EntrenatzaileaGuk(" ",10);
			pertsonajea.EkipoaSortu(zenbatPokemon);
		}
	}
	
	private Iterator<Entrenatzaile> getIteradorea() {
		return this.lista.iterator();
	}
	private void partidahasi(){
		do {
			cls();
			File txt= new File ("res/Hasiera.txt");
			irakurri(txt);
			System.out.println("Zer egin nahi duzu?");
			int sarrera=Teklatua.getNireTeklatua().irakurriAukera(1,4);
			switch(sarrera) {
			case 1:
				cls();
				System.out.println("Sartu zure izena");
				String izena=Teklatua.getNireTeklatua().irakurriString();
				ListaEntrenatzaile.getNireListaEntrenatzaile().EntrenatzaileakSortu();
				ListaEntrenatzaile.getNireListaEntrenatzaile().pertsonajeaSortu();
				pertsonajea.setIzena(izena);
				ListaEntrenatzaile.getNireListaEntrenatzaile().borrokatu();
				break;
			case 2:
				cls();
				File txt1= new File ("res/ARAUAK.txt");
				irakurri(txt1);
				Teklatua.getNireTeklatua().irakurriEnter();
				break;
			case 3:
				System.exit(0);
				break;
			}
		}while(true);
	}
	public static void main(String[] arg1) {
		//tipoen tabla sortzeko
		//tipo "0" = sua; tipo "1" = ura; tipo "2" = belarra; tipo "3" = normal; tipo "4" = fantasma
		//sua
		TipoenTabla.getNireTipoenTabla().setZenbakia(0, 0,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(0, 1,(float) 0.5);
		TipoenTabla.getNireTipoenTabla().setZenbakia(0, 2,(float) 2.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(0, 3,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(0, 4,(float) 1.0);
		//ura 
		TipoenTabla.getNireTipoenTabla().setZenbakia(1, 0,(float) 2.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(1, 1,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(1, 2,(float) 0.5);
		TipoenTabla.getNireTipoenTabla().setZenbakia(1, 3,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(1, 4,(float) 1.0);
		//belarra
		TipoenTabla.getNireTipoenTabla().setZenbakia(2, 0,(float) 0.5);
		TipoenTabla.getNireTipoenTabla().setZenbakia(2, 1,(float) 2.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(2, 2,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(2, 3,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(2, 4,(float) 1.0);
		//normal
		TipoenTabla.getNireTipoenTabla().setZenbakia(3, 0,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(3, 1,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(3, 2,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(3, 3,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(3, 4,(float) 0.2);
		//fantasma
		TipoenTabla.getNireTipoenTabla().setZenbakia(4, 0,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(4, 1,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(4, 2,(float) 1.0);
		TipoenTabla.getNireTipoenTabla().setZenbakia(4, 3,(float) 0.2);
		TipoenTabla.getNireTipoenTabla().setZenbakia(4, 4,(float) 2.0);
		//pokemon guztiak pòkedex-ean sartzeko
		Pokemon Venusaur = new Pokemon("Venusaur",1,270,152,148,153,0);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Venusaur);
		Pokemon Tangela = new Pokemon("Tangela",2,240,103,112,211,0); 
		Pokedex.getNirePokedex().getNirelista().addPokemon(Tangela);
		Pokemon Exeggutor = new Pokemon("Exeggutor",3,300,175,103,157,0);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Exeggutor);
		Pokemon Parasect = new Pokemon("Parasect",4,230,175,134,148,0);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Parasect);
		Pokemon Vileplume = new Pokemon("Vileplume",5,260,148,94,157,0);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Vileplume);
		Pokemon Blastoise = new Pokemon("Blastoise",6,268,153,144,184,1);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Blastoise);
		Pokemon Golduck = new Pokemon("Golduck",7,270,152,157,144,1);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Golduck);
		Pokemon Poliwrath = new Pokemon("Poliwrath",8,290,175,130,175,1);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Poliwrath);
		Pokemon Tentacruel = new Pokemon("Tentacruel",9,270,130,184,121,1);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Tentacruel);
		Pokemon Seadra = new Pokemon("Seadra",10,220,121,157,175,1);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Seadra);
		Pokemon Charizard = new Pokemon("Charizard",11,266,155,184,144,2);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Charizard);
		Pokemon Arcanine = new Pokemon("Arcanine",12,290,202,175,148,2);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Arcanine);
		Pokemon Magmar = new Pokemon("Magmar",13,240,175,171,107,2);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Magmar);
		Pokemon Ninetales = new Pokemon("Ninetales",14,256,141,184,139,2);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Ninetales);
		Pokemon Rapidash = new Pokemon("Rapidash",15,240,184,193,130,2);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Rapidash);
		Pokemon Snorlax = new Pokemon("Snorlax",16,430,202,58,121,3);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Snorlax);
		Pokemon Tauros = new Pokemon("Tauros",17,260,184,202,175,3);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Tauros);
		Pokemon Chansey = new Pokemon("Chansey",18,610,119,114,110,3);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Chansey);
		Pokemon Porygon = new Pokemon("Porygon",19,240,112,135,130,3);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Porygon);
		Pokemon Persian = new Pokemon("Persian",20,240,130,112,211,3);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Persian);
		Pokemon Gengar = new Pokemon("Gengar",21,230,121,112,202,4);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Gengar);
		Pokemon Alakazam = new Pokemon("Alakazam",22,220,160,220,145,4);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Alakazam);
		Pokemon Hypno = new Pokemon("Hypno",23,280,135,125,160,4);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Hypno);
		Pokemon MrMime = new Pokemon("MrMime",24,190,135,166,200,4);
		Pokedex.getNirePokedex().getNirelista().addPokemon(MrMime);
		Pokemon Weezing = new Pokemon("Weezing",25,240,166,112,220,4);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Weezing);
		Pokemon Zapdos = new Pokemon("Zapdos",26,290,166,184,157,0);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Zapdos);
		Pokemon Articuno = new Pokemon("Articuno",27,290,160,157,195,1);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Articuno);
		Pokemon Moltres = new Pokemon("Moltres",28,290,184,166,166,2);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Moltres);
		Pokemon Mew = new Pokemon("Mew",29,310,184,184,184,3);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Mew);
		Pokemon Mewtwo = new Pokemon("Mewtwo",30,322,202,238,166,4);
		Pokedex.getNirePokedex().getNirelista().addPokemon(Mewtwo);
		System.out.println("pokemonak kargatuta");
		//mugimendu guztiak mugimenduKolektzioan sartzeko
		ErasoMugimendua UrPistola = new ErasoMugimendua(2,"Ur Pistola (ura)",1,15,40);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(UrPistola);
		ErasoMugimendua Surf = new ErasoMugimendua(2,"Surf (ura)",2,15,90);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Surf);
		ErasoMugimendua BurbuilaIzpia = new ErasoMugimendua(2,"Burbuila Izpia (ura)",3,15,65);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(BurbuilaIzpia);
		ErasoMugimendua Kaskada = new ErasoMugimendua(2,"Kaskada (ura)",4,15,90);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Kaskada);
		ErasoMugimendua AquaJet = new ErasoMugimendua(2,"AquaJet (ura)",5,15,40);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(AquaJet);
		ErasoMugimendua Burbuila = new ErasoMugimendua(2,"Burbuila (ura)",6,15,40);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Burbuila);
		ErasoMugimendua Hidrokainoia = new ErasoMugimendua(2,"Hidrokanoia (ura)",7,15,110);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Hidrokainoia);
		ErasoMugimendua HostoErorera = new ErasoMugimendua(1,"Hosto Erorera (sua)",8,15,110);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(HostoErorera);
		ErasoMugimendua Zartada = new ErasoMugimendua(1,"Zartada (sua)",9,15,80);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Zartada);
		ErasoMugimendua Energibola = new ErasoMugimendua(1,"Energibola (sua)",10,15,75);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Energibola);
		ErasoMugimendua HostoMagikoa = new ErasoMugimendua(1,"Hosto Magikoa (sua)",11,15,60);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(HostoMagikoa);
		ErasoMugimendua LatigoZepa = new ErasoMugimendua(1,"Latigo Zepa (sua)",12,15,40);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(LatigoZepa);
		ErasoMugimendua TormentaFlorala = new ErasoMugimendua(1,"Tormenta Florala (sua)",13,15,80);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(TormentaFlorala);
		ErasoMugimendua Hostotza = new ErasoMugimendua(1,"Hostotza (sua) ",14,15,40);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Hostotza);
		ErasoMugimendua Askua = new ErasoMugimendua(3,"Askua (belarra)",15,15,40);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Askua);
		ErasoMugimendua Llamarada = new ErasoMugimendua(3,"Llamarada (belarra)",16,15,110);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Llamarada);
		ErasoMugimendua SuJaurtigailu = new ErasoMugimendua(3,"Lanzallamas (belarra)",17,15,90);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(SuJaurtigailu);
		ErasoMugimendua SuzkoUkabilkada = new ErasoMugimendua(3,"Su Ukabila (belarra)",18,15,75);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(SuzkoUkabilkada);
		ErasoMugimendua EnbiteIgneoa = new ErasoMugimendua(3,"Enbite  Igneo (belarra)",19,15,100);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(EnbiteIgneoa);
		ErasoMugimendua Eztanda = new ErasoMugimendua(3,"Eztanda (belarra)",20,15,110);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Eztanda);
		ErasoMugimendua SuGurpila = new ErasoMugimendua(3,"Su Gurpila (belarra)",21,15,60); 
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(SuGurpila);
		ErasoMugimendua Plakaia = new ErasoMugimendua(4,"Plakaia (normal)",22,15,40);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Plakaia);
		ErasoMugimendua Labankada = new ErasoMugimendua(4,"Labankada (normal)",23,15,90);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Labankada);
		ErasoMugimendua SasiZaplasteko = new ErasoMugimendua(4,"Sasi-Zaplasteko (normal)",24,15,35);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(SasiZaplasteko);
		ErasoMugimendua AtakeBizkorra = new ErasoMugimendua(4,"Atake Bizkorra (normal)",25,15,45);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(AtakeBizkorra);
		ErasoMugimendua AbiaduraMax = new ErasoMugimendua(4,"Abiadura Max (normal)",26,15,90);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(AbiaduraMax);
		ErasoMugimendua MinSekretua = new ErasoMugimendua(4,"Min Sekretua (normal)",27,15,70); 
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(MinSekretua);
		ErasoMugimendua Hiperizpia = new ErasoMugimendua(4,"Hiperizpia (normal)",28,15,120);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Hiperizpia);
		ErasoMugimendua ItzalUkabilkada = new ErasoMugimendua(5,"Itzal Ukabila (fantasma)",29,15,60);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(ItzalUkabilkada);
		ErasoMugimendua GarraItzaltsua = new ErasoMugimendua(5,"Garra Itzaltsua (fantasma)",30,15,90);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(GarraItzaltsua);
		ErasoMugimendua Psikikoa = new ErasoMugimendua(5,"Psikiko (fantasma)",31,15,60);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Psikikoa);
		ErasoMugimendua HaizeIluna = new ErasoMugimendua(5,"Haize Iluna (fantasma)",32,15,60);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(HaizeIluna);
		ErasoMugimendua Psikokarga = new ErasoMugimendua(5,"Psikokarga (fantasma)",33,15,80);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Psikokarga);
		ErasoMugimendua BonbaAzidoa = new ErasoMugimendua(5,"Bonba Azidoa (fantasma)",34,15,40);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(BonbaAzidoa);
		ErasoMugimendua BuztanPozoitsua = new ErasoMugimendua(5,"Buztan Pozoitsua (fantasma)",35,15,70);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(BuztanPozoitsua);
		MugimenduBerezia Errefuxioa = new MugimenduBerezia(2,"Errefuxioa (defentsa igo)",36,15,(float)1.15,"Defentsa",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Errefuxioa);
		MugimenduBerezia AkuaAro = new MugimenduBerezia(2,"Akua Aro (PS-ak berreskuratzen ditu)",37,15,(float)1.1,"BizitzaPuntuak",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(AkuaAro);
		MugimenduBerezia UrDantza = new MugimenduBerezia(2,"Ur Dantza (atakeek boost bat jaso)",38,15,(float)1.08,"Atake",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(UrDantza);
		MugimenduBerezia Kotoiespora = new MugimenduBerezia(1,"Kotoiespora (Abiadura kendu aurkariari)",39,15,(float)0.9,"Abiadura",false);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Kotoiespora);
		MugimenduBerezia EgunEguzkitsua = new MugimenduBerezia(3,"Egun Eguzkitsua (Atakea igo)",40,15,(float)1.15,"Atake",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(EgunEguzkitsua);
		MugimenduBerezia Latigo = new MugimenduBerezia(4,"Latigo (Defentsa jaitsi aurkariari)",41,15,(float)0.93,"Defentsa",false);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Latigo);
		MugimenduBerezia Kurrinka = new MugimenduBerezia(4,"Kurrinka (Atakea igo)",42,15,(float)1.07,"Atake",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Kurrinka);
		MugimenduBerezia Errekuperazioa = new MugimenduBerezia(4,"Errekuperazioa (PS totalen erdia errekuperatu)",43,15,(float)1.5,"BizitzaPuntuak",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Errekuperazioa);
		MugimenduBerezia DefentsaKizkurra = new MugimenduBerezia(4,"Defentsa Kizkurar (Defentsa igo)",44,15,(float)1.1,"Defentsa",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(DefentsaKizkurra);
		MugimenduBerezia Afilatu = new MugimenduBerezia(4,"Afilatu (Atakea igo)",45,15,(float)1.1,"Atake",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Afilatu);
		MugimenduBerezia EkipoBikotza = new MugimenduBerezia(4,"Ekipo Bikoitza (Abiadura igo)",46,15,(float)1.1,"Abiadura",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(EkipoBikotza);
		MugimenduBerezia SustoAurpegia = new MugimenduBerezia(4,"Susto Aurpegia (Abiadura jaitsi aurkariari)",47,15,(float)0.93,"Abiadura",false);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(SustoAurpegia);
		MugimenduBerezia MasaKosmikoa = new MugimenduBerezia(5,"Masa Kosmikoa (Defentsa igo)",48,15,(float)1.08,"Defentsa",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(MasaKosmikoa);
		MugimenduBerezia Barrera = new MugimenduBerezia(4,"Barrera (Defentsa igo)",49,15,(float)0.9,"Defentsa",false);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Barrera);
		MugimenduBerezia Agilitatea = new MugimenduBerezia(4,"Agilitatea (Abiadura igo)",50,15,(float)1.1,"Abiadura",true);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Agilitatea);
		MugimenduBerezia Kotoibira = new MugimenduBerezia(1,"Kotoi Bira (Defentsa igo)",51,15,(float)1.15,"Defentsa",true);//mirar las ip-s
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Kotoibira);
		MugimenduBerezia Indarxurga = new MugimenduBerezia(1,"Indarxurga (Atakea kendu aurkariari)",521,15,(float)0.91,"Atake",false);
		MugimenduKolekzioa.getNireMugimenduKolekzioa().getNireLista().addMugimendu(Indarxurga);
		System.out.println("mugimenduak kargatuta"); 
		ListaEntrenatzaile.getNireListaEntrenatzaile().partidahasi();
	}
	
	private static void cls(){
        /** 
         * FUNTZIOA: Pantailan dagoena garbituko du hurrengo loopean berriro marrazteko. 
         * ERABILPENA: Loop bakoitzean.
         * Input: --
         * OutPut: -- 
        */
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }catch(Exception E)
            {
            System.out.println(E);
            }
    }
	private static void irakurri(File txt){
		FileReader fr=null;
		BufferedReader br=null;
		
		try{
			fr= new FileReader(txt);
			br= new BufferedReader(fr);
			String lerroa;
			while((lerroa=br.readLine())!=null)
				System.out.println(lerroa);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}