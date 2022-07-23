package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.xmlbeans.ResourceLoader;

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
			String path = ".\\src\\test\\resources\\config\\";
			String fileName = System.getProperty("prop");
			if(System.getProperty("prop")== null) {
				fileName = "config.properties";
				System.out.println("**********Properties file defaut is " +path+fileName);

			}
			System.out.println("**********Properties file from arguments"+path+fileName);
			FileInputStream ip = new FileInputStream(path+fileName);
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
