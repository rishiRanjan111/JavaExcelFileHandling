package pkg.xlsx.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataParticularCell {
	
	public void readDataBasedUponRowNoAndColumnNo(int rowNo, int columnNo) throws IOException {
		File f = new File("../JavaExcelHandling/readExcelData.xlsx");
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook xw = new XSSFWorkbook(fi);
		XSSFSheet xs = xw.getSheetAt(0);
		int r = xs.getPhysicalNumberOfRows();
		for (int i = 0; i<r; i=i+1) {
			if (i==rowNo) {
				XSSFRow xr = xs.getRow(i);
				int c = xr.getPhysicalNumberOfCells();
				for (int j=0; j<c; j=j+1) {
					if (j==columnNo) {
					XSSFCell xc = xr.getCell(j);
					System.out.println(xc.getNumericCellValue());
				}
			}
			}
			}
	}

	public static void main(String[] args) throws IOException {
		ReadExcelDataParticularCell rd = new ReadExcelDataParticularCell();
		rd.readDataBasedUponRowNoAndColumnNo(1, 1);
		
	}

}
