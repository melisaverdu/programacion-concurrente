package com.packtpub.java9.concurrency.cookbook.chapter01.recipe08.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {

	private Date startDate;
	/*
		Los hilos empiezan a imprimir fechas distintas porque cada hilo tiene su propia variable startDate,
		la cual se corrompe cada vez que un hilo la modifica.

		Para esto creamos la clase SafeTask que es igual a esta (ver la clase)
	*/

	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
	}
}
