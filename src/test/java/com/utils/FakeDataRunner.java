package com.utils;

import com.api.pojo.CreateJobPojo;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problems;
import com.github.javafaker.Faker;

public class FakeDataRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateJobPojo createJob = TestUtility.getCreateJobRequestBody();
	System.out.println(TestUtility.toJson(createJob));
	}

}
