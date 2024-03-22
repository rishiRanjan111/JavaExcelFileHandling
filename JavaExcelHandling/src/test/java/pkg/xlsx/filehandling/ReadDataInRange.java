package pkg.xlsx.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataInRange {
	public void readDataBasedUponRange(int initialRow, int endRow) throws IOException {
		File f = new File("../JavaExcelHandling/ReadExcelData.xlsx");
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook xw = new XSSFWorkbook(fi);
		XSSFSheet xs = xw.getSheetAt(0);
		int r = xs.getPhysicalNumberOfRows();
		if ((initialRow>0) && (endRow<r)) {
			for (int i=initialRow; i<=endRow; i=i+1) {
				XSSFRow xr = xs.getRow(i);
				int c = xr.getPhysicalNumberOfCells();
				for (int j=0; j<c; j=j+1) {
					XSSFCell xc = xr.getCell(j);
					System.out.println(xc.getNumericCellValue());
				}
				
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		ReadDataInRange rd = new ReadDataInRange();
		rd.readDataBasedUponRange(2, 4);
	}

}
