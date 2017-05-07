package com.electron.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetData 
{
	public static void toProperty(String filePath, 
			Object key, Object value, String commitMsg)
	{
		try
		{	
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			prop.put(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			prop.store(fos, commitMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
public static void toExcel(String filePath, String sheetName, 
		int rowIndex, int cellIndex, String data)
{
	try
	{
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet st = wb.getSheet(sheetName);
		Row r = st.getRow(rowIndex);
		Cell c = r.getCell(cellIndex);
		c.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
