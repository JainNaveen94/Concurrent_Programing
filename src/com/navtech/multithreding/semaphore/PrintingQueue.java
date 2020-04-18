package com.navtech.multithreding.semaphore;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

class PrintingQueue {

	private Semaphore printQueueSemaphore;
	private Semaphore printAquireSemaphore;
	private boolean printerList[];

	public PrintingQueue() {
		this.printAquireSemaphore = new Semaphore(1);
		this.printQueueSemaphore = new Semaphore(3);
		printerList = new boolean[3];
		Arrays.fill(this.printerList, true);
	}

	public void printAJob(Object object) {
		try {
			// Decreased the Semaphore Counter
			this.printQueueSemaphore.acquire();

			// get the Available Printer from the List
			int printerId = getPrinterFromList();

			// Printing Task to Be Performed
			long duration = (long) (Math.random() * 10000);
			System.out.println(String.format("%s : Printing is Completed in %d Seconds by Print %d",
					Thread.currentThread().getName(), (duration / 1000), printerId));
			Thread.sleep(duration);

			// Release the Printer After Performing the Operation
			releasePrinter(printerId);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out
					.println(String.format("%s : Printing Of the Document Finished", Thread.currentThread().getName()));
			// increase the Semaphore Counter
			this.printQueueSemaphore.release();
		}
	}

	// Used to Get the Printer
	public int getPrinterFromList() {
		
		int printerId = -1;

		try {
			// Here Aquire the Lock on Printer Queue
			this.printAquireSemaphore.acquire();

			for (int i = 0; i < this.printerList.length; i++) {
				if (this.printerList[i]) {
					printerId = i;
					this.printerList[i] = false;
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Here Release the Lock on printer Queue
			this.printAquireSemaphore.release();
		}
		return printerId;
	}

	// Used to Release the Printer
	public void releasePrinter(int printerId) {
		try {
			// Here Aquire the Lock on Printer Queue
			this.printAquireSemaphore.acquire();

			this.printerList[printerId] = true;

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Here Release the Lock on printer Queue
			this.printAquireSemaphore.release();
		}
	}

}
