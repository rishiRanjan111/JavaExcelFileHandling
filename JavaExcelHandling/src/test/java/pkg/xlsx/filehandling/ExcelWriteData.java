package pkg.xlsx.filehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteData {
	
	public void writeExcelData() throws IOException {
		File f =new  File("../JavaExcelHandling/WriteExceldata.xlsx"); // file connection
		FileOutputStream fo = new FileOutputStream(f); //FileOutputstream object
		XSSFWorkbook xw = new XSSFWorkbook(); //workbook obejct
		XSSFSheet xs = xw.createSheet("Rishi"); //sheet object
		
		for(int i=0; i<3; i=i+1) { // loop for row
			XSSFRow xr = xs.createRow(i); // row object
			for (int j=0; j<3; j=j+1) { //loop for column
				XSSFCell xc = xr.createCell(j);
				xc.setCellValue("India");
				 
			}
		}
		xw.write(fo);// move the data from excel to output stream
		fo.flush(); // move data from stram to file
		fo.close(); // closing the file
	}

	public static void main(String[] args) throws IOException {
		ExcelWriteData ed = new ExcelWriteData();
		ed.writeExcelData();

	}

}
