package com.ApachePoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Use_Interface_RWXmlData {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi=new FileInputStream("E:\\Selenium Materials and Setup\\ExcelData\\NumData.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet ws=wb.getSheet("Sheet1");
		//Row row=ws.getRow(0);
		int rc=ws.getLastRowNum();
		int a=wb.getSheet("Sheet1").getLastRowNum();
		System.out.println("a="+a);
		for(int i=1;i<=rc;i++)
		{
			String uid=ws.getRow(i).getCell(0).getStringCellValue();
			if(wb.getSheet("Sheet1").getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				int celldata=(int)wb.getSheet("Sheet1").getRow(i).getCell(1).getNumericCellValue();
				String pass=String.valueOf(celldata);
				System.out.println(uid+"  \t"+pass);				
			}	
			ws.getRow(i).createCell(2).setCellValue("NA");
			
		}
		fi.close();
		FileOutputStream fo=new FileOutputStream("E:\\Selenium Materials and Setup\\ExcelData\\FileOut\\IfaceRW.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}

}
