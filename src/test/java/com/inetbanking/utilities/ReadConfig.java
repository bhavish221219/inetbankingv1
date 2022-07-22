package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File scr= new File("./Configuration/config.properties");

		try {
			FileInputStream fis=new FileInputStream(scr);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
	}

public String getApplicationURL() {

	String url=pro.getProperty("baseURL");
	return url;
}
public String getUsername() {

	String username=pro.getProperty("username");
	return username;
}
public String getPassword() {

	String Password=pro.getProperty("password");
	return Password;
}
public String getChromePath() {

	String chromepath=pro.getProperty("chromepath");
	return chromepath;
}
public String getFirefoxPath() {

	String firefox=pro.getProperty("firefox");
	return firefox;
}
public String getIEPath() {

	String iepath=pro.getProperty("iepath");
	return iepath;
}
}
