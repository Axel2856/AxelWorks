package com.ApachePoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadXmlData1 {

	public static void main(String[] args) throws IOException {
		//Read Data From File
		File f=new File("E:\\Selenium Materials and Setup\\ExcelData\\LoginData.xlsx");
		//FileInputStream fi=new FileInputStream("E:\\Selenium Materials and Setup\\ExcelData\\LoginData.xlsx");
		FileInputStream fi=new FileInputStream(f);
		//get Workbook from file
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		//get Sheet from Workbook
		XSSFSheet ws=wb.getSheet("Login");
		//XSSFSheet ws=wb.getSheetAt(0);
		//get FirstRow from Sheet
		XSSFRow row=ws.getRow(0);
		//count number of rows in Sheet
		int rc=ws.getLastRowNum();
		//count number of columns in row
		int cc=row.getLastCellNum();
		System.out.println("Number of Rows:= "+rc+"\n"+"Number of Colums:= "+cc);
	}

}
