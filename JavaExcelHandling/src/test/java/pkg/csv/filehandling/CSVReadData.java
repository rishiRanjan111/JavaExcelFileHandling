package pkg.csv.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVReadData {
	
	public void readCSVData() throws IOException{
		File f = new File("../JavaExcelHandling/csvreadDatat.csv");
		FileReader fr = new FileReader(f);
		BufferedReader b = new BufferedReader(fr);
		String s;
		
		while((s=b.readLine())!=null) {
		String[] s1	= s.split(",");
		int L = s1.length;
		for (int i=0; i<L; i=i+1) {
			System.out.println(s1[i]);
		}
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		CSVReadData cs = new CSVReadData();
		cs.readCSVData();

	}

}
