package com.bahar.automation.test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bahar.automation.util.DriverManager;
import com.bahar.automation.util.TextUtils;
import com.bahar.automation.util.XpathUtils;

public class FindFlightTest {	
	
	private WebDriver driver=null;
	
	@Test(priority=1)
	public void checkTitle(){
		driver=DriverManager.driver;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.FindFlight.DROPDOWN_PASSENGERS)));
		Assert.assertEquals(driver.getTitle(), TextUtils.FIND_FLIGHT_PAGE_TITLE);
	}
	@Test(priority=2)
	public void checkFlightDetails(){
		driver.findElement(By.xpath(XpathUtils.FindFlight.RADIO_ONE_WAY)).click();
		Select passenger = new Select(driver.findElement(By.xpath(XpathUtils.FindFlight.DROPDOWN_PASSENGERS)));
		passenger.selectByIndex(2);
		Select departingFrom = new Select(driver.findElement(By.xpath(XpathUtils.FindFlight.DROPDOWN_DEPARTING_FROM)));
		departingFrom.selectByIndex(2);
		Select departingFromOn = new Select(driver.findElement(By.xpath(XpathUtils.FindFlight.DROPDOWN_DEPARTING_FROM_ON)));
		departingFromOn.selectByIndex(2);
		Select departingFromOnDate = new Select(driver.findElement(By.xpath(XpathUtils.FindFlight.DROPDOWN_DEPARTING_FROM_ON_DATE)));
		departingFromOnDate.selectByIndex(2);
		Select arrivingFrom = new Select(driver.findElement(By.xpath(XpathUtils.FindFlight.DROPDOWN_ARRIVING_FROM)));
		arrivingFrom.selectByIndex(2);
		Select arrivingFromOn = new Select(driver.findElement(By.xpath(XpathUtils.FindFlight.DROPDOWN_ARRIVING_FROM_ON)));
		arrivingFromOn.selectByIndex(2);
		Select arrivingFromOnDate = new Select(driver.findElement(By.xpath(XpathUtils.FindFlight.DROPDOWN_ARRIVING_FROM_ON_DATE)));
		arrivingFromOnDate.selectByIndex(2);
		driver.findElement(By.xpath(XpathUtils.FindFlight.RADIO_SERVICE_CLASS)).click();
		driver.findElement(By.xpath(XpathUtils.FindFlight.BUTTON_CONTINUE)).submit();
	}
}
