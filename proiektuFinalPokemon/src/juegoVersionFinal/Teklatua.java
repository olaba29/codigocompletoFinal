package juegoVersionFinal;

import java.util.Scanner;



public class Teklatua {
	//atributuak
	private Scanner sc;
	private static Teklatua nireTeklatua=null;
	

	//eraikitzailea(k)
	private Teklatua() {
		this.sc=new Scanner(System.in);
	}

	//gainontzeko metodoak
	public static Teklatua getNireTeklatua() {
		if (nireTeklatua==null) {
			nireTeklatua=new Teklatua();
		}
		return nireTeklatua;
	}
	
	public int irakurriOsoa() {
		String zenb=this.irakurriString(); 
		boolean egokia=false;
		do {
			if (zenb.isEmpty()) {
				zenb=this.irakurriString();
			}
			else {
				try {
					Integer num = Integer.parseInt(zenb);
					if(num > 4) {
						throw new NumberFormatException();
					}
					egokia=true;
				}
				catch (NumberFormatException e) {
					System.out.println("Bakarrik zenbaki osoak onartzen dira eta 1-4 tartean.");
					zenb=this.irakurriString();
				}
			}
		} while (!egokia);
		return Integer.parseInt(zenb);
	}
	
	public String irakurriString() {
		String mezua=this.sc.nextLine();
		return mezua;
	}
	
	public void irakurriEnter() {
		System.out.println("Sakatu enter jarraitzeko");
		this.sc.nextLine();
	}
	public int irakurriAukera(int pNondik, int pNora) {
		boolean denaOndo=false;
		int emaitza=(pNondik-1);
		do {
			String str=sc.nextLine();
			try {
				emaitza=Integer.parseInt(str);
				if(emaitza<pNondik||emaitza>pNora) {
					throw new HasieranAukeraOkerraSalbuespena();
				}
				denaOndo=true;
			}
			catch(NumberFormatException e) {
				System.out.println("Sarrera zenbaki bat izan behar da");
			}
			catch(HasieranAukeraOkerraSalbuespena e) {
				e.inprimatuMezua();
			}
		}while(!denaOndo);
		return emaitza;
	}
}