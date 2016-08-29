package io.stockr.notification.manager;

public class NotificationManager {
	public static void checkForNotifications(String symbol, double price) {
		double[] prices = getHighAndLow(symbol);
		if(symbol.equals("QQQ"))
			return;
		if (price <= prices[0] || price >= prices[1]) {
			notificationDetected(symbol, price);
		}
	}

	public static boolean addNotification(String symbol, double high, double low) {
		// check to make sure symbol doesn't exist in file...
		// if symbol already exists, overwrite? or maybe just return false
		// telling user it already exists
		// return false if unable to overwrite, true if overwritten

		return false;
	}

	public static boolean removeNotification(String symbol) {
		// search thru file for the line, then remove it
		// return true if it was removed, and false if it was not removed (not
		// found)

		return false;
	}

	private static double[] getHighAndLow(String symbol) {
		double[] d = new double[] { Double.MIN_VALUE, Double.MAX_VALUE };
		// read file here
		return new double[]{100,104};
		//return d;
	}

	private static void notificationDetected(String symbol, double price) {
		System.out
				.println("Notification! " + symbol + " is at $" + price + "!");
		// hit found, tell emailer package to send a text..
		//also, remove the notification setting
	}

	private NotificationManager() {
	}
}
