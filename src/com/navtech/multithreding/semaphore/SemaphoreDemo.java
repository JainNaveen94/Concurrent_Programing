package com.navtech.multithreding.semaphore;


public class SemaphoreDemo {

	public static void main(String[] args) {
		
		// Create the Instance of the Printing Queue
		PrintingQueue taskQueue = new PrintingQueue();
		
		//Creating the Thread Array Which are going to perfomr the Task
		Thread[] threadList = new Thread[10];
		
		// Used to Initilize the 10 Threads With there Task
		for (int i = 0; i < threadList.length; i++) {
			threadList[i] = new Thread(new PrintingJob(taskQueue), "Thread" + (i+1));
		}
		
		// Used to Execute the Thread Task Using Start
		for (int i = 0; i < threadList.length; i++) {
			threadList[i].start();
		}

	}

}
