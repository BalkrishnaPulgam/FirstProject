package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.base.BaseClass;

public class PropertiesUtility extends BaseClass{
	
	public static FileInputStream fis=null;
	
	    //1. why we need utilty--read property file
		//2. whats are inputs-- key
		//3. what will be output-- value
	
	// user should get proper error msg if he use a invalid key
	public static String readProperty(String key) {
		Properties prop=new Properties();
		try {
			log.info("reading property file for key: "+key);
			fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("property filepath is wrong");
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("property file not initialised properly");
			e.printStackTrace();
		}
		
		if(prop.getProperty(key)!=null) {
			log.info("property value found");
				return prop.getProperty(key);}
		else
			return "proper value not found for"+key;
	}

}
