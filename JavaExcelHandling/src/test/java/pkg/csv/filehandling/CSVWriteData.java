package pkg.csv.filehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriteData {
	public void writeCSVData() throws IOException {
		File f = new File("../JavaExcelHandling/csvWriteData.csv");
		FileWriter fw = new FileWriter(f);
		BufferedWriter b = new BufferedWriter(fw);
		System.out.println("Enter the string data:");
		Scanner sc = new Scanner(System.in);
		String Data;
		for (int i=0; i<4; i=i+1) {
			for (int j=0; j<4; j=j+1) {
				Data = sc.next();
				b.write(Data);
				b.write(",");
			}
			b.newLine();
		}
		b.close();
		sc.close();
	}
	

	public static void main(String[] args) throws IOException {
		CSVWriteData cw = new CSVWriteData();
		cw.writeCSVData();

	}

}
