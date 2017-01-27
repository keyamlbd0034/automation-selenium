package com.bahar.automation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bahar.automation.dto.Address;
import com.bahar.automation.dto.CreditCard;
import com.bahar.automation.dto.Login;
import com.bahar.automation.dto.Passenger;



public class ExcelUtils {
	
	private static FileInputStream inputStream = null;
	private static Workbook workbook = null;
	
	public static List<Login> getLoginData() throws IOException{
		List<Login> logins=new ArrayList<Login>();
		
		//login is the first sheet in excel so getSheet parameter set to 0
		Iterator<Row> iterator = ExcelUtils.getSheet(0).iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Login login=new Login();
            byte cellCounter=0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cellCounter) {
				case 0:
					login.setUserName(cell.getStringCellValue());
					cellCounter++;
					break;
				case 1:
					login.setPassword(cell.getStringCellValue());
					break;
				default:
					break;
				}               
                 
            }
            logins.add(login);
        }
        close();
		return logins;
	}
	public static List<Passenger> getPassengerData() throws IOException{
		List<Passenger> passengers=new ArrayList<Passenger>();
		
		//passenger is the second sheet in excel so getSheet parameter set to 1
		Iterator<Row> iterator = ExcelUtils.getSheet(1).iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Passenger passenger=new Passenger();
            CreditCard card=new CreditCard();
            Address deliveryAddress=new Address();
            Address billingAddress=new Address();
            byte cellCounter=0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cellCounter) {
				case 0:
					passenger.setFirstName(cell.getStringCellValue());
					cellCounter++;
					break;
				case 1:
					passenger.setLastName(cell.getStringCellValue());
					cellCounter++;
					break;
				case 2:
					cellCounter++;
					break;
				case 3:
					cellCounter++;
					break;
				case 4:
					card.setNumber(String.valueOf(cell.getNumericCellValue()));
					cellCounter++;
					break;
				case 5:
					cellCounter++;
					break;
				case 6:
					cellCounter++;
					break;
				case 7:
					card.setFirstName(cell.getStringCellValue());
					cellCounter++;
					break;
				case 8:
					card.setMiddleName(cell.getStringCellValue());
					cellCounter++;
					break;
				case 9:
					card.setLastName(cell.getStringCellValue());
					cellCounter++;
					break;
				case 10:
					billingAddress.setAddress(cell.getStringCellValue());
					cellCounter++;
					break;
				case 11:
					billingAddress.setCity(cell.getStringCellValue());
					cellCounter++;
					break;
				case 12:
					billingAddress.setState(cell.getStringCellValue());
					cellCounter++;
					break;
				case 13:
					billingAddress.setPostalCode(cell.getStringCellValue());
					cellCounter++;
					break;
				case 14:
					cellCounter++;
					break;
				case 15:
					deliveryAddress.setAddress(cell.getStringCellValue());
					cellCounter++;
					break;
				case 16:
					deliveryAddress.setCity(cell.getStringCellValue());
					cellCounter++;
					break;
				case 17:
					deliveryAddress.setState(cell.getStringCellValue());
					cellCounter++;
					break;
				case 18:
					deliveryAddress.setPostalCode(cell.getStringCellValue());
					cellCounter++;
					break;
				case 19:
					cellCounter++;
					break;
				default:
					break;
				}               
                 
            }
            passenger.setCard(card);
            passenger.setBillingAddress(billingAddress);
            passenger.setDeliveryAddress(deliveryAddress);
            passengers.add(passenger);
        }
        close();
		return passengers;
	}
	private  static Sheet getSheet(int sheetNo) throws IOException{
		// change the file location as per your computer
		inputStream = new FileInputStream(new File("D:\\data.xlsx"));
		workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(sheetNo);
        return sheet;
	}
	private static void close() throws IOException{
		 workbook.close();
	     inputStream.close();
	}
}
