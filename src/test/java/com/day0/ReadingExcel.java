package com.day0;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
	/*	// TODO Auto-generated method stub
	 * 
		// Apache POI Snippet for getting one data from an excel sheet 
		XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir")+"//testData//TestData.xls.xlsx");
		XSSFSheet loginSheet = workbook.getSheet("Login");//Login is the name of the sheet
		XSSFRow myRow = loginSheet.getRow(1);
		XSSFCell myCell = myRow.getCell(0);
		System.out.println(myCell.toString());
		
		Reading ALL the excel file
	*/
		XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir")+"//testData//TestData.xls.xlsx");
		XSSFSheet loginSheet = workbook.getSheet("Login");//Login is the name of the sheet
		
		int lastRowIndex = loginSheet.getLastRowNum(); //to know the total number of Row or index
		System.out.println(lastRowIndex);
		
		XSSFRow rowHeader = loginSheet.getRow(0);	//To know the total number of columns 
		int totalNumberOfCols = rowHeader.getLastCellNum();
		System.out.println(totalNumberOfCols);
		
		XSSFRow myRow;
		XSSFCell myCell;
// when asked in an interview how to read an excel file and store it into a 2d array. The Reason why we used a 2D 
//array is because it contains only rows and columns we cannot use 3D as it is row,col,depth which excel doesn't have.
		String myArray[][] = new String [lastRowIndex + 1][totalNumberOfCols]; // Parsing to 2D array 
		for (int rowIndex = 0; rowIndex <= lastRowIndex; rowIndex++) {
			myRow = loginSheet.getRow(rowIndex);
		for(int cellIndex = 0; cellIndex < totalNumberOfCols; cellIndex++) {
			myCell = myRow.getCell(cellIndex);
			
			myArray[rowIndex][cellIndex] = myCell.toString();
		}	
		} // This second for loop was removed while parsing to the TestUtility . it is just to show 
// you why it is a 2D array because there is two for loops within each other
		
		for (int rowIndex = 0; rowIndex <= lastRowIndex; rowIndex++) {
			for(int cellIndex = 0; cellIndex < totalNumberOfCols; cellIndex++) {
				System.out.println(myArray[rowIndex][cellIndex]);
		}
	}
	}
}
