import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		FileSearch searcher = new FileSearch("/Users/mauriludemann/Documents", "log");
		Thread thread = new Thread(searcher);
		thread.start();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread.interrupt();
	}

}

