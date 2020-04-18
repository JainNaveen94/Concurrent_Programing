package com.navtech.multithreding.semaphore;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {

	public static void main(String[] args) {

		// Create the instance of the Printing Queue
		PrintingQueue taskQueue = new PrintingQueue();
		
		// Creating the Task of Printing Job
		PrintingJob print = new PrintingJob(taskQueue);

		// SingleThreadPool Executor To Perform the Thread Execution
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(3);
		
		// Scheduled The same Task to Perform by 3 thread in every 2 Seconds
		executor.scheduleWithFixedDelay(print, 1, 1, TimeUnit.MILLISECONDS);

	}

}
