public class PrimeGenerator extends Thread { 
	
	@Override
	public void run() {
		long number = 1L; // creo un long con el valor 1
		
		while(true) { // mientras sea verdadero, lo cual sera siempre
			if(isPrime(number)) {  // si el numero es primo, imprimelo
				System.out.printf("Number % d is Prime\n", number);
			}
			
			if(isInterrupted()) { //pregunta si esta interrumpido
				System.out.println("PrimeGenerator state " + getState()); // imprime el estado del hilo actual
				System.out.println("The Prime Generator has been Interrupted\n");
				return;
			}

			//isInterrupted(); es un metodo de la clase Thread, y al extender de Thread, la clase PrimeGenerator hereda los metodos de la clase Thread.
			 
			
			number ++;
		}
	}
	
	private boolean isPrime(long number) {
		if(number <= 2) {
			return true;
		}
		
		for(long i = 2; i < number; i++) {
			if((number % i) == 0) {
				return false;
			}
		}
		
		return true;
	}
}

