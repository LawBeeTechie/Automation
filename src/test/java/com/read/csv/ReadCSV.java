package com.read.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ReadCSV {

	public static void main(String[] args) throws CsvValidationException, IOException {
		// TODO Auto-generated method stub
	//1//	
		File file = new File("C:\\Users\\buddha\\Documents\\TestAutoAca\\Java module\\AT_Practice_Apr2023\\testData\\loginData.csv");
		FileReader fileReader = new FileReader(file);//3
		
		CSVReader csvReader = new CSVReader(fileReader) ;
			String data[] = csvReader.readNext();
			
			for (String d:data) {
				System.out.print(d+" ");
			}	
			
}}