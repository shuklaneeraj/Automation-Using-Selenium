package com.dxc.sale.test.framework.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelLib {
	
	final static Logger log = LogManager.getLogger(ExcelLib.class);
	
	private Workbook workbook;
	private Sheet worksheet;
	private int rows;
	private String testCaseName;
	private int testCaseStartRow = 0;
	private int testCaseEndRow=0;
	private int usedColumnsCount = 0;
	private int iterationCount = 0;
	
	public ExcelLib(String workSheetName, String testCaseName) {
		this.workbook = initTestDataFile();
		this.worksheet = workbook.getSheet("Sheet1");
		this.testCaseName = testCaseName;
		rows = getRowCount();
		testCaseStartRow = getTestCaseStartRow();
		testCaseEndRow = getTestCaseEndRow();
		usedColumnsCount = getUsedColumnsCount();
		iterationCount = getIterationCount();
	}
	
	private XSSFWorkbook initTestDataFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("Input_Data.xlsx").getFile());
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (InvalidFormatException e) {
			log.error("Error in loadTestData :" ,e);
			throw new RuntimeException(e);
		} catch (IOException e) {
			log.error("Error in loadTestData :" ,e);
			throw new RuntimeException(e);
		}
		return workbook;
	}

	private int getIterationCount(){
		try {
			System.out.println("Sart Row :"  + testCaseStartRow + " End Row :" + testCaseEndRow);
			for(int i =testCaseStartRow; i <= testCaseEndRow; i++){
				if(getCellData(usedColumnsCount,i).equalsIgnoreCase("Yes")){
					iterationCount++;
				}
			}
		} catch (Exception e) {
			log.error("Error in getIterationCount",e);
			throw new RuntimeException(e);
		}
		if(iterationCount > 0){
			log.debug("*************************************************************************************");
			log.debug("Total number of iterations selected for test script: '"+testCaseName+"' is"+" "+iterationCount);	
			log.debug("*************************************************************************************");
		}else{
			log.debug("*************************************************************************************");
			log.debug("Total number of iterations selected is 0. Please check execute column in TestData.xls file");
			log.debug("*************************************************************************************");
		}
		
		return iterationCount;
	}
	
	/*Return Two Dimensional Array to DataProvider*/	
	public Object[][] getTestdata(){
		int row = 0;
		int col = 0;
		String data[][] = new String[iterationCount][usedColumnsCount-1];
		//Get the Test Data
		for(int i =testCaseStartRow; i <= testCaseEndRow; i++){
			col = 0;
			boolean flag = false;
			String cellData = getCellData(usedColumnsCount,i);
			if(cellData.equalsIgnoreCase("Yes")){
				flag = true;
				for(int j = 1; j < usedColumnsCount; j++){
					data[row][col] = getCellData(j, i);
					col++;
				}
			}
			if(flag){
				row++;
			}
		}
		return data;
	}
	
	/*Get Cell Data*/
	@SuppressWarnings("deprecation")
	private String getCellData(int col, int row) {
		String value = "";
		Row rowObj = worksheet.getRow(row);
		Cell cellObj = rowObj.getCell(col);
		if(cellObj != null) {

			if(cellObj.getCellType()==CellType.STRING) 
				value = cellObj.getStringCellValue(); 
			else if(cellObj.getCellType()==CellType.NUMERIC) 
//			cellObj.setCellType(CellType.STRING);
//			int value1 = Integer.parseInt(cellObj.getStringCellValue());
//			System.out.println("hi"+value1);
			 value = String.valueOf((long)cellObj.getNumericCellValue());
			//String.valueOf(value);
			
			

		}
		
		return value;
	}
	
	/*Get TestCase Start Row*/
	private int getTestCaseStartRow(){
		try {
			for(int i = 0; i <= rows; i++){
				Row row = worksheet.getRow(i);
				if(row != null) {
					Cell cell = row.getCell(0);
					if(cell != null) {
						String columnName = cell.getStringCellValue();
						if(columnName.equals(testCaseName.trim())){
							testCaseStartRow = i;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("Error in getTestCaseStartRow",e);
			throw new RuntimeException(e);
		}
		return testCaseStartRow;
	}
	
	/*Get Test Case End Row*/
	private int getTestCaseEndRow(){
		try {
			for(int i = 0; i <= rows; i++){
				Row row = worksheet.getRow(i);
				if(row != null) {
					Cell cell = row.getCell(0);
					if(cell != null) {
						String columnValue = cell.getStringCellValue();
						if(columnValue.equals(testCaseName.trim())){
							testCaseEndRow = i;
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("Error in getTestCaseEndRow",e);
			throw new RuntimeException(e);
		}
		return testCaseEndRow;
	}
	
	/*Get the Columns Count for the referenced test case*/
	private int getUsedColumnsCount(){
		try {
			int count = 0;
			Row row = worksheet.getRow(testCaseStartRow-1);
			int cellNum  = row.getLastCellNum();
			for(int i=0 ; i < cellNum ; i++) {
				Cell cell = row.getCell(i);
				usedColumnsCount = count++;
				if(cell != null) {
					String cellVal = cell.getStringCellValue();
					if("Execute".equals(cellVal)) {
						break;
					}
				}
			}
		} catch (Exception e) {
			log.error("Error in getUsedColumnsCount",e);
			throw new RuntimeException(e);
		}
		return usedColumnsCount;
	}
	
	/*Gets the total number of row count in the excel sheet*/
	private int getRowCount() {
		return worksheet.getLastRowNum();
	}

}
