package com.praba.myproject.constants;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Constants {

	private static Properties dataBase;
	static {
		dataBase = new Properties();
		try {
			dataBase.load(new FileReader("database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDataBaseProps(String name) {
		return dataBase.getProperty(name);
	}

}
