import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private final Lock queueLock = new ReentrantLock(true); 
	/*con esto se respeta el orden de acceso al recurso compartido (PrintQueue), es decir, el hilo que lleva más tiempo esperando es el próximo
	 en acceder al recurso. Si se le pasa false, el orden de acceso al recurso no es justo, es decir, puede ser que un hilo que acaba de llegar 
	 acceda al recurso antes que otro hilo que lleva más tiempo esperando.
	*/
	//private final Lock queueLock = new ReentrantLock(false);
	/*
	si le paso un false al constructor de ReentrantLock, el orden de acceso al recurso no es justo, es decir, puede ser que un hilo que acaba de llegar
	acceda al recurso antes que otro hilo que lleva más tiempo esperando. 
	*/

	public void printJob(Object document) {
		queueLock.lock(); 
		/*
		se bloquea el recurso para que no lo pueda usar otro hilo, se le pasa true
		para que sea justo, es decir, que el hilo que lleva más tiempo esperando sea 
		el próximo en acceder al recurso. Si se le pasa false, el orden de acceso al 
		recurso no es justo, es decir, puede ser que un hilo que acaba de llegar 
		acceda al recurso antes que otro hilo que lleva más tiempo esperando.
		*/ 

		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds in first code block\n", Thread.currentThread().getName(),
					(duration / 1000));
			Thread.sleep(duration); // duermo
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock(); // se desbloquea el recurso para que otro hilo pueda acceder a él
		}

		queueLock.lock();
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds in second code block\n", Thread.currentThread().getName(),
					(duration / 1000));
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}
	}

}
