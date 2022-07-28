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
			if (System.getProperty("prop") == null) {
				fileName = "config.properties";
				System.out.println("**********Properties file defaut is " + path + fileName);

			}
			System.out.println("**********Properties file from arguments" + path + fileName);
			FileInputStream ip = new FileInputStream(path + fileName);
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

	public static String getURL() {

		String region = "";
		String env = "";
		String URL = "";

		region = init_prop().getProperty("region");

		env = init_prop().getProperty("environment");
		
		

		switch (region) {
		case "US":
			URL = "https://www.marriott.com/";
			break;
		case "UK":
			URL = "https://www.marriott.co.uk/";
			break;
		case "Koria":
			URL = "https://www.marriott.co.kr/";
			break;
		case "Australia":
			URL = "https://www.marriott.com.au/";
			break;
		case "Brazil":
			URL = "https://www.marriott.com.br/";
			break;
		case "Denmark":
			URL = "https://www.marriott.de/";
			break;
		case "France":
			URL = "https://www.marriott.com.fr/";
			break;
		case "Arabic":
			URL = "https://www.arabic.marriott.com/";
			break;
		case "Espanol":
			URL = "https://www.espanol.marriott.com/";
			break;
		case "Thai":
			URL = "https://www.marriott.com/th/";
			break;

		case "":
			URL = "https://www.marriott.com/";
			break;
		}
		if (env.equals("")) {
			return URL;
		} else {
			if (region.equals("Arabic") || region.equals("Espanol")) {
				URL = URL.replace("marriott.com", env + ".marriott.com");
			} else {
				URL = URL.replace("www.marriott", "www." + env + ".marriott");
			}
			System.out.println("URL:....." + URL);
			return URL;
		}
	}
}
