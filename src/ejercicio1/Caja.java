package ejercicio1;

public class Caja {

	private boolean ocupada;
	private double recaudacion;
	private int numCaja;
	public Caja(int numCaja) {
		this.numCaja=numCaja;
		this.ocupada=false;
		this.recaudacion=0;
	}
	
	
	public synchronized void pagar(String name, double d) {
		while(this.ocupada) {
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		ocupada=true;
		System.out.println("El cliente "+name+" esta pagando en la caja "+this.numCaja);
		this.recaudacion+=d;
		
	}
	
	public synchronized void saliendoDeCaja(String name) {
		System.out.println("El cliente "+name+" esta saliendo de la caja "+this.numCaja);
		this.ocupada=false;
		notify();
	}


	public double getRecaudacion() {
		return recaudacion;
	}
	
	public boolean isOcupada(){
		return this.ocupada;
	}
}
