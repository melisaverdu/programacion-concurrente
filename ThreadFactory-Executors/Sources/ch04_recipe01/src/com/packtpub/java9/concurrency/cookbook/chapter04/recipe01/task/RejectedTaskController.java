package com.packtpub.java9.concurrency.cookbook.chapter04.recipe01.task;

import java.util.Arrays;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * This class implements the handler for the rejected tasks. Implements
 * the RejectedExecutionHandler interface and will be called for each task
 * sent to an executor after it was finished using the shutdown() method 
 *
 */
public class RejectedTaskController implements  RejectedExecutionHandler{
	/*RejectedTaskController es un controlador que yo creo para ejecutar cuando una tarea no 
	pueda ser aceptada, en cierto momento el excecuter no recibe mas tareas, explota, te da un error, 
	ese error puede ser un error controlado o un error controlado como lo que esta debajo, que se utiliza
	en el server.
	*/
	/**
	 * Method that will be executed for each rejected task
	 * @param r Task that has been rejected
	 * @param executor Executor that has rejected the task
	 */
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.printf("RejectedTaskController: The task %s has been rejected\n",r.toString());
		System.out.printf("RejectedTaskController: %s\n",executor.toString());
		System.out.printf("RejectedTaskController: Terminating: %s\n",executor.isTerminating());
		System.out.printf("RejectedTaksController: Terminated: %s\n",executor.isTerminated());
	}

}
