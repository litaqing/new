package com.kjl.utils;

import java.io.InputStream;
import java.util.Properties;


public class ConfigManager {
	private  Properties properties;
	private static ConfigManager configManager;
	
	private ConfigManager(){//private
		String path = "config.properties";
		properties = new Properties();
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(path);
		try {
			//通过Classpath获取配置文件
			properties.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//静态方法，返回是一个ConfigManager
	public static  ConfigManager getInstance(){
		if(configManager == null){
			configManager = new ConfigManager();
		}
		return configManager;
	}
	
	//通过key获取value
	public String getValue(String key){
		return properties.getProperty(key);
	}
	
	

}
