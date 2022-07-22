package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	/*
	 * This method is used to load the prperties from config.properties file located
	 * at \src\test\resources\config\config.properties
	 * 
	 * @retun it returns the Properties prop object.
	 */

	public static Properties init_prop() {

			prop = new Properties();
		
		try {
			String fileName = System.getProperty("propertyFilename");
			FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return prop;

	}

}
