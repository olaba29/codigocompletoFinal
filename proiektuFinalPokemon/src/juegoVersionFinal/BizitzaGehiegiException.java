package juegoVersionFinal;

public class BizitzaGehiegiException extends Exception{
	//Eraikitzaile
	public BizitzaGehiegiException() {
		super();
	}
	//gainontzeko metodoak
	public void mezuaInprimatu() {
		System.out.println("-----------------------------------------");
		System.out.println("pokemon-a bizitza gehiegi errekuperatu du");
		System.out.println("-----------------------------------------");
	}
}
