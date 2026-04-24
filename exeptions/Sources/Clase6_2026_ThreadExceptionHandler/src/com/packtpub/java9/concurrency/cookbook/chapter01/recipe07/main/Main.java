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
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		//Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread has finished\n");
	}
}
