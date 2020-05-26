package com.ApachePoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllXmlData {

	public static void main(String[] args) throws IOException {
		//Path setup for the File data access
		FileInputStream fi=new FileInputStream("E://Selenium Materials and Setup//ExcelData//LoginData.xlsx");
		//Get Wookbook from file
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		//Get Sheet from Wookbook
		XSSFSheet ws=wb.getSheet("Login");
		//Get row from Sheet
		XSSFRow row=ws.getRow(0);
		//Count total number of Rows in Sheet
		int rc=ws.getLastRowNum();
		//Access all the data from Sheet using Looping
		for(int i=1;i<=rc;i++)
		{
			String username=ws.getRow(i).getCell(0).getStringCellValue();
			String password=ws.getRow(i).getCell(1).getStringCellValue();
			System.out.println(username+"   \t"+password);
		}
		fi.close();
		wb.close();
	}

}
