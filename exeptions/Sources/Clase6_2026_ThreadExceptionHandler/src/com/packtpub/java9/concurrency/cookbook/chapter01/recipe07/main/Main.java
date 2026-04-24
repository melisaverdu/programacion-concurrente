package com.packtpub.java9.concurrency.cookbook.chapter01.recipe07.main;
import com.packtpub.java9.concurrency.cookbook.chapter01.recipe07.handler.ExceptionHandler;
import com.packtpub.java9.concurrency.cookbook.chapter01.recipe07.task.Task;
public class Main {

	/**
	 * Main method of the example. Initialize a Thread to process the uncaught
	 * exceptions and starts a Task object that always throws an exception
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		//thread.setUncaughtExceptionHandler(new ExceptionHandler()); // a este hilo puntual, le asigno un manejador de excepciones 
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		/*
			El método anterior setDefaultUncaughtExceptionHandler, asigna un manejador de excepciones a todos los hilos que no 
			tengan un manejador de excepciones asignado. Utiliza el método estático de la clase Thread, por lo cual no es necesario 
			crear un hilo para asignarle el manejador de excepciones, sino que se asigna a todos los hilos.

			El funcionamiento no cambia nada con setUncaughtExceptionHandler, sigue imprimiendo lo mismo.
			-setUncaughtExceptionHndler, asigna un manejador de exepciones  al hilo que se le asigna, los demas van a explotar
			-setDefaultUncaugthExceptionHandler, lo aplica una vez, y es para TODOS los hilos.
		*/
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread has finished\n");
	}
}
