package pkg.FileHandling;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

//Assignment 5

public class ExcelCopyData {
	
	public void ReadWriteExcel() throws BiffException, IOException, RowsExceededException, WriteException {
		File f = new File("../JavaExcelHandling/excelData.xls"); // connection
		Workbook wb = Workbook.getWorkbook(f); //workbook object
		Sheet sheet = wb.getSheet(0); //sheet object
		File f1 = new File("../JavaExcelHandling/writeExcelData.xls");
		WritableWorkbook wk = Workbook.createWorkbook(f1);
		WritableSheet ws = wk.createSheet("Rishi", 0);
		int r = sheet.getRows(); // row
		int c = sheet.getColumns(); //column
		
		
		for (int i=0; i<r; i=i+1) {   //row loop
			 for (int j=0; j<c; j=j+1) { //column loop
				Cell wc = sheet.getCell(j, i);   // cell object
				Label L = new Label(j, i, wc.getContents());
				ws.addCell(L);
			 }
		 }
		wk.write();
		wk.close();
		
	}

	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException {
		ExcelCopyData ec = new ExcelCopyData();
		ec.ReadWriteExcel();
		
	}

}
