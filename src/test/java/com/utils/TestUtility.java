package com.utils;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.pojo.CreateJobPojo;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.JobAssignmentRequestBodyPojo;

import com.api.pojo.LoginPojo;
import com.api.pojo.Problems;
import com.api.pojo.SupLoginPojo;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtility {


	public static String toJson (Object src) { //from java to json = serialization
	Gson gson = new Gson();  
	String data = gson.toJson(src);
	return data;
	
	}
	public static CreateJobPojo getCreateJobRequestBody(){ 
Faker faker = new Faker();
		
		Customer customer = new Customer(faker.name().firstName(), faker.name().lastName(), 
				faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), 
				faker.internet().emailAddress(), faker.internet().emailAddress());
		
		faker.numerify("########");
		CustomerAddress customer_address = new CustomerAddress(faker.address().buildingNumber(), 
				faker.address().streetName(), faker.address().streetName(), faker.address().streetAddress(),
				faker.address().streetAddress(), faker.numerify("########"), "India" , "Maharastra") ;
		
		String imei = faker.numerify("###############");
	    CustomerProduct customer_product = new CustomerProduct ("2023-02-05T18:30:00.000Z", imei, imei,
	    		imei, "2023-02-05T18:30:00.000Z", 1, 1);
	    
	    Problems[] problems = new Problems[1];
		problems[0] = new Problems(1, "phone is not working");
		
		CreateJobPojo createJob = new CreateJobPojo(0, 2, 1, 1, customer, customer_address, customer_product,problems);
		System.out.println(TestUtility.toJson(createJob));
		return createJob;
	}	
		
	public static LoginPojo loginpojo() {
			LoginPojo login = new LoginPojo("imfd", "password");
			System.out.println(TestUtility.toJson(login));
			return login;	
		}
		
	/*There are two ways to find hard coded authorization Enum is one then ITestContext. Check
	* CreatejobApiTestITestContext. for me it is preferable 
	*/
	public static String getAuthToken(Role role) {
		LoginPojo loginpojo = null;
		if(role== Role.FD) {
			
			loginpojo = new LoginPojo("iamfd", "password");
		}	
		else if (role== Role.SUP) {
			
		loginpojo = new LoginPojo("iamsup", "password");
		}
		else if (role== Role.ENG) {
			
		loginpojo = new LoginPojo("iameng", "password");
		}
		else if (role==Role.QC) {
			
		loginpojo = new LoginPojo("iamqc", "password");
	}	
		 String loginRequestBody = TestUtility.toJson(loginpojo);
		 Response response = given()
		 				.header(new Header("Content-Type", "application/json"))
		 				.body("{\r\n"
						 		+ "    \"username\": \"iamfd\",\r\n"
						 		+ "    \"password\": \"password\"\r\n"
						 		+ "}")
						.post("/login");
		 System.out.println(response.asPrettyString());
		 JsonPath jsonPath = new JsonPath(response.asPrettyString());
		 String token = jsonPath.getString("data.token");
		 System.out.println(token);
		 return token;
		 
	}
	public static JobAssignmentRequestBodyPojo jobAssignmentRequest() {
	JobAssignmentRequestBodyPojo jobAssignmentRequestBodyPojo = new JobAssignmentRequestBodyPojo(23204, 17);
	System.out.println(TestUtility.toJson(jobAssignmentRequestBodyPojo));
	return jobAssignmentRequestBodyPojo;
	}
	
	public static SupLoginPojo supLoginBodyPojo(){
		SupLoginPojo supLoginPojo = new SupLoginPojo("iamsup", "password");
		System.out.println(TestUtility.toJson(supLoginPojo));
		return supLoginPojo;
	}
	

	public static Iterator<String[]> readCSVFile(String filename) {
		File file = new File(System.getProperty("user.dir") + "//testData//" + filename);
		FileReader reader = null;
		CSVReader csvReader;
		List<String[]> dataList =null;
		try {
			reader = new FileReader(file);
			csvReader = new CSVReader(reader);
			dataList = csvReader.readAll();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid File Path. Please Check your Filename and path"); 
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot Open The File");
			
		}catch (CsvException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid CSV File");
		}
		Iterator<String[]> dataIterator = dataList.iterator();
		 dataIterator.next(); // allows testing to start from the next role after its heading
		return dataIterator;

	}

	public static String[][] readExcelFile(String fileName, String sheetName) {
							//Input the filename and sheetName in both spaces that shows fileName and sheetName
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(System.getProperty("user.dir")+ "//testData//"+fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet loginSheet = workbook.getSheet(sheetName);//Login is the name of the sheet
		
		int lastRowIndex = loginSheet.getLastRowNum(); //to know the total number of Row or index
		System.out.println(lastRowIndex);
		
		XSSFRow rowHeader = loginSheet.getRow(0);	//To know the total number of columns 
		int totalNumberOfCols = rowHeader.getLastCellNum();
		System.out.println(totalNumberOfCols);
		
		XSSFRow myRow;
		XSSFCell myCell;
		String myArray[][] = new String [lastRowIndex][totalNumberOfCols]; // Parsing to 2D array 
		for (int rowIndex = 1; rowIndex <= lastRowIndex; rowIndex++) {
			myRow = loginSheet.getRow(rowIndex);
		for(int cellIndex = 0; cellIndex < totalNumberOfCols; cellIndex++) {
			myCell = myRow.getCell(cellIndex);
			
			myArray[rowIndex - 1][cellIndex] = myCell.toString();
		}	
		
	}
	return myArray;
	}
}
