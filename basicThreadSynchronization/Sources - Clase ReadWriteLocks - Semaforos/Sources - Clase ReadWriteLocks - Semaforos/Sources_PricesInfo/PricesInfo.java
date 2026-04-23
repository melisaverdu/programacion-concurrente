import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {

	private double price1;
	private double price2;

	private ReadWriteLock lock; // para lectura y escritura

	public PricesInfo() { // con el constructor se inicializan las variables
		price1 = 1.0;
		price2 = 2.0;
		
		lock = new ReentrantReadWriteLock(); // lo inicislizo como ReentrantReadWriteLock
	}
	
	public double getPrice1() {
		lock.readLock().lock(); // para leer
		
		//try {
		//	Thread.sleep(100);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		double value = price1; // lo asigno a value una vez que pude sacar el lock

		lock.readLock().unlock(); // para dejar de leer
		
		return value;
	}
	
	public double getPrice2() {
		lock.readLock().lock(); 
		/*
		Por ejemplo, viene el hilo 0 a querer leer el precio 2.
		El hilo 0 entra en el bloqueo de lectura con la linea lock.readLock().lock();
		El hilo 0 lee el precio 2 y sale del bloqueo de lectura con la linea lock.readLock().unlock();

		En el caso en el que el hilo 1  entra a querer escribir el precio 2, justo cuando estamos leyendolo en la
		linea double value = price2; lo bloqueamos con la linea lock.readLock().lock(); y le decimos, quedate en 
		esperando hasta que el hilo 0 deje de leer el precio 2 con la linea lock.readLock().unlock();
		Una vez que termino de leer el precio 2 el hilo 1 entra y lo escribe.
		 
		------------------------------------------------------------------------------------------------------------

		Esto es un ejemplo como si fueran dos hilos, uno leyendo y el otro escribiendo, pero pueden darse multiples lecturas
		y multiples escrituras. Hasta que todos los hilos que estan leyendo, no terminan de ler, no entra ningun escritor y 
		viceversa.
		*/
		
		//try {
		//	Thread.sleep(100);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		double value = price2;

		lock.readLock().unlock();
		
		return value;
	}
	
	public void setPrices(double price1, double price2) {
		lock.writeLock().lock(); // para escribir
		//try {
		//	Thread.sleep(2 * 1000);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		
		this.price1 = price1; // lo actualizo
		this.price2 = price2;
		
		lock.writeLock().unlock(); // para dejar de escribir
	}
}
