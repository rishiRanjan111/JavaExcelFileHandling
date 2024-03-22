package pkg.FileHandling;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

//Assignment 1
public class ReadExeclDataParticularCell {
	
	public void ReadDataBasedUponRowNoAndColumnNo(int columnNo,int rowNo) throws BiffException, IOException {
		File f = new File("../JavaExcelHandling/excelData.xls"); // connection
		 Workbook wk = Workbook.getWorkbook(f); //workbook object
		 Sheet ws = wk.getSheet(0); //sheet object
		 int r = ws.getRows(); // row
		 int c = ws.getColumns(); //column
		 
		 
		 for (int i=0; i<r; i=i+1) {   //row loop
			 for (int j=0; j<c; j=j+1) { //column loop
				 if ((i==rowNo)&& (j==columnNo)) {
					 Cell wc = ws.getCell(j, i);   // cell object
					 System.out.println(wc.getContents()); 
				 }
			 }
		 }	
	}
	public static void main(String[] args) throws BiffException, IOException {
		ReadExeclDataParticularCell rd = new ReadExeclDataParticularCell();
		rd.ReadDataBasedUponRowNoAndColumnNo(3, 1);
		
	}

}
