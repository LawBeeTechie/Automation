package com.read.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSV4 {

	public static void main(String[] args) throws IOException, CsvException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		File file = new File(System.getProperty("user.dir") + "\\testData\\loginData.csv");
		FileReader fileReader = new FileReader (file);
		CSVReader csvReader = new CSVReader(fileReader);
		List<String[]> data	=csvReader.readAll();
				
		for (String[] dataArray : data) {
			for (String d : dataArray)
			{
				System.out.print(d + " ");
			}{
				System.out.println("");
			}
			
		}
	}

}
