package ejercicio2;

import java.util.concurrent.Semaphore;

import ejercicio1.Caja;


public class LineaCajas {
	private Caja cajas[]=null;
	
	private Semaphore semCajas;
	public LineaCajas() {
		this.cajas= new Caja[6];
		for(int i=0;i<cajas.length;i++) {
			cajas[i]= new Caja(i);
		}
		
		semCajas= new Semaphore(cajas.length);
		
		
	}
	
	public Caja getFreeCaja() {
		try {
			semCajas.acquire();
			for (int i = 0; i < cajas.length; i++) {
				if(!cajas[i].isOcupada()) {
					return cajas[i];
				}
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void nextClient() {
		semCajas.release();
	}
	
	public double getBeneficios() {
		double bene=0;
		for (int i = 0; i < cajas.length; i++) {
			bene=cajas[i].getRecaudacion();
		}
		return bene;
	}
	
	
	
}
