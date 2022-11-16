package juegoVersionFinal;

public class ErasoGehiegiException extends Exception{
	//Eraikitzaile
	public ErasoGehiegiException() {
		super();
	}
	//gainontzeko metodoak
	public void mezuaInprimatu() {
		System.out.println("--------------------------------------");
		System.out.println("pokemon-a eraso indizea gehiegi igo du");
		System.out.println("--------------------------------------");
	}
}
