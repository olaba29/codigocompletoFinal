package juegoVersionFinal;

public class AbiaduraGehiegiException extends  Exception{
	//Eraikitzaile
	public AbiaduraGehiegiException() {
		super();
	}
	//gainontzeko metodoak
	public void mezuaInprimatu() {
		System.out.println("-----------------------------------------");
		System.out.println("pokemon-a abiadura indizea gehiegi igo du");
		System.out.println("-----------------------------------------");
	}
}
