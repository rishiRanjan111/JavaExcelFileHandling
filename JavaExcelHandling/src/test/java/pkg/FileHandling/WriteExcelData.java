package pkg.FileHandling;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteExcelData {
	
	public void writeExcelFile() throws IOException, RowsExceededException, WriteException {
		File f = new File("../JavaExcelHandling/writeExcelData.xls");
		WritableWorkbook wk = Workbook.createWorkbook(f);
		WritableSheet ws = wk.createSheet("Rishi", 0);
		
		for (int i=0; i<3; i=i+1) {
			for (int j=0; j<3; j=j+1) {
				Label L = new Label(j, i, "India");
				ws.addCell(L);
			}
			
		}
		wk.write();
		wk.close();

	}

	public static void main(String[] args) throws RowsExceededException, WriteException, IOException {
		WriteExcelData wd = new WriteExcelData();
		wd.writeExcelFile();
		

	}

}
