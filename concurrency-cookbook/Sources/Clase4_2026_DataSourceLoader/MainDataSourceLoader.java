import java.util.Date;

/**
 * Main class of the Example. Create and start two initialization tasks
 * and wait for their finish
 *
 */
public class MainDataSourceLoader {

	/**
	 * Main method of the class. Create and star two initialization tasks
	 * and wait for their finish
	 * @param args
	 */
	public static void main(String[] args) {

		// Creates and starts a DataSourceLoader runnable object
		DataSourcesLoader dsLoader = new DataSourcesLoader();
		Thread thread1 = new Thread(dsLoader,"DataSourceThread");

		// Creates and starts a NetworkConnectionsLoader runnable object
		NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");

		// Start both threads
		thread1.start(); // duerme 4 seg
		thread2.start(); // duerme 9 seg

		// Wait for the finalization of the two threads
		/*
		DATITA A SUBRAYAR 
		utilizo try catch y no un try finally porque si me voy al metodo join() y veo de que se trata,
		el mismo me lanza una excepcion y me tira un error.
		*/
		try {
			thread1.join();
			//thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*
		Si comento la linea thread1.join() andaria igual que si no estuviera comentada, porque es el hilo
		de 4 segundos, menos que el de 9segundos, por ende mientras el hilo 9seg tarda, el de 4seg tarda
		y cuando acaba el de 9seg, el de 4seg acaba.
		*/
		/*
		Si comento la linea de thread2.join(), el hilo de 9s no me va a interesar, no lo voy a esperar.
		Se imprime el main luego de la finalizacion de el de 4seg., el de 9seg siguio corriendo y despues se acabo.
		*/
		// Waits a message
		System.out.printf("Main: Configurations has been loaded: %s\n",new Date());
	}
}
