package com.packtpub.java9.concurrency.cookbook.chapter04.recipe01.task;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

	private final ThreadPoolExecutor executor;

	public Server(){
		// Create the executor
		System.out.println("######### Available processors: " + Runtime.getRuntime().availableProcessors());
		/*
		En el constructor creo un executor de tipo (ThreadPoolExecutor) ¿como accedo a éste?
		La clase Executors de Java me ofrece un método estático newFixedThreadPool, que me recible un parámetro
		que es la cantidad de hilos que yo quiero que el método tenga, va a ser fijo, y en este caso es 
		la cantidad de procesadores disponible que tiene el profe
		*/
		executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		// Create the controller que rechaza las tareas
		RejectedTaskController controller=new RejectedTaskController();
		//// Establish the rejected task controller
		executor.setRejectedExecutionHandler(controller); //cuando el executor rechaza esa tarea va a hacer saltar ese controlador que configuramos
	}

	public void executeTask(Task task){
		System.out.printf("Server: A new task has arrived\n");
		executor.execute(task); //uso el executer para ejecutar la tarea. No creo hilos, nada, aca se encapsulo completamente la creación de hilos
		System.out.printf("Server: Pool Size: %d\n",executor.getPoolSize());
		System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
		System.out.printf("Server: Task Count: %d\n",executor.getTaskCount());
		System.out.printf("Server: Completed Tasks: %d\n",executor.getCompletedTaskCount());
	}

	public void endServer() {
		executor.shutdown();
	}

	public void printStatus() {
		System.out.println("###### Terminated: " + executor.isTerminated());
	}

}
