package pkg.FileHandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

//Assignment 4
public class WriteExcelDataUserInput {
	
	public void WriteData(int rowCount, int columnCount) throws IOException, RowsExceededException, WriteException {
		File f =new  File("../JavaExcelHandling/writeExcelData.xls");
		WritableWorkbook wb = Workbook.createWorkbook(f);
		WritableSheet ws = wb.createSheet("Rishi", 0);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String: ");
		
		
		for (int i=0; i<rowCount; i=i+1) {
			for (int j=0; j<columnCount; j=j+1) {
				String s = sc.nextLine();
				Label L = new Label(j,i,s);
				ws.addCell(L);
			}
		}
		wb.write();
		wb.close();
	}

	public static void main(String[] args) throws RowsExceededException, WriteException, IOException {
		WriteExcelDataUserInput wd = new WriteExcelDataUserInput();
		wd.WriteData(4, 3);
		

	}

}
