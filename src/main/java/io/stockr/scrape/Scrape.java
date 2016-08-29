package io.stockr.scrape;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Scrape {
	private final static String BASE_URL = "http://finance.yahoo.com/q?s=";

	public static Double[] getPrice(String s) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new URL(BASE_URL + s).openConnection().getInputStream()));
			String sx;
			String posOrNeg = null;
			String price = null;
			while ((sx = reader.readLine()) != null) {
				if (sx.startsWith("\t</script><div id=\"yfi_broker_buttons")) {
					int indexB = sx.indexOf("png");

					posOrNeg = sx.substring(indexB + 12, indexB + 15);

					StringBuilder sB = new StringBuilder(sx.substring(sx
							.indexOf("yfs")));
					price = sB.substring(sB.toString().indexOf('>') + 1,
							sB.toString().indexOf('<'));
					if (price.contains(","))
						price = sx.replaceAll(",", "");
				}

			}
			reader.close();
			if (posOrNeg.equals("pos"))
				return new Double[] {Double.parseDouble(price), 1.0};
			else if (posOrNeg.equals("neg"))
				return new Double[] {Double.parseDouble(price), -1.0};
			else
				return new Double[] {Double.parseDouble(price), 0.0};
		} catch (Exception x) {
			// x.printStackTrace();
		}
		return new Double[] { -1.0, -1.0 };
	}

	private Scrape() {
	}
}
