package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class ExcelUtility extends BaseClass{
	
	static FileInputStream fis=null;
	static Workbook wb=null;
	static Sheet sh=null;
	
	public static String getCellData(String filepath, String name, int rownum, int column) {
		DataFormatter  df= new DataFormatter();
		try {
			fis=new FileInputStream(filepath);
			wb=WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sh=wb.getSheet(name);
		Cell c=sh.getRow(rownum).getCell(column);
		
		return df.formatCellValue(c);
		
	}
	
	
	@Test
	public void test() {
		String xlpath=System.getProperty("user.dir")+"/src/test/resources/Test.xls";
		String poipath=System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx";
		
		System.out.println(getCellData(xlpath, "login", 0, 0));
		System.out.println(getCellData(poipath, "login", 0, 0));
	}

}
