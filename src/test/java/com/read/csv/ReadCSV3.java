package com.read.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSV3 {

	public static void main(String[] args) throws IOException, CsvException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
	//1//	
		File file = new File(System.getProperty("user.dir") +"\\testData\\loginData.csv");
		FileReader fileReader = new FileReader(file);//3
		
		CSVReader csvReader = new CSVReader(fileReader);//2
		List<String[]> myList = csvReader.readAll();
		
		for (String [] dataArray  : myList) {
			for (String d:dataArray) 
			{
				System.out.print(d+" ");
			}
			{
			System.out.println(" ");
			} 	
		}

	}
}