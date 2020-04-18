package com.navtech.multithreding.sleep_demo;

public class SleepDemo {

	public static void main(String[] args) {
		PrintTable table = new PrintTable();
		
		// Thread using Runnable Interface
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.printTable(10);
			}
		});
		
		// Thread using Runnable Interface
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.printTable(20);
			}
		});
		
		// Executing The Thread
		t1.start();
		t2.start();

	}

}

class PrintTable {
	public void printTable(int n) {
		for(int i=0; i<n; i++) {
			System.out.println(Thread.currentThread() + " :: " + n*(i+1));
//			int j = i+1;
//			while(j>0) {
//				System.out.print("*");
//				j--;
//			}
		}
	}
}
