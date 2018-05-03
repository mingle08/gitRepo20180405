package thinkingInJava.chapter12.p712.lock;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {

	private Car car;
	public WaxOff(Car c) {
		car = c;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("Wax Off! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (Exception e) {
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax Off task");
	}

}
