package com.navtech.multithreding.thread_factory_using_lock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadFactory implements ThreadFactory {

	private AtomicInteger count;
	private List<String> stats;
	private String name;
	
	/* Getter/Setter */
	
	public AtomicInteger getCount() {
		return count;
	}

	public void setCount(AtomicInteger count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStats(List<String> stats) {
		this.stats = stats;
	}

	// Initilizing the Thread Factory
	public CustomThreadFactory(String name) {
		this.count = new AtomicInteger();
		this.name = name;
		this.stats = new ArrayList<String>();
	}

	// Creating and returning the Thread using Thread Factory
	@Override
	public Thread newThread(Runnable runnable) {
		// creating Thread
		Thread th = new Thread(runnable, this.name + "-Thread_" + this.count.incrementAndGet());
		// Putting Entry Into Stats List
		this.stats.add(String.format("Created Thhread %d with Name %s on %s \n", th.getId(), th.getName(), new Date()));
		// Return thread object
		return th;
	}

	// To Print the Statistics Of Custom Factory
	public String getStats() {
		// Creating String Buffer
		StringBuffer buffer = new StringBuffer();
		// Stream and lamda is used to put stats in buffer
		this.stats.stream().forEach((stat) -> {
			buffer.append(stat);
		});
		// to print resulted buffer
		return buffer.toString();
	}

}
