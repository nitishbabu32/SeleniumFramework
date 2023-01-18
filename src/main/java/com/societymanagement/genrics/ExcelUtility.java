package com.societymanagement.genrics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Nitish Babu
 *
 */
public class ExcelUtility {
	/**
	 * This Method is used for reading data from excel file
	 * @param sheetName
	 * @param row
	 * @param colum
	 * @return data
	 * @throws IOException
	 */
public String readDataFromExcel(String sheetName,int row,int colum) throws IOException {
	FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
	Workbook wb = WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetName).getRow(row).getCell(colum).getStringCellValue();
	return data;
}

/**
 * This Method is used to write data to excel sheet one at time
 * @param sheetName
 * @param row
 * @param colum
 * @param value
 * @throws IOException
 */
public void writeDatatoExcel(String sheetName,int row,int colum,String value) throws IOException {
	FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(row).getCell(colum).setCellValue(value);
	FileOutputStream fos=new FileOutputStream(IPathConstant.EXCELPATH);
	wb.write(fos);
	wb.close();
	
}
/**
 * This Method is used to count the total RowNum
 * @param sheetName
 * @return
 * @throws IOException
 */
public int rowCount(String sheetName) throws IOException {
	FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
	Workbook wb = WorkbookFactory.create(fis);
	int count = wb.getSheet(sheetName).getLastRowNum();
	return count;
}
public HashMap<String, String> getList(String sheetName,int keyCell,int Valuecell) throws IOException {
	FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
	Workbook wb = WorkbookFactory.create(fis);
	int rowCount= wb.getSheet(sheetName).getLastRowNum();
	HashMap<String, String>map=new HashMap<>();
	for(int i=0;i<=rowCount;i++) {
		String key = wb.getSheet(sheetName).getRow(i).getCell(keyCell).getStringCellValue();
		String value = wb.getSheet(sheetName).getRow(i).getCell(Valuecell).getStringCellValue();
		map.put(key, value);
	}
	return map;
}
/**
 * This Method is used for read data from excel for dataprovider
 * @param sheetName
 * @return
 * @throws Throwable
 * @throws IOException
 */
public Object[][] readSetOfData(String sheetName) throws Throwable, IOException {
	FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
	Workbook wb = WorkbookFactory.create(fis);
	int rowCount= wb.getSheet(sheetName).getLastRowNum()+1;
	Sheet sh = wb.getSheet(sheetName);
	int cellCount=wb.getSheet(sheetName).getRow(0).getLastCellNum();
	Object[][]obj=new Object[rowCount][cellCount];
	for(int i=0;i<rowCount;i++) {
		for(int j=0;j<cellCount;j++) {
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}
}