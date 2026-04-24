public class MainFairPrintQueue {
	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();

		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread " + i); //instancio 10 hilos 
		}

		for (int i = 0; i < 10; i++) {
			thread[i].start(); // lanzo los 10 hilos (de a uno)
			try {
				Thread.sleep(100); // cada vez que lanzo uno, lo mando a dormir por 100 milisegundos para que no se lancen 
								// todos al mismo tiempo y así se pueda ver mejor el orden de acceso al recurso compartido (PrintQueue)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
