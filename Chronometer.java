package Chronometer;

/**
 * 
 * @author Arman
 * 
 * This is a basic Chronometer Watch class. It shows the seconds, minutes, and hours past.
 * 
 * Version: 1.0.0-alpha
 *
 */

public class Chronometer {
	
	private String seconds = "00";
	private String minutes = "00";
	private String hours = "00";
	
	public void run() throws InterruptedException {
		while (true) {
			System.out.println(this.toString());
			increaseSecond();
			Thread.sleep(1000);
		}
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
