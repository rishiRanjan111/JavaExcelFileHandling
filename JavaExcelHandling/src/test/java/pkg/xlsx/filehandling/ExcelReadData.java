package pkg.xlsx.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReadData {
	
	public void readExcelData() throws IOException {
		File f = new File("../JavaExcelHandling/readExcelData.xlsx");  //file connection
		FileInputStream fi = new FileInputStream(f);  //fileinputstream object
		XSSFWorkbook xw = new XSSFWorkbook(fi);  // xssfworkbook object
		XSSFSheet xs = xw.getSheetAt(0); //sheet object
		int r=xs.getPhysicalNumberOfRows(); // get row
		
		for (int i=0; i<r; i=i+1) {  // row loop
			XSSFRow xr = xs.getRow(i); //row object
			
			int c = xr.getPhysicalNumberOfCells();   //get cell
			for (int j=0; j<c; j=j+1) {  //loop on cell
				XSSFCell xc = xr.getCell(j);  // cell object 
				
				if (xc.getCellType() == Cell.CELL_TYPE_NUMERIC) {   // checking cell data is numeric
			    double numericValue = xc.getNumericCellValue();
			    System.out.println(numericValue);
			    
			} else if (xc.getCellType() == Cell.CELL_TYPE_STRING) {  //checking call data is string
			    String textValue = xc.getStringCellValue();
			    System.out.println(textValue);
			    
			}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		ExcelReadData ed = new ExcelReadData();
		ed.readExcelData();
		

	}

}
