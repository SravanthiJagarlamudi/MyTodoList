package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	public static Properties p;
	static{
		File src = new File("./Configuration/config.properties");
		
		try{
			FileInputStream fil =  new FileInputStream(src);
			p = new Properties();
			p.load(fil);
		}catch(Exception e){
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public static String getApplicationURL(){
		String url = p.getProperty("baseurl");
		return url;
	}
	
	public static String getBrowser(){
		return p.getProperty("Browser");
	}
//	
//	public static String getusername(){
//		String uname = p.getProperty("username");
//		return uname;
//	}
//	
//	public static String getpwd(){
//		String pwd = p.getProperty("passwrd");
//		return pwd;
//	}
//	
//	public static String getChromepath(){
//		String chrmpath = p.getProperty("chromepath");
//		return chrmpath;
//	}

}
