public class Job32 implements Runnable {

	private PrintQueue32 printQueue;

	public Job32(PrintQueue32 printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
	}
}
