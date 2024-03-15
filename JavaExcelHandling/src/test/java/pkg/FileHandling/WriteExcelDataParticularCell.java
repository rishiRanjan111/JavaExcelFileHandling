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

public class WriteExcelDataParticularCell {
    
    public void WriteData(int rowCount, int columnCount) throws IOException, RowsExceededException, WriteException {
        File f = new File("../JavaExcelHandling/writeExcelData.xls");
        WritableWorkbook wb = Workbook.createWorkbook(f);
        WritableSheet ws = wb.createSheet("Rishi", 0);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total row number: ");
        int totalRow = sc.nextInt(); 
        System.out.println("Enter the total column number: ");
        int totalColumn = sc.nextInt();
        System.out.println("Enter the String: ");
        String s = sc.next();
        
            
            // Validate if the provided row and column numbers are within bounds
        if (rowCount >= 0 && rowCount < totalRow && columnCount >= 0 && columnCount < totalColumn) {
                for (int i = 0; i < totalRow; i++) {
                    for (int j = 0; j < totalColumn; j++) {
                        if (i == rowCount && j == columnCount) {
                            Label L = new Label(j, i, s);
                            ws.addCell(L);
                        }
                    }
                }
                wb.write();
            } else {
                System.out.println("Invalid row or column number.");
            }
         {
            wb.close();
        }
    }

    public static void main(String[] args) throws RowsExceededException, WriteException, IOException {
        WriteExcelDataParticularCell wd = new WriteExcelDataParticularCell();
        wd.WriteData(4, 3);
    }
}
