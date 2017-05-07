package com.electron.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData 
{
	public static String fromProperties(String filePath, Object key)
	{
		String value = null;
		try
		{
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			value = (String) prop.get(key);
			return value;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return value;
	}
	
	public static String fromExcel
	(String filePath, String sheetName, int rowIndex, int cellIndex)
	{
		String data = null;
		try
		{
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
			return data;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
}
