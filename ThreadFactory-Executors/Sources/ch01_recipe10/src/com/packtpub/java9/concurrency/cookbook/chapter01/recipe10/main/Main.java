package com.packtpub.java9.concurrency.cookbook.chapter01.recipe10.main;
import com.packtpub.java9.concurrency.cookbook.chapter01.recipe10.factory.MyThreadFactory;
import com.packtpub.java9.concurrency.cookbook.chapter01.recipe10.task.Task;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// Creates the factory
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		// Creates a task
		Task task = new Task();

		// Creates and starts ten Thread objects
		System.out.printf("Starting the Threads\n");
		for (int i = 0; i < 10; i++) {
			Thread thread = factory.newThread(task); 
			thread.start();
		}
		// Prints the statistics of the ThreadFactory to the console
		System.out.printf("Factory stats:\n");
		List<String> stats = factory.getStats();
		stats.forEach(System.out::println);
	}
}
