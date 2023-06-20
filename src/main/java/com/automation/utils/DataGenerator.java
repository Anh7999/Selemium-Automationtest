package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {

	@DataProvider(name = "Excel")
	public static Object[][] testDataGeneratorRegistor() throws IOException {
		FileInputStream file = new FileInputStream("./data/assignment2_data_test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet loginsheet = workbook.getSheet("Login");

		int numberOfData = loginsheet.getPhysicalNumberOfRows();

		Object[][] testData = new Object[numberOfData][2];

		for (int i = 0; i < numberOfData; i++) {
			XSSFRow row = loginsheet.getRow(i);
			XSSFCell email = row.getCell(0);
			XSSFCell password = row.getCell(1);
			testData[i][0] = email.getStringCellValue();
			testData[i][1] = password.getStringCellValue();
		}
		return testData;
	}
}
