package com.packtpub.java9.concurrency.cookbook.chapter01.recipe08.main;

import java.util.concurrent.TimeUnit;

import com.packtpub.java9.concurrency.cookbook.chapter01.recipe08.task.UnsafeTask;

public class Main {

	public static void main(String[] args) {
		// Creates the unsafe task
		UnsafeTask task = new UnsafeTask(); // instancia un solo objeto tipo task
											// a cada uno de los 10 hilos que creo, le pasa la misam tarea.
		// Throw ten Thread objects
		for (int i = 0; i < 10; i++) { // creo un hilo, lo inicio (10 hilos)
			Thread thread = new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2); //separados con 2seg cada unos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
