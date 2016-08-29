package io.stockr.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

	public static List<String> loadStocksFromFile() {
		List<String> l = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("mystocks.txt"));
			String s;
			while ((s = reader.readLine()) != null)
				l.add(s.toUpperCase());
			reader.close();
			return l;
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
		return null;
	}

	public static void saveStocksToFile(List<String> l) {
		if(l.size() == 0)
			return;
		FileWriter fW = null;
		try {
			fW = new FileWriter(new File("mystocks.txt"));
			for (String s : l)
				fW.write(s+System.lineSeparator());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fW != null)
					fW.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private FileIO() {
	}
}
