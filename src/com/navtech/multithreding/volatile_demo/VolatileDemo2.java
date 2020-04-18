package com.navtech.multithreding.volatile_demo;

import java.util.Scanner;

class Runner {
	private boolean running = true;

	public boolean getRunner() {
		return this.running;
	}

	public void setRunner(boolean running) {
		this.running = running;
	}
}

class Processor extends Thread {

	Runner r1;

	public Processor(Runner r1) {
		this.r1 = r1;
	}

	@Override
	public void run() {
		while (this.r1.getRunner()) {
			System.out.println("(#**#).....Task Is Running.....(#**#)");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutDown() {
		this.r1.setRunner(false);
	}

}

public class VolatileDemo2 {

	public static void main(String[] args) {

		Runner r1 = new Runner();

		Processor p1 = new Processor(r1);
		Processor p2 = new Processor(r1);
		p1.start();
		p2.start();

		Scanner sc = new Scanner(System.in);
		System.out.println(":: Press Any Key To Stop Execution ::");
		sc.nextLine();
		sc.close();

		p1.shutDown();

	}

}
