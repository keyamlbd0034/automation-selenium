package com.bahar.automation.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.bahar.automation.util.ExcelUtils;

public class PassengerDataProvider {
	@DataProvider(name="passengerData")
	public static Object[][] getPassengerData() {
	        try {
				return new Object[][]{
						{
							ExcelUtils.getPassengerData()
						},
					};
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}	        
	    }
}
