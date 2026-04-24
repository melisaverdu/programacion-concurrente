package com.packtpub.java9.concurrency.cookbook.chapter01.recipe08.main;

import java.util.concurrent.TimeUnit;

import com.packtpub.java9.concurrency.cookbook.chapter01.recipe08.task.SafeTask;

public class SafeMain {

	public static void main(String[] args) {
		// Creates a task
		SafeTask task = new SafeTask();

		// Creates and start three Thread objects for that Task
		for (int i = 0; i < 2 * Runtime.getRuntime().availableProcessors(); i++) {
			Thread thread = new Thread(task);
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			thread.start();
		}
	}
}
