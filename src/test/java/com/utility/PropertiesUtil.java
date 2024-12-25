package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.ENV;

public class PropertiesUtil {
//read properties file
	
	public static String readProperties(ENV env,String propertyName) {
		File propFile = new File(System.getProperty("user.dir") + "//config//" + env + ".properties");
		FileReader fileReader = null;
		Properties properties = new Properties();

		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		 catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(propertyName.toUpperCase());
	}
}
