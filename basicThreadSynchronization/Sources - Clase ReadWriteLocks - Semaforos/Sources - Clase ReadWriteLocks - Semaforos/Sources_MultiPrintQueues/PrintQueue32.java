import java.text.SimpleDateFormat;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue32 {

	private Semaphore semaphore;

	private boolean freePrinters[]; // arreglo de booleanos para saber qué impresoras están libres, si el valor es true, la impresora está libre, si es false, la impresora está ocupada

	private Lock lockPrinters; // lock para proteger el acceso al arreglo de booleanos, para que no haya dos hilos que accedan al mismo tiempo y puedan asignar la misma impresora a dos hilos diferentes

	public PrintQueue32() {
		semaphore = new Semaphore(3); // va a ser un semáforo de tres permisos 
		freePrinters = new boolean[3];
		for (int i = 0; i < 3; i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}

	public void printJob(Object document) {
		String name = Thread.currentThread().getName();
		try {
			semaphore.acquire(); // voy a pasar 3 veces por aca y voy a decrementar en 1 el semáforo cada vez, 
			// 						entonces solo van a poder pasar 3 hilos al mismo tiempo, el resto va a tener que 
			//                      esperar a que alguno de los 3 hilos que están adentro termine y libere el semáforo para poder entrar

			int assignedPrinter = getPrinter();

			Long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", name,
					assignedPrinter, duration);
			TimeUnit.SECONDS.sleep(duration);

			freePrinters[assignedPrinter] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private int getPrinter() {
		int ret = -1;

		try {
			lockPrinters.lock(); // al momento de elegir una impresora libre, bloqueo el acceso al arreglo de booleanos para que ningún 
			// 						otro hilo pueda acceder a él hasta que yo termine de elegir la impresora y marcarla como ocupada

			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}

		return ret;
	}
}
