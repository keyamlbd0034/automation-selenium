package com.bahar.automation.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bahar.automation.dataprovider.LoginDataProvider;
import com.bahar.automation.dto.Login;
import com.bahar.automation.util.DriverManager;
import com.bahar.automation.util.TextUtils;
import com.bahar.automation.util.XpathUtils;

public class HomeTest {
	private WebDriver driver=DriverManager.getDriver();
	
	@BeforeClass
	public void openPage(){
		driver.get(TextUtils.BASE_URL);
	}
	
	@Test(priority=1)
	public void checkTitle(){
		Assert.assertEquals(driver.getTitle(), TextUtils.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void checkMenu() throws InterruptedException{
		driver.findElement(By.xpath(XpathUtils.Login.MENU_FLIGHT)).click();
		driver.navigate().back();
		driver.findElement(By.xpath(XpathUtils.Login.MENU_HOTELS)).click();
		driver.navigate().back();
		driver.findElement(By.xpath(XpathUtils.Login.MENU_CAR_RENTALS)).click();
		driver.navigate().back();	
	}
	@Test(dataProvider="loginData",dataProviderClass=LoginDataProvider.class,priority=3)
	public void checkLogin(List<Login> logins) throws InterruptedException{
		for(Login login: logins){
			navigate("http://newtours.demoaut.com/mercurywelcome.php");
			driver.findElement(By.xpath(XpathUtils.Login.INPUT_USER_NAME)).sendKeys(login.getUserName());
			driver.findElement(By.xpath(XpathUtils.Login.INPUT_PASSWORD)).sendKeys(login.getPassword());
			driver.findElement(By.xpath(XpathUtils.Login.BTN_SIGNIN)).submit();			
		}	
	}
	private void navigate(String url){
		driver.navigate().to(url);
		driver.navigate().refresh();
	}

}
