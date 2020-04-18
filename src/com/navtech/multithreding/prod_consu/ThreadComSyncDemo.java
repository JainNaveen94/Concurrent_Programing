package com.navtech.multithreding.prod_consu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Producer implements Runnable {

	private final List<Integer> producerQueue;
	private final int MAX_SIZE;
	private final Random random = new Random();

	// To Initilize the Producer Object
	public Producer(List<Integer> producerQueue, int size) {
		this.producerQueue = producerQueue;
		this.MAX_SIZE = size;
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.produce(random.nextInt(100));
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}

		}

	}

	// Producing the values in producerQueue
	public void produce(int number) throws InterruptedException {
		synchronized (producerQueue) {

			// Waiting Condition if producerQueue is Full
			while (this.producerQueue.size() == MAX_SIZE) {
				System.out.println("Task Queue is Full :: Waiting For Consumer to Consume some Values");
				producerQueue.wait();
			}

			Thread.sleep(100);
			this.producerQueue.add(number);
			System.out.println(Thread.currentThread().getName() + " :: " + number);
			producerQueue.notifyAll();

		}

	}

}

class Consumer implements Runnable {

	private final List<Integer> consumerQueue;

	// To Initilize the Producer Object
	public Consumer(List<Integer> consumerQueue) {
		this.consumerQueue = consumerQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.consume();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}

	}

	// Consuming the values in consumerQueue
	public void consume() throws InterruptedException {
		synchronized (consumerQueue) {
			// Waiting Condition if consumerQueue is Full
			while (this.consumerQueue.size() == 0) {
				System.out.println("Task Queue is Empty :: Waiting For Producer to Produce some Values");
				consumerQueue.wait();
			}

			Thread.sleep(100);
			int valueToBeConsume = (Integer) this.consumerQueue.remove(0);
			System.out.println(Thread.currentThread().getName() + " :: " + valueToBeConsume);
			consumerQueue.notifyAll();
		}
	}

}

public class ThreadComSyncDemo {

	public static void main(String[] args) {

		// Creating the Queue and Maximum Capacity of it.
		List<Integer> taskQueue = new ArrayList<Integer>();
		final int MAX_CAPACITY = 5;

		// Create and processed Producer Thread
		new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer").start();
		// Create and processed Consumer Thread
		new Thread(new Consumer(taskQueue), "Consumer").start();

	}

}
