import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s\n", new Date());
			try {
				TimeUnit.SECONDS.sleep(1); // cuano interrumpo un hilo que esta en sleep, en ese preciso instante lo despierto en el moemnto en el que este.
			} catch (InterruptedException e) {
				System.out.printf("The FileClock has been interrupted\n");
				return; // el return lo mata y sale del método run, lo que hace que el hilo termine su ejecución
				//si el return no estuviera, el hilo seguiría ejecutándose y seguiría imprimiendo la fecha cada segundo, incluso después de haber sido interrumpido.
			}
			/*
			si en vez de hacer un try catch y solo quisiera poner el hilo a dormir -> no podría
			Porque el método sleep lanza una excepción, y si no la manejo, el código no compilaría. Por eso es necesario el try catch para manejar la posible 
			interrupción del hilo mientras está durmiendo.
			*/
		}
	}
}
