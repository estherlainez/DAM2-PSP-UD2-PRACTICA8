package ejercicio1;

import java.util.Random;

public class Main1 {

	public static void main(String[] args) {
		Caja cajas[]= new Caja[6];
		Cliente clientes[]=new Cliente[12];
		
		for(int i=0;i<cajas.length;i++) {
			cajas[i]= new Caja(i);
		}
		
		for (int i = 0; i < clientes.length; i++) {
			clientes[i]= new Cliente(cajas[new Random().nextInt(5)], "Cliente_"+i);
			clientes[i].start();
		}
		for (int i = 0; i < clientes.length; i++)
			try {
				clientes[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		double ganacias=0;
		for (int i = 0; i < cajas.length; i++) {
			ganacias+=cajas[i].getRecaudacion();
		}
		
		System.out.println("Jornada finalizada. Total ganacias "+ganacias);
	}

}
