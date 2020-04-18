package com.navtech.multithreding.synchronisation_demo.mutual_exclsion;

//Resource Object Class
class GeneratorTable {

	// Default Constructor
	public GeneratorTable() {
	}

	// Method to Print the Table
	void printTable(int tableNumber) {
		/* Main Logic of Synchronized Block is Here */
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(tableNumber * (i + 1));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

//Thread Class 1
class TableThreads1 extends Thread {

	// Object Reference
	GeneratorTable gt;

	// Parameterized Constructor
	public TableThreads1(GeneratorTable gt) {
		this.gt = gt;
	}

	@Override
	public void run() {
		gt.printTable(10);
	}
}

//Thread Class 2
class TableThreads2 extends Thread {

	// Object Reference
	GeneratorTable gt;

	// Parameterized Constructor
	public TableThreads2(GeneratorTable gt) {
		this.gt = gt;
	}

	@Override
	public void run() {
		gt.printTable(100);
	}
}

public class SyncBlockDemo {

	public static void main(String[] args) {
		
		// Object Reference which is shared between this two below threads
		GeneratorTable gt = new GeneratorTable();
		
		// Thread Generation to perform the same task
		TableThreads1 t1 = new TableThreads1(gt);
		TableThreads2 t2 = new TableThreads2(gt);
		
		t1.start();
		t2.start();
;
	}

}
