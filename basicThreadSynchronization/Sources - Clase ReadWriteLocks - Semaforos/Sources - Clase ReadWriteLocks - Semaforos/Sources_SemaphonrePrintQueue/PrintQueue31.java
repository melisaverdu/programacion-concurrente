import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintQueue31 {
	private final Semaphore semaphore;

	public PrintQueue31() {
		semaphore = new Semaphore(1);
	}

	public void printJob(Object document) {
		String name = Thread.currentThread().getName();
		try {
			semaphore.acquire();

			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", name, duration);

			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			semaphore.release();
		}
	}
}
