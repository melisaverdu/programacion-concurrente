public class MainMultiSemPrintQueue {

	public static void main(String args[]) {

		PrintQueue32 printQueue = new PrintQueue32();

		Thread thread[] = new Thread[12];
		for (int i = 0; i < 12; i++) {
			thread[i] = new Thread(new Job32(printQueue), "Thread " + i);
		}

		for (int i = 0; i < 12; i++) {
			thread[i].start();
		}
	}

}
