package com.navtech.multithreding.semaphore;

class PrintingJob implements Runnable {

	private PrintingQueue taskQueue;

	public PrintingJob(PrintingQueue taskQueue) {
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {
		try {
			System.out.println(String.format("%s : is going to print the document", Thread.currentThread().getName()));
			this.taskQueue.printAJob(new Object());
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
