package juegoVersionFinal;
public class Pokedex {
	//atributuak
	private static Pokedex nPokedex = null;
	private ListaPokemon nListaPokemon;
	//eraikitzailea
	private Pokedex() {
		this.nListaPokemon = new ListaPokemon();
	}

	public static Pokedex getNirePokedex() {
		if(nPokedex == null) {
			nPokedex = new Pokedex();
		}
		return nPokedex;
	}
	//gainontzeko metodoak
	public ListaPokemon getNirelista() {
		return this.nListaPokemon;
	}
	public int listaLuzera() {
		return this.nListaPokemon.listarenLuzera();
	}
	
	public Pokemon sortuPokemon(int pokemonId) {
		return nListaPokemon.SortuPokemon(pokemonId);
	}
	public void erreseteatu() {
		nListaPokemon.getNireLista().clear();
	}
}