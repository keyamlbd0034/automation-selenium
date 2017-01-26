package com.bahar.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bahar.automation.util.DriverManager;
import com.bahar.automation.util.TextUtils;
import com.bahar.automation.util.XpathUtils;

public class SelectFlightTest {
private WebDriver driver=null;
	
	@Test(priority=1)
	public void checkTitle(){
		driver=DriverManager.driver;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.SelectFlight.RADIO_DEPART)));
		Assert.assertEquals(driver.getTitle(), TextUtils.SELECT_FLIGHT_PAGE_TITLE);
	}
	@Test(priority=2)
	public void selectFlightDetails(){
		driver.findElement(By.xpath(XpathUtils.SelectFlight.RADIO_DEPART)).click();
		driver.findElement(By.xpath(XpathUtils.SelectFlight.RADIO_RETURN)).click();
		driver.findElement(By.xpath(XpathUtils.SelectFlight.BUTTON_CONTINUE)).submit();
	}

}
