package com.packtpub.java9.concurrency.cookbook.chapter01.recipe10.task;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	@Override
	public void run() {
		// No sabe cuantos hilos hay ejecutando. Tampoco le importa
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Termine de ejecutarme " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
