package ejercicio2;



public class Main2 {

	public static void main(String[] args) {
		Cliente2 clientes[]=new Cliente2[12];
		LineaCajas lineaCajas= new LineaCajas();
		
		for (int i = 0; i < clientes.length; i++) {
			clientes[i]=new Cliente2(lineaCajas, "Cliente"+i);
			clientes[i].start();
		}
		for (int i = 0; i < clientes.length; i++) {
			try {
				clientes[i].join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		System.out.println("Jornada finalizada. Total ganacias "+lineaCajas.getBeneficios());
		
	}

}
