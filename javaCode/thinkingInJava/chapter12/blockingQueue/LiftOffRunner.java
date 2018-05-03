package thinkingInJava.chapter12.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class LiftOffRunner implements Runnable {

	private BlockingQueue<LiftOff> rockets;
	public LiftOffRunner(BlockingQueue<LiftOff> queue) {
		rockets = queue;
	}
	
	public void add(LiftOff lo) {
		try {
			rockets.put(lo);
		}catch (InterruptedException e) {
			System.out.println("Interrupted during put()");
		}
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				LiftOff rocket = rockets.take();
				rocket.run();  // use this thread
			}
		} catch (InterruptedException e) {
			System.out.println("Waking from take()");
		}
		System.out.println("Exiting LiftOffRunner");

	}

}
