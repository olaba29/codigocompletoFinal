package juegoVersionFinal;

public class DefentsaGehiegiException extends Exception{
	//Eraikitzaile
	public DefentsaGehiegiException() {
		super();
	}
	//gainontzeko metodoak
	public void mezuaInprimatu() {
		System.out.println("-----------------------------------------");
		System.out.println("pokemon-a defentsa indizea gehiegi igo du");
		System.out.println("-----------------------------------------");
	}
}
