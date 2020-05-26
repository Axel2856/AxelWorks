package com.ApachePoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteXmlData {

	public static void main(String[] args) throws IOException {
		FileInputStream fi=new FileInputStream("E:\\Selenium Materials and Setup\\ExcelData\\LoginData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("Login");
		XSSFRow row=ws.getRow(0);
		int rc=ws.getLastRowNum();		
		//Write CellData into Xml
		for(int i=1;i<=rc;i++)
		{
			ws.getRow(i).createCell(2).setCellValue("NA");
		}//create output xml file to store the adding result value in xmlfile
		FileOutputStream fo=new FileOutputStream("E:\\Selenium Materials and Setup\\ExcelData\\FileOut\\NA.xlsx");
		wb.write(fo);
		fo.close();
		//read cellData From Xml
		for(int i=1;i<=rc;i++)
		{
			String user=ws.getRow(i).getCell(0).getStringCellValue();
			String pass=ws.getRow(i).getCell(1).getStringCellValue();			
			String res=ws.getRow(i).getCell(2).getStringCellValue();
			System.out.println(user+"  \t"+pass+"  \t"+res);
		}
		fi.close();
		wb.close();
	}

}
