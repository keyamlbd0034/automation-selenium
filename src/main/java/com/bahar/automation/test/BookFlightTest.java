package com.bahar.automation.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bahar.automation.dataprovider.LoginDataProvider;
import com.bahar.automation.dataprovider.PassengerDataProvider;
import com.bahar.automation.dto.Passenger;
import com.bahar.automation.util.DriverManager;
import com.bahar.automation.util.TextUtils;
import com.bahar.automation.util.XpathUtils;

public class BookFlightTest {
private WebDriver driver=null;
	
	@Test(priority=1)
	public void checkTitle(){
		driver=DriverManager.driver;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.BookFlight.INPUT_FIRST_NAME)));
		Assert.assertEquals(driver.getTitle(), TextUtils.BOOK_FLIGHT_PAGE_TITLE);
	}
	@Test(dataProvider="passengerData",dataProviderClass=PassengerDataProvider.class,priority=2)
	public void checkBookFlightDetails(List<Passenger> passengers){
		for(Passenger passenger: passengers){
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_FIRST_NAME)).sendKeys(passenger.getFirstName());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_LAST_NAME)).sendKeys(passenger.getLastName());
			Select meal = new Select(driver.findElement(By.xpath(XpathUtils.BookFlight.DROPDOWN_MEAL)));
			meal.selectByIndex(2);
			Select cardType = new Select(driver.findElement(By.xpath(XpathUtils.BookFlight.DROPDOWN_CARD_TYPE)));
			cardType.selectByIndex(2);
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_NUMBER)).sendKeys(passenger.getCard().getNumber());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_CARD_FIRST_NAME)).sendKeys(passenger.getCard().getFirstName());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_CARD_MIDDLE_NAME)).sendKeys(passenger.getCard().getMiddleName());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_CARD_LAST_NAME)).sendKeys(passenger.getCard().getLastName());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_BILLING_ADDRESS)).sendKeys(passenger.getBillingAddress().getAddress());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_BILLING_CITY)).sendKeys(passenger.getBillingAddress().getCity());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_BILLING_STATE)).sendKeys(passenger.getBillingAddress().getState());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_BILLING_POSTAL)).sendKeys(passenger.getBillingAddress().getPostalCode());
			Select billingCountry = new Select(driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_BILLING_COUNTRY)));
			billingCountry.selectByIndex(2);
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_DELIVERY_ADDRESS)).sendKeys(passenger.getDeliveryAddress().getAddress());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_DELIVERY_CITY)).sendKeys(passenger.getDeliveryAddress().getCity());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_DELIVERY_STATE)).sendKeys(passenger.getDeliveryAddress().getState());
			driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_DELIVERY_POSTAL)).sendKeys(passenger.getDeliveryAddress().getPostalCode());
			Select deliveryCountry = new Select(driver.findElement(By.xpath(XpathUtils.BookFlight.INPUT_DELIVERY_COUNTRY)));
			deliveryCountry.selectByIndex(2);
			driver.findElement(By.xpath(XpathUtils.BookFlight.BUTTON_SECURE_PURCHASE)).submit();
		}
	}
}
