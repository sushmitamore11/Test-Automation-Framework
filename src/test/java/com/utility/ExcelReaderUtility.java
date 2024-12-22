package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {
		
		File XlsxFile = new File(System.getProperty("user.dir")+"//testData//" + fileName);
		XSSFWorkbook xssfWorkBook = null;
		XSSFSheet xssfSheet;
		List<User> userList = null;
		Iterator<Row> rowIterator ;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell ;
		User user;
		
		try {
			xssfWorkBook = new XSSFWorkbook(XlsxFile);
			userList = new ArrayList<User>();
			xssfSheet =  xssfWorkBook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();
			while(rowIterator.hasNext()) {
				row = rowIterator.next();			
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				xssfWorkBook.close();
			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
	}
}
