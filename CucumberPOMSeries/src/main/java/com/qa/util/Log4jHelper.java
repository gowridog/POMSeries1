package com.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jHelper {

	private static final Logger log = LogManager.getLogger(Log4jHelper.class.getName());

	// Info Level Logs
	public static void info(String message) {
		log.info(message);
	}

	// Warn Level Logs
	public static void warn(String message) {
		log.warn(message);
	}

	// Error Level Logs
	public static void error(String message) {
		log.error(message);
	}

	// Fatal Level Logs
	public static void fatal(String message) {
		log.fatal(message);
	}

	// Debug Level Logs
	public static void debug(String message) {
		log.debug(message);
	}

}
