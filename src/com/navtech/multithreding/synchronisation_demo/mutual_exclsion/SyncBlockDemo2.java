package com.navtech.multithreding.synchronisation_demo.mutual_exclsion;

class PrintNumbers {
	void printingNumbers(int number) throws InterruptedException {
		synchronized (this) {
			for (int j = 0; j < 5; j++) {
				System.out.println(Thread.currentThread() + " :: " + (number * (j + 1)));
				Thread.sleep(200);
			}
		}
	}
}

public class SyncBlockDemo2 {

	public static void main(String[] args) {

		PrintNumbers printNumbers1 = new PrintNumbers();
		PrintNumbers printNumbers2 = new PrintNumbers();

		new Thread(() -> {
			try {
				printNumbers1.printingNumbers(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Thread1").start();

		new Thread(() -> {
			try {
				printNumbers2.printingNumbers(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Thread2").start();

	}

}
