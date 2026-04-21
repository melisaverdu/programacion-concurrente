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
				return;
			}
			
		}
	}
}
