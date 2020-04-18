package com.navtech.multithreding.uncaught_exception_handler;

public class TaskProcess implements Runnable {

	@Override
	public void run() {
//		Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
		System.out.println(Integer.parseInt("100"));
		System.out.println(Integer.parseInt("200"));
		System.out.println(Integer.parseInt("ABCD"));
//		System.out.println(Integer.parseInt("WXYZ"));
		System.out.println(Integer.parseInt("300"));
		System.out.println(Integer.parseInt("400"));
		System.out.println(Integer.parseInt("500"));
//		System.out.println(Integer.parseInt("ASDF"));
//		System.out.println(Integer.parseInt("(90)"));
//		System.out.println(Integer.parseInt("<><><><><><><>"));
//		System.out.println(Integer.parseInt("10010"));
	}

}
