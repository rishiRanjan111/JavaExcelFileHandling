package pkg.xlsx.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCopydata {
    
    public void excelCopyData() throws IOException {
        File inputfile = new File("../JavaExcelHandling/readExcelDataNumeric.xlsx");  //read file connection
        File outputfile =new  File("../JavaExcelHandling/copywrite1.xlsx"); //write file connection
        FileInputStream fi = new FileInputStream(inputfile);  //fileinputstream object
        XSSFWorkbook xw = new XSSFWorkbook(fi);  // input workbook object
        XSSFSheet inputsheet = xw.getSheet("Sheet1"); //input sheet object
        FileOutputStream fo = new FileOutputStream(outputfile); //FileOutputstream object
        XSSFWorkbook xw1 = new XSSFWorkbook(); //output workbook object
        XSSFSheet outputsheet = xw1.createSheet("Rishi"); //output sheet object
        
        int rowCount = inputsheet.getPhysicalNumberOfRows();//gets the total number of rows in the input Excel sheet
        for (int i = 0; i < rowCount; i++) { //loop iterates over each row in the input sheet
            XSSFRow inputRow = inputsheet.getRow(i); //gets the current row from the input sheet (inputRow) 
            XSSFRow outputRow = outputsheet.createRow(i); //creates a corresponding row in the output sheet (outputRow).
                
            if (inputRow != null) { //It checks if the current input row is not null.
                int columnCount = inputRow.getPhysicalNumberOfCells();
                for (int j = 0; j < columnCount; j++) {
                    XSSFCell outputCell = (XSSFCell) outputRow.createCell(j); //creates a new cell (outputCell) in the output row (outputRow) at the specified column index j and and casts it explicitly to XSSFCell..
                    XSSFCell inputCell = (XSSFCell) inputRow.getCell(j); // gets the cell (inputCell) from the input row (inputRow) at the same column index j and casts it explicitly to XSSFCell.
                    double cellValue = inputCell.getNumericCellValue(); //retrieves  numeric value of inputCell as a double (cellValue)
                    outputCell.setCellValue(cellValue); // sets the cell value in the output cell (outputCell)
                }
            }
        }
        xw1.write(fo);
        fo.flush();
        fo.close();
        fi.close(); // Close input file stream
    }

    public static void main(String[] args) throws IOException {
        ExcelCopydata ec = new ExcelCopydata();
        ec.excelCopyData();
    }

}
