package com.navtech.multithreding.synchronisation_demo.mutual_exclsion;

//Resource Class
class TableGenerator {
	
	public TableGenerator() {
		// TODO Auto-generated constructor stub
	}

	// Method to Print the Table
	
	synchronized static void printTable(int tableNumber) {
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

//Thread Class 1
class TableThreader1 extends Thread {

	@Override
	public void run() {
		TableGenerator.printTable(10);
	}
}

//Thread Class 2
class TableThreader2 extends Thread {

	@Override
	public void run() {
		TableGenerator.printTable(100);
	}
}

public class StaticSyncDemo {

	public static void main(String[] args) {
		
		// Thread Creation to execute the Task
		TableThreader1 t1 = new TableThreader1();
		TableThreader2 t2 = new TableThreader2();
		
		// Thread Execution start here
		t1.start();
		t2.start();
		
		

	}

}
