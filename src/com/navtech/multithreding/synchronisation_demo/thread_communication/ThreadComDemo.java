package com.navtech.multithreding.synchronisation_demo.thread_communication;

class Account {

	// Initial Amount in Bank
	private int amount = 10000;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	// To Withdraw Amount From Bank Account
	synchronized void withdrawAmount(int amount) {

		System.out.println("Withdraw Process Initiated :: Please Wait ...... (@----@)");

		// For Waiting some Time to Check Amount in Account
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (this.amount < amount) {
			System.out.println(
					amount + " is Not Available in your Account right now :: Waiting for Deposite ...... (@***@)");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// For Waiting some Time to deduct Amount from Account
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.amount -= amount;
		System.out.println(
				amount + " is Successfully Withrawal :: Total Amount = " + this.amount + " ........ ($-----$)");

	}

	// To Deposite Amount in your Account
	synchronized void depositeAmount(int amount) {
		System.out.println("Deposite Process Initiated :: Please Wait ...... (@----@)");

		// For Waiting some Time Before Deposite Amount in Account
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.amount += amount;
		System.out.println(amount + " is successfully Deposite :: Total Amount = " + this.amount + " ..... ($------$)");
		notify();
	}
}

public class ThreadComDemo {

	public static void main(String[] args) {

		Account account = new Account();

		// Using LamdaExpression to Create and Execute Thread for Withdraw the Amount

		new Thread(() -> {
			account.withdrawAmount(20000);
		}).start();

		// Using LamdaExpression to Create and Execute Thread for Deposite the Amount

		new Thread(() -> {
			account.depositeAmount(15000);
		}).start();

	}

}
