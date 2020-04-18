package com.navtech.multithreding.sleep_demo;

public class SleepDemo1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread() + " :: " + i);
				}
			}
		});

		// Thread using Runnable Interface
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread() + " :: " + i);
				}
			}
		});

		// Executing The Thread
		t1.start();
		t2.start();
	}

}
