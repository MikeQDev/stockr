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
				if (sx.startsWith("})();</script></head><body><div id=\"app\">")) {
					String start = sx.substring(sx.indexOf("<span class=\"Fw(b) D(ib) Fz(36px) Mb(-4px)"));

					price = start.substring(start.indexOf('>')+1, start.indexOf("</span>"));
					//System.out.println(price);
					if (price.contains(","))
						price = sx.replaceAll(",", "");
					
					String startPosNeg = start.substring(start.indexOf("<span class=\"Fw(500) D(ib) Pstart(10px) Fz(24px) C($data"));
					
					posOrNeg = startPosNeg.substring(startPosNeg.indexOf('>'), startPosNeg.indexOf("</span>"));
					
					if(posOrNeg.charAt(1) == '+')
						posOrNeg = "pos";
					else if(posOrNeg.charAt(1) == '-')
						posOrNeg = "neg";
					//System.out.println(posOrNeg);
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
			 x.printStackTrace();
		}
		return new Double[] { -1.0, -1.0 };
	}

	private Scrape() {
	}
}
