package pkg.FileHandling;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelDataInRange {
	
	public void ReadDataBasedUponRange(int initialRowNo, int endRowNo) throws BiffException, IOException {
		File f = new File("../JavaExcelHandling/excelData.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet ws = wk.getSheet(0);
		int r=ws.getRows();
		
		if((initialRowNo > 0) && (endRowNo < r)) {
			for (int i=initialRowNo; i<=endRowNo; i=i+1) {
				Cell[] rowCells = ws.getRow(i); // Get the cells of the specified row
	            for (Cell cell : rowCells) {
	                System.out.println(cell.getContents());
	            }
			}
		}
		else {
			System.out.println("Invalid row Range");
		}
	}
	public static void main(String[] args) throws BiffException, IOException {
		ReadExcelDataInRange ed = new ReadExcelDataInRange();
		ed.ReadDataBasedUponRange(2, 4);
	}

}
