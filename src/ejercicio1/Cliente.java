package ejercicio1;

import java.util.Random;

public class Cliente extends Thread{

	private Caja caja;
	
	public Cliente(Caja caja, String name) {
		this.caja=caja;
		this.setName(name);
	}
	
	
	@Override
	public void run() {
	
		System.out.println("El cliente "+ this.getName()+" ha entrado al super");
		try {
			sleep(new Random().nextInt(1500));
			this.caja.pagar(getName(), new Random().nextDouble()*200.0);
			sleep(new Random().nextInt(1500));
			this.caja.saliendoDeCaja(getName());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
