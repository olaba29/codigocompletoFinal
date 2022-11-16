package juegoVersionFinal;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPokemon {
	//atributuak
	private ArrayList<Pokemon> lista;
	//eraikitzailea
	public ListaPokemon() {
		this.lista = new ArrayList<Pokemon>();
	}
	//gainontzeko metodoak
	public ArrayList<Pokemon> getNireLista(){
		return this.lista;
	}
	public int listarenLuzera() {
		return this.lista.size();
	}
	public void addPokemon(Pokemon pPoke) {
		this.lista.add(pPoke);
	}

	public void removePokemon(Pokemon pPoke) {
		this.lista.remove(pPoke);
	}
	
	public Pokemon bilatuPokemonIdz(int pokemonId) { // aleatorioki esleitutako pokemon-a pokedex-an bilatzeko metodoa
		Pokemon emaitza = null;
		boolean aurkitua = false;
		Iterator<Pokemon> itr = this.getIteradorea();
		while(itr.hasNext() &&!aurkitua){
			emaitza = itr.next();
			if(emaitza.idBerdinaDu(pokemonId)) {
				aurkitua = true;
			}
		}
		return emaitza;
	}
	
	public Pokemon SortuPokemon(int pokemonId) {
		Pokemon nahiDuguna = this.bilatuPokemonIdz(pokemonId); //aleatorioki erabakitako pokemon-a pokedex osoan bilatzean, bariable horretan gordetzeko
		nahiDuguna.MugimenduakEsleitu(); // aurkitu dugun pokemon-ari mugimenduak esleitzeko
		return nahiDuguna;
	}

	public Iterator<Pokemon> getIteradorea() {
		return lista.iterator();
	}
	
	public void imprimatuPokemon() {
		Iterator<Pokemon> itr = this.getIteradorea();
		while(itr.hasNext()) {
			Pokemon unekoa = itr.next();
			System.out.println("Pokemonaren izena: " + unekoa.getIzena());
			System.out.println(unekoa.getNireLista().listarenLuzera());
			unekoa.getNireLista().mugimenduakInprimatu();
		}
	}
	public void erreseteatu() {
		this.lista.clear();
	}
}