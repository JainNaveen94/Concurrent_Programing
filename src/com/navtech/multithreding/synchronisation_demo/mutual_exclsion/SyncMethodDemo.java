package com.navtech.multithreding.synchronisation_demo.mutual_exclsion;


// Resource Object Class
class GenerateTable {

	// Default Constructor
	public GenerateTable() {
	}

	
	// Method to Print the Table
	/* Main Logic of Synchronized Method is Here */
	
	//	void printTable(int tableNumber) {
	synchronized void printTable(int tableNumber) {
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

// Thread Class 1
class TableThread1 extends Thread {
	
	// Object Reference
	GenerateTable gt;
	
	// Parameterized Constructor
	public TableThread1(GenerateTable gt) {
		this.gt = gt;
	}
	
	@Override
	public void run() {
		gt.printTable(10);
	}
}

//Thread Class 2
class TableThread2 extends Thread {
	
	// Object Reference
	GenerateTable gt;
	
	// Parameterized Constructor
	public TableThread2(GenerateTable gt) {
		this.gt = gt;
	}
	
	@Override
	public void run() {
		gt.printTable(100);
	}
}

public class SyncMethodDemo {

	public static void main(String[] args) {
		
		GenerateTable gt = new GenerateTable();

		TableThread1 t1 = new TableThread1(gt);
		TableThread2 t2 = new TableThread2(gt);
		
		t1.start();
		t2.start();

	}

}
