package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static Workbook wb;
	private static Sheet sheet;

	/**
	 * This method will open xlfile and specified sheet
	 * 
	 * @param filePath
	 * @param sheetName
	 */
	public static void openExcel(String filePath, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static int colsCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	public static String getCellData(int rowIndex, int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}

	/**
	 * This method will read any excel file and return data into the array
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public static Object[][] excelIntoArray(String filePath, String sheetName) {
		openExcel(filePath, sheetName);
		int rows = rowCount();
		int cols = colsCount();

		Object[][] data = new Object[rowCount() - 1][colsCount()];// using -1 so she doesn't print out the header

		for (int i = 0; i < rows; i++) {
			for (int y = 0; y < cols; y++) {
				data[i - 1][y] = getCellData(i, y);
			}
		}
		return data;

	}
}