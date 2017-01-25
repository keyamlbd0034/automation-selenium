package com.bahar.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {
	private static WebDriver driver=null;
	
	private DriverManager(){
		
	}
	public static synchronized WebDriver getDriver(){
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\wires.exe");
		 if(driver==null)
			 return new FirefoxDriver();
		 else
			 return driver;
	}
}
