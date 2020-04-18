package com.navtech.multithreding.uncaught_exception_handler;

import java.lang.Thread.UncaughtExceptionHandler;

// Interface UncaughtExceptionHandler used to Handle all the Unchecked Exception
// without Stopping the Application Flow.
public class ExceptionHandler implements UncaughtExceptionHandler {

	// Method which is used to Handle the Unchecked Exception
	public void uncaughtException(Thread thread, Throwable th) {
		System.out.println(":: Exception Caught Here :: " + thread.getName());
		System.out.println(":: Exception Details ::");
		System.out.println("Exception Name :: " + th.getClass().getName());
		System.out.println("Exception Message :: " + th.getMessage());
		System.out.println(":: Exception Trace :: \n");
		th.printStackTrace(System.out);
		System.out.println("Thread Status :: " + thread.getState());
		new Thread(new TaskProcess()).start();
	}

}
