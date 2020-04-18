package com.navtech.multithreding.uncaught_exception_handler;

public class UncaughtExceptionDemo {

	public static void main(String[] args) {
		
		new Thread(new TaskProcess(), "Thread1").start();

	}

}
