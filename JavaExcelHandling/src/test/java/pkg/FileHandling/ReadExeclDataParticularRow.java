package pkg.FileHandling;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
//Assignment 2
public class ReadExeclDataParticularRow {
	public void ReadDataBasedUponRowNo(int rowNo) throws BiffException, IOException {
		File f = new File("../JavaExcelHandling/excelData.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet ws = wk.getSheet(0);
		int r=ws.getRows();
		int c=ws.getColumns();
		
		
		if (rowNo < r) {
            // Loop through cells in the specified row
            for (int j = 0; j < c; j++) {
                Cell wc = ws.getCell(j, rowNo); // cell object
                System.out.println(wc.getContents());
            }
        }

	}

	public static void main(String[] args) throws BiffException, IOException {
		ReadExeclDataParticularRow rd= new ReadExeclDataParticularRow();
		rd.ReadDataBasedUponRowNo(1);
		

	}

}
