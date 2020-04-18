package com.navtech.multithreding.thread_factory_using_lock;

public class ThreadFactoryUsingLockDemo {

	public static void main(String[] args) {
		
		// Creating the Instance Of ThreadFactory Interface
		CustomThreadFactory customFactory = new CustomThreadFactory("Naveen Thread Factory");
		
		// Creating the Printing Queue
		PrintingQueue printQueue = new PrintingQueue();
		
		
		// Creating the Thread Class Instace
		Thread thread;
		
		
		// Initilizing the Thread with Thread Factory and Start Execution
		for (int i = 0; i < 10; i++) {
			thread = customFactory.newThread(new PrintingJob(printQueue));
			thread.start();
//			try {
//				thread.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		// Shutdown Hook Is used to execute task at last by creating another thread
		Runtime runtime = Runtime.getRuntime();
		runtime.addShutdownHook(new Thread(() -> {
			//Printing the Thread Statistics
			System.out.println("\n\n:: " + customFactory.getName() + " Statistical Data ::");
			System.out.println(customFactory.getStats());
		}));
		

	}

}
