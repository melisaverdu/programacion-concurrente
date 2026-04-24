public class Job implements Runnable {

	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue; // se va a instanciar 
	}

	@Override
	public void run() {
		System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
		printQueue.printJob(new Object()); // va a acceder al método printJob con un new Objet 
		System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
	}

}
