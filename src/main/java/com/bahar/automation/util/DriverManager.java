package com.bahar.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {
	static{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\wires.exe");
	}
	public static WebDriver driver=new FirefoxDriver();
	
	private DriverManager(){
		
	}
}
