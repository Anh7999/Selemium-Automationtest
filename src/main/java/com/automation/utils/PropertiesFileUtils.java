package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtils {

	public static String getProperty(String key) {
		try {
			File f = new File("./configuration/configs.properties");
			FileInputStream file = new FileInputStream(f);
			Properties properties = new Properties();
			properties.load(file);
			return properties.get(key).toString();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
