package ejercicio3;

public class Parking {
	
	private int numPlazasOcupadas;
	public Parking() {
		this.numPlazasOcupadas=0;
	}
	
	public synchronized void aparcar(String name) {
		while(this.numPlazasOcupadas>=10) {
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		this.numPlazasOcupadas++;
		System.out.println(name+ " ha aparcado su vehiculo");
		System.out.println("------------ PLAZAS: "+this.numPlazasOcupadas+"---------------");
		
	}
	
	public synchronized void salir(String name) {
		System.out.println(name+ " ha sacado su vehiculo");
		this.numPlazasOcupadas--;
		System.out.println("------------ PLAZAS: "+this.numPlazasOcupadas+"---------------");
		notifyAll();
	}

}
