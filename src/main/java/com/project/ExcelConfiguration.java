package com.project;

import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelConfiguration {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public ExcelConfiguration(String excelPath)
	{
			try {
				FileInputStream fis = new FileInputStream(excelPath);
				wb = new XSSFWorkbook(fis);				
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
				
			}	
	}
	
	public List<List<String>> getList(){
		sheet = wb.getSheet("Data");
		List<List<String>> data = new ArrayList<List<String>>();
		for (int i = 1; i < sheet.getLastRowNum(); i++) { 
			List<String> entry = new ArrayList<String>();
			entry.add(sheet.getRow(i).getCell(0).getStringCellValue()); // user name
			entry.add(sheet.getRow(i).getCell(1).getStringCellValue()); // password
			data.add(entry);
		}
		return data;
		
 }
}

