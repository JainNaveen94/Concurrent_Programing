package com.navtech.multithreding.callable_future;

import java.util.Random;

class CallableImpl implements Runnable {
	private Object result;
	private Random random;

	public CallableImpl() {
		result = null;
		random = new Random();
	}

	@Override
	public void run() {
		result = random.nextInt(10);
		try {
			Thread.sleep((Integer) result * 200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (this) {
			notifyAll();
		}

	}

	public synchronized Object get() throws InterruptedException {
		while (result == null) {
			wait();
		}
		return result;
	}
}

public class CallableFutureImplThroughRunnableDemo {

	public static void main(String[] args) {
		
		CallableImpl[] taskList = new CallableImpl[5];
		
		for (int i = 0; i < taskList.length; i++) {
			taskList[i] = new CallableImpl();
			Thread thread = new Thread(taskList[i]);
			thread.start();
		}
		
		for (CallableImpl call: taskList) {
			try {
				System.out.println("Number Generated :: " + call.get());
			} catch (NullPointerException | InterruptedException e ) {
				e.printStackTrace();
			}
		}

	}

}
