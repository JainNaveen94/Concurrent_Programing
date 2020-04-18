package com.navtech.multithreding.callable_future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@SuppressWarnings("rawtypes")
class RandomProducer implements Callable {

	private Random random;

	public RandomProducer() {
		random = new Random();
	}

	// Task to be Performed
	@Override
	public Object call() throws Exception {
		Integer number = random.nextInt(10);
		Thread.sleep(number * 500);
		return number;
	}
}

public class FutureTaskDemo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		// FutureTask is used to pass callable into thread
		// Array of Future Task
		FutureTask[] taskArray = new FutureTask[5];

		for (int i = 0; i < taskArray.length; i++) {
			// callable class is pass as an argument into Future Task
			taskArray[i] = new FutureTask(new RandomProducer());
			Thread thread = new Thread(taskArray[i]);
			thread.start();
		}

		// Future Task is used to print Result return by Callable
		for (FutureTask task : taskArray) {
			try {
				System.out.println("Number Generated :: " + task.get() + " :: Task Status ::" + task.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}

}
