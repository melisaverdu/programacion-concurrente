public class MainSemPrintQueue {
	public static void main(String[] args) {
		PrintQueue31 printQueue = new PrintQueue31();

		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job31(printQueue), "Thread " + i);
		}

		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
	}
}
