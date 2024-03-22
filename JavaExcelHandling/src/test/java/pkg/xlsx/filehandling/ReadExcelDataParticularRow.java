package pkg.xlsx.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataParticularRow {
	public void readDataBasedUponRowNo(int rowNo) throws IOException {
		File f = new File("../JavaExcelHandling/ReadExcelData.xlsx");
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook xw = new XSSFWorkbook(fi);
		XSSFSheet xs = xw.getSheetAt(0);
		int r = xs.getPhysicalNumberOfRows();
		if (r>rowNo) {
		for (int i=0; i<r; i=i+1) {
			if(i==rowNo) {
				XSSFRow xr = xs.getRow(i);
				int c = xr.getPhysicalNumberOfCells();
				for (int j=0; j<c; j=j+1) {
					XSSFCell xc = xr.getCell(j);
					System.out.println(xc.getNumericCellValue());
				}
			}
		}
		}
	}

	public static void main(String[] args) throws IOException {
		ReadExcelDataParticularRow rd = new ReadExcelDataParticularRow();
		rd.readDataBasedUponRowNo(4);
	}

}
