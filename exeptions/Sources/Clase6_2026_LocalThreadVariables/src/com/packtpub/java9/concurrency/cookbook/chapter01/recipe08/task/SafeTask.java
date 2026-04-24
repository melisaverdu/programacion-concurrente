package com.packtpub.java9.concurrency.cookbook.chapter01.recipe08.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {

	//private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
	//	protected Date initialValue() {
	//		return new Date();
	//	}
	//};

	private static final ThreadLocal<Date> startDate = ThreadLocal.withInitial(Date::new);

	@Override
	public void run() {
		// Writes the start date
		System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Writes the start date
		System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
	}

}
