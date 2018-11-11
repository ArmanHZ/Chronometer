package MultithreadingPractice;

import javax.swing.JLabel;

public class ChronometerMultiThread implements Runnable {

	private String seconds = "00";
	private String minutes = "00";
	private String hours = "00";

	private Thread thread;

	@Override
	public void run() {
		while (true) {
			System.out.println(this.toString());
			increaseSecond();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Use start() to start the Chronometer not run()
	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	@SuppressWarnings("deprecation")
	public void pause() {
		thread.suspend();
	}

	@SuppressWarnings("deprecation")
	public void resume() {
		thread.resume();
	}

	private void increaseSecond() {
		int seconds = Integer.parseInt(this.seconds);
		if (++seconds != 60) {
			if (seconds < 10)
				this.seconds = "0" + Integer.toString(seconds);
			else
				this.seconds = Integer.toString(seconds);
		} else {
			this.seconds = "00";
			increaseMinute();
		}
	}

	private void increaseMinute() {
		int minutes = Integer.parseInt(this.minutes);
		if (++minutes != 60) {
			if (minutes < 10)
				this.minutes = "0" + Integer.toString(minutes);
			else
				this.minutes = Integer.toString(minutes);
		} else {
			this.minutes = "00";
			increaseHour();
		}
	}

	private void increaseHour() {
		int hours = Integer.parseInt(this.hours);
		if (++hours != 24) {
			if (hours < 10)
				this.hours = "0" + Integer.toString(hours);
			else
				this.hours = Integer.toString(hours);
		} else {
			this.hours = "00";
		}
	}

	@Override
	public String toString() {
		return hours + ":" + minutes + ":" + seconds;
	}

}
