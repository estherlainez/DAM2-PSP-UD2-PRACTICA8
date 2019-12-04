package ejercicio2;
import ejercicio1.Caja;
import java.util.Random;

public class Cliente2 extends Thread{

	private Caja caja;
	private LineaCajas lineaCajas;
	public Cliente2(LineaCajas lineaCajas, String name) {
		this.lineaCajas=lineaCajas;
		this.setName(name);
	}
	
	
	@Override
	public void run() {
	
		System.out.println("El cliente "+ this.getName()+" ha entrado al super");
		try {
			sleep(new Random().nextInt(1500));
			this.caja=this.lineaCajas.getFreeCaja();
			this.caja.pagar(getName(), new Random().nextDouble()*200.0);
			sleep(new Random().nextInt(1500));
			this.caja.saliendoDeCaja(getName());
			this.lineaCajas.nextClient();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
