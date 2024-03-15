package pkg.FileHandling;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExeclDataParticularRow2 {
	public void ReadDataBasedUponRowNo(int rowNo) throws BiffException, IOException {
		File f = new File("../JavaExcelHandling/excelData.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet ws = wk.getSheet(0);
		int r=ws.getRows();
		
		if (rowNo < r) {
            Cell[] rowCells = ws.getRow(rowNo); // Get the cells of the specified row
            for (Cell cell : rowCells) {
                System.out.println(cell.getContents());
            }
        }

	}

	public static void main(String[] args) throws BiffException, IOException {
		ReadExeclDataParticularRow2 rd= new ReadExeclDataParticularRow2();
		rd.ReadDataBasedUponRowNo(1);
		

	}

}
