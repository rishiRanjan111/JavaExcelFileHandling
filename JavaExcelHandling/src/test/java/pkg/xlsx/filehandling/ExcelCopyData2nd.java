package pkg.xlsx.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCopyData2nd {
	
	public void excelCopyData() throws IOException {
		File inputfile = new File("../JavaExcelHandling/WriteExceldata.xlsx");  //read file connection
		File outputfile =new  File("../JavaExcelHandling/copywrite2.xlsx"); //write file connection
		FileInputStream fi = new FileInputStream(inputfile);  //fileinputstream object
		FileOutputStream fo = new FileOutputStream(outputfile); //FileOutputstream object
		XSSFWorkbook xw = new XSSFWorkbook(fi);  // input workbook object
		XSSFWorkbook xw1 = new XSSFWorkbook(); //output workbook obejct
		XSSFSheet inputsheet =xw.getSheet("Rishi");		
		XSSFSheet outputsheet = xw1.createSheet("Sheet1"); //output sheet object
		
		int rowCount = inputsheet.getPhysicalNumberOfRows();//gets the total number of rows in the input Excel shee
        for (int i = 0; i < rowCount; i++) { //loop iterates over each row in the input sheet
        	XSSFRow inputRow = inputsheet.getRow(i); //gets the current row from the input sheet (inputRow) 
        	XSSFRow outputRow = outputsheet.createRow(i); //creates a corresponding row in the output sheet (outputRow).
        	    
//            if (inputRow != null) { //It checks if the current input row is not null.
                int columnCount = inputRow.getPhysicalNumberOfCells();
                for (int j = 0; j < columnCount; j++) {               	
                	XSSFCell xc = inputRow.getCell(j);
                	XSSFCell xc1 = outputRow.createCell(j);
                	xc1.setCellValue(xc.getStringCellValue());
                
                
                
                }
                    }
		xw1.write(fo);
		fo.flush();
		fo.close();

}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelCopyData2nd cd = new ExcelCopyData2nd();
		cd.excelCopyData();

	}

}
