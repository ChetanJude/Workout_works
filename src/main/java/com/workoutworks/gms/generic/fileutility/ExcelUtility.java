package com.workoutworks.gms.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(".\\testdata\\workoutworkstestscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}

	public String setDataintoExcel(String sheet, int row, int cell, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(".\\testdata\\workoutworkstestscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos= new FileOutputStream(".\\testdata\\workoutworkstestscript.xlsx");
		wb.write(fos);
		wb.close();
		return data;
	}

	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(".\\testdata\\workoutworkstestscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return rowcount;
	}
}
