package juegoVersionFinal;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaMugimenduak {
	//atributuak
	private ArrayList<Mugimendu> listaMugimendu;
	//eraikitzailea
	public ListaMugimenduak() {
		this.listaMugimendu = new ArrayList<Mugimendu>();
	}
	//gainontzeko metodoak
	public ArrayList<Mugimendu> getNireLista(){
		return this.listaMugimendu;
	}
	public int listarenLuzera() {
		return this.listaMugimendu.size();
	}
	public void addMugimendu(Mugimendu pMugi) {
		this.listaMugimendu.add(pMugi);
	}

	public void removeMugimendu(Mugimendu pMugi) {
		this.listaMugimendu.remove(pMugi);
	}

	public Mugimendu bilatuMugimenduIdz(int mugimenduId) {
		Mugimendu emaitza = null;
		boolean aurkitua = false;
		Iterator<Mugimendu> itr = this.getIteradorea();
		while(itr.hasNext() &&!aurkitua){
			Mugimendu unekoa = itr.next();
			if(unekoa.idBerdinaDu(mugimenduId)) {
				aurkitua = true;
				emaitza = unekoa;
			}
		}
		return emaitza;
	}
	public void aldatuMugimendu(Mugimendu pMugi,int pNum){
		this.listaMugimendu.set(pNum- 1, pMugi);
	} 
	public Mugimendu hartuXPosiziokoMugimendua(int pPosizio) {
		return this.getNireLista().get(pPosizio-1);
	}
	public Iterator<Mugimendu> getIteradorea() {
		return this.listaMugimendu.iterator();
	}
	public void mugimenduakInprimatu() {
		for (int i = 0;i<listaMugimendu.size();i++) {
			System.out.println(this.listaMugimendu.get(i).getDeskripzioa());
		}
	}
	public void erreseteatu() {
		this.listaMugimendu.clear();
	}
}