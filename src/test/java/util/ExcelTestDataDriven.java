package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.String;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestDataDriven {	
	public static ArrayList<String> getExcelData(String testCaseName) throws IOException {
    	ArrayList<String> loginDataArrayList = new ArrayList<>();
    	
    	FileInputStream inputFile = new FileInputStream(System.getProperty("user.dir") + "\\resources\\selenium_tests_excel_data.xlsx");
    	// Retrieve the Workbook Object
    	XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
    	int sheetsNumber = workbook.getNumberOfSheets();
    	String sheetName = "";
    	XSSFSheet testDataSheet = null;
    	
    	for (int i = 0; i < sheetsNumber; i++) {
    		if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
    			sheetName = workbook.getSheetName(i);
    			testDataSheet = workbook.getSheetAt(i);
    			
    			// Find where the 'Test Case' column is located
    			Iterator<Row> rows = testDataSheet.iterator();
    			Row rowFirst = rows.next();
    			Iterator<Cell> cells = rowFirst.cellIterator();
    			int counter = 0;
    			int columnIndex = 0;
    			
    			while (cells.hasNext()) {
    				Cell cell = cells.next();
    				
    				if (cell.getStringCellValue().equalsIgnoreCase("Test Case")) {
    					columnIndex = counter;
    					System.out.println("Test Case Column Index: " + columnIndex);
    				}
    				counter++;
    			}
    			
    			// Scan the whole 'Test Case' column to find required 'Test Case'
    			while (rows.hasNext()) {
    				Row row = rows.next();
    				
    				if (row.getCell(columnIndex).getStringCellValue().equalsIgnoreCase(testCaseName)) {
    					// Retrieve all data from the entire row of the 'Test Case' that has been found and use these data for tests
    					Iterator<Cell> loginCellsIterator = row.cellIterator();
    					
    					while (loginCellsIterator.hasNext()) {
    						Cell cell = loginCellsIterator.next();
    						
    						if (cell.getColumnIndex() != 0) {
    							if (cell.getCellType() == CellType.STRING) {
    								loginDataArrayList.add(cell.getStringCellValue());
    							} else {
    								loginDataArrayList.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	System.out.println("Workbook " + workbook + "\nNumber of Sheets: " + sheetsNumber + "\nRequired Sheet Name: " + sheetName);
    	System.out.println("Login Array Size: " + loginDataArrayList.size());
    	    	
    	inputFile.close();
    	workbook.close();
    	
    	return loginDataArrayList;
	}
}
