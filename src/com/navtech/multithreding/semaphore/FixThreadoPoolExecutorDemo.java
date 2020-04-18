package com.navtech.multithreding.semaphore;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixThreadoPoolExecutorDemo {

	public static void main(String[] args) {

		// Create the instance of the Printing Queue
		PrintingQueue taskQueue = new PrintingQueue();

		// FixedThreadPool Executor To Perform the Thread Execution
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
		
		// Used to Perform the 10 new Task By 4 Shared Threads From Thread Pool
		for (int i = 0; i < 10; i++) {
			executor.submit(new PrintingJob(taskQueue));
		}

	}

}
