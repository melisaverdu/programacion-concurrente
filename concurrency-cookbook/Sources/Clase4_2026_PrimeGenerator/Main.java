import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread task = new PrimeGenerator(); // creo un hilo que va a ejecutar la clase PrimeGenerator, se va a llamar task
		task.start(); // el start crea el hilo y lo larga a correr

		try {
			TimeUnit.SECONDS.sleep(2); // el hilo del main va a dormir 5 segundos
		} catch (InterruptedException e) { // lo que va a hacer en caso de que se interrumpa
			e.printStackTrace();
		}

		task.interrupt(); // interrumpo el hilo
		/*
		Cuando interrumpi el hilo, no es que lo mata, sino que le avise que se ha interrumpido.
		Por un tiempo el hilo siguio RUNNABLE, hasta que entro a la interrumpcion, y ahi si se interrumpio, el hilo 
		pasa a estar en estado TERMINATED.
		*/

		System.out.println("1 - " + task.getState()); // imprime el estado del hilo

		task.interrupt(); // interrumpo el hilo

		System.out.println("2 - " + task.getState()); // imprime el estado del hilo

		Thread.sleep(1000);

		System.out.println("3 - " + task.getState());	// TERMINATED

		//task.interrupt();

		 
	}

}

