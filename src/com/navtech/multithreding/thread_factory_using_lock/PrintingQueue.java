package com.navtech.multithreding.thread_factory_using_lock;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintingQueue {

	// Lock Aquired by Thread Before Proceeding to Print the Job
	private Lock printingQueueLock = new ReentrantLock();

	// Method used to Print the Job or Document
	public void processPrinting(Object printDocument) {

		// Locking Perform Here
		printingQueueLock.lock();

		try {
			// Printing Logic
			Long duration = (long) (Math.random() * 10000);
			System.out.println(String.format("%s : Printing a Job in %d seconds on %s",
					Thread.currentThread().getName(), (duration / 1000), new Date()));
			Thread.sleep(duration);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		} finally {
			System.out
					.println(String.format("%s : Printing of Document Is Completed", Thread.currentThread().getName()));
			// Unlocking Perform Here
			printingQueueLock.unlock();
		}

	}

}
