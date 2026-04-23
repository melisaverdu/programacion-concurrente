public class MainPricesInfo {

	public static void main(String[] args) {
		PricesInfo pricesInfo = new PricesInfo(); // se instancia un objeto de la clase pricesInfo

		Reader readers[] = new Reader[5];
		Thread threadsReader[] = new Thread[5];

		for (int i = 0; i < 5; i++) {
			readers[i] = new Reader(pricesInfo); // creamos 5 readers y
			threadsReader[i] = new Thread(readers[i]);
		} 

		Writer writer = new Writer(pricesInfo);
		Thread threadWriter = new Thread(writer);

		for (int i = 0; i < 5; i++) {
			threadsReader[i].start(); // luego lanzamos los 5 readers
		} 
		threadWriter.start();
	}
}
