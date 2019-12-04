package ejercicio3;

import java.util.Random;

public class Conductor extends Thread {

	private Parking parking;

	public Conductor(Parking parking, String name) {
		this.parking=parking;
		this.setName(name);

	}

	@Override
	public void run() {
		while(true) {
			System.out.println(this.getName()+ " esta buscando aparcamiento");
			try {
				sleep(new Random().nextInt(1500));
				this.parking.aparcar(getName());
				sleep(new Random().nextInt(1500));
				this.parking.salir(this.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
