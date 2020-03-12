package com.qa.restapitest.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.restapitestbase.RestClient;

public class RestApiGetCallTest {
	
	@BeforeMethod
	public void SetUp() {
		
		System.out.println("API Testing Start");
		
	}
	@Test
	public void getcallTest() throws ClientProtocolException, IOException {
		String Url="https://samples.openweathermap.org/data/2.5/weather?id=2172797&appid=b6907d289e10d714a6e88b30761fae22";
		RestClient restClient=new RestClient();
		restClient.getCall(Url);
		
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Api Testing Close");
	}

}
