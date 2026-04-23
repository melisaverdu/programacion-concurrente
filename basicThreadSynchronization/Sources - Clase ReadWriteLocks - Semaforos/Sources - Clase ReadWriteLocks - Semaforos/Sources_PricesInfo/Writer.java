class Writer implements Runnable {

	private PricesInfo pricesInfo;

	public Writer(PricesInfo pricesInfo) {
		this.pricesInfo = pricesInfo;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.printf("%s: Writer: Attempt to modify the prices.\n", Thread.currentThread().getName());
			pricesInfo.setPrices(Math.random() * 10, Math.random() * 8); //modificar precios
			System.out.printf("%s: Writer: Prices have been modified.\n", Thread.currentThread().getName()); //volvemos a escribir 
			try {
				Thread.sleep(2); //duerme
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
