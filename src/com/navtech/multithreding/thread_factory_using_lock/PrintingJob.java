package com.navtech.multithreding.thread_factory_using_lock;

class PrintingJob implements Runnable {

	private PrintingQueue printQueue;

	public PrintingJob(PrintingQueue printQueue) {
		this.printQueue = printQueue;
	}

	// Logic To Start Printing by putting Print Job in Queue
	@Override
	public void run() {
		System.out.println(String.format("%s : Going To Print a job or document", Thread.currentThread().getName()));
		this.printQueue.processPrinting(new Object());
	}

}
