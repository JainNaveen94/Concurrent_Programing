package com.navtech.multithreding.synchronisation_demo.mutual_exclsion;

class PrintNumber {
	static void printingNumbers(int number) throws InterruptedException {
		synchronized (PrintNumber.class) {
			for (int j = 0; j < 5; j++) {
				System.out.println(Thread.currentThread() + " :: " + (number * (j + 1)));
				Thread.sleep(200);
			}
		}
	}
}

public class StaticSyncDemo2 {

	public static void main(String[] args) {

		new Thread(() -> {
			try {
				PrintNumber.printingNumbers(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "ONE").start();

		new Thread(() -> {
			try {
				PrintNumber.printingNumbers(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "TWO").start();

	}

}
