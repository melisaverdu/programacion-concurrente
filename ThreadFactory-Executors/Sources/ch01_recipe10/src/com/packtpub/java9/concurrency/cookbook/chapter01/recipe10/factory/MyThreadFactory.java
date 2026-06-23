package com.packtpub.java9.concurrency.cookbook.chapter01.recipe10.factory;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	//MyThreadFactory es una clase mía pero que implementa la interfaz ThreadFactory que nos brinda Java

	// Attributes to save the necessary data to the factory
	private int counter;
	private String name;
	private List<String> stats;

	public MyThreadFactory(String name) {
		counter = 0;
		this.name = name;
		stats = new ArrayList<String>();
	}

	//al implementar la interfaz sobreescribimos el runnable
	@Override
	public Thread newThread(Runnable r) {
		// Create the new Thread object
		Thread t = new Thread(r, name + "-Thread_" + counter);
		counter++;
		// Actualize the statistics of the factory
		stats.add(String.format("Created thread %d with name %s on %s. Counter: %d", t.getId(), t.getName(), new Date(), counter));
		return t;
	}

	public List<String> getStats() {
		return stats;
	}
}