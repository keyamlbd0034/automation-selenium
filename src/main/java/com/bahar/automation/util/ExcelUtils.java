package com.bahar.automation.util;

import java.io.Closeable;
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

import com.bahar.automation.dto.Login;

import net.sourceforge.htmlunit.corejs.javascript.GeneratedClassLoader;

public class ExcelUtils {
	
	private static FileInputStream inputStream = null;
	private static Workbook workbook = null;
	
	public static List<Login> getLoginData() throws IOException{
		List<Login> logins=new ArrayList<Login>();
		
		//login is the first sheet in excel so getSheet parameter set to 0
		Iterator<Row> iterator = new ExcelUtils().getSheet(0).iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                 Login login=new Login();
                 login.setUserName(cell.getStringCellValue());
                 login.setPassword(cell.getStringCellValue());
                 System.out.println(login);
               logins.add(login);
            }
            close();
        }
		return logins;
	}
	
	private  Sheet getSheet(int sheetNo) throws IOException{
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
