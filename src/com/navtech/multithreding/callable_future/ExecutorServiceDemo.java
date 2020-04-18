package com.navtech.multithreding.callable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ProduceResult implements Callable<Integer> {

	Integer number;

	public ProduceResult(Integer number) {
		this.number = number;
	}

	// Call Method to Perform the Task Logic
	@Override
	public Integer call() throws Exception {
		Integer result = 1;
		if (this.number == 0 || this.number == 1) {
			result = 1;
		} else {
			for (int i = 2; i <= this.number; i++) {
				result *= i;
				Thread.sleep(100);
			}
		}
		System.out.println("Result for " + this.number + " -> " + result);
		return result;
	}
}

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		
		// List of Future to store the Callable Interface Result
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
		
		// Executor Service to Create the Thread Pool
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		// To Generate the Random Number
		Random random = new Random();

		
		for (int i = 0; i < 5; i++) {
			Integer randNumber = random.nextInt(10);
			ProduceResult produce = new ProduceResult(randNumber);
			// Store the Callable result into Future Interface
			Future<Integer> result = executor.submit(produce);
			resultList.add(result);
		}

		for (Future<Integer> res : resultList) {
			try {
				System.out.println("Future Result :: " + res.get() + " :: Status Of Completeion :: " + res.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		executor.shutdown();

	}

}
