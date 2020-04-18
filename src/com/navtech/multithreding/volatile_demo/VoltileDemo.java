package com.navtech.multithreding.volatile_demo;

class IncrementCount {
	private volatile int count = 10;
	
	public int getCount() {
		return count;
	}
	
	public void incrementCounter() {
		count++;
	}
}


class VolatileThread extends Thread {
	
	private IncrementCount countData;
	
	public VolatileThread(IncrementCount countData) {
		this.countData = countData;
	}
	
	public void run() {
		int oldValue = this.countData.getCount();
		System.out.println("Current Running Thread :: " + Thread.currentThread() + " :: Count :: " + oldValue);
		countData.incrementCounter();
		int newValue = this.countData.getCount();
		System.out.println("Current Running Thread :: " + Thread.currentThread() + " :: Count :: " + newValue);
	}
}


public class VoltileDemo {

	public static void main(String[] args) {
		
		IncrementCount count = new IncrementCount();
		
		VolatileThread thread1 = new VolatileThread(count);
		VolatileThread thread2 = new VolatileThread(count);
		
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		thread2.start();
		try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
