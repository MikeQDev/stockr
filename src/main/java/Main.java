import javax.swing.JOptionPane;

import io.stockr.fileio.FileIO;
import io.stockr.gui.MainGUI;
import io.stockr.gui.NotificationSetupGUI;
import io.stockr.gui.OldNotificationGUI;
import io.stockr.scrape.Scrape;

public class Main {
	public Main() {
		//new NotificationSetupGUI(0);
		//new OldNotificationGUI("QQQ").getNotifications();;
		MainGUI mG = new MainGUI(FileIO.loadStocksFromFile());
		//Scrape.getPrice("pfe");
	}

	public static void main(String[] args) {
		new Main();
	}
}
