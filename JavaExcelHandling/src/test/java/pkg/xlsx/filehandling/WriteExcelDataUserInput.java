package pkg.xlsx.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataUserInput {
	public void writeData(int rowCount, int columnCount) throws IOException {
		File f = new File("../JavaExcelHandling/writeExceldata.xlsx");
		FileOutputStream fo = new FileOutputStream(f);
		XSSFWorkbook xw = new XSSFWorkbook();
		XSSFSheet xs = xw.createSheet("Sheet1");
		Scanner sc=new Scanner(System.in);
		int data=0;
		System.out.println("Enter number: ");
		for (int i=0; i<rowCount; i=i+1) {
			XSSFRow xr = xs.createRow(i);
			for (int j=0; j<columnCount; j=j+1) {
				XSSFCell xc = xr.createCell(j);
				data = sc.nextInt();
				xc.setCellValue(data);
				
			}
			
		}
		xw.write(fo);
		fo.flush();
		fo.close();
	}

	public static void main(String[] args) throws IOException {
		WriteExcelDataUserInput rd= new WriteExcelDataUserInput();
		rd.writeData(2, 2);
	}

}
