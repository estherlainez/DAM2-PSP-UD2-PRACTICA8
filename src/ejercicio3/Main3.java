package ejercicio3;

public class Main3 {

	public static void main(String[] args) {
		Parking parking=new Parking();
		Conductor cond[]= new Conductor[20];
		for (int i = 0; i < cond.length; i++) {
			cond[i]=new Conductor(parking, "Conductor_"+i);
			cond[i].start();
		}
	

	}

}
