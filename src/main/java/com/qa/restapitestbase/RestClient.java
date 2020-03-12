package com.qa.restapitestbase;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.sun.xml.internal.stream.Entity;

import jdk.nashorn.api.scripting.JSObject;

public class RestClient {
	       
	  public void getCall(String Url) throws ClientProtocolException, IOException {
		  CloseableHttpClient httpclient = HttpClients.createDefault();
		  HttpGet httpGet=new HttpGet(Url);
		  CloseableHttpResponse closeableHttpResponse=httpclient.execute(httpGet);
		  int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		  System.out.println("Status Code Of GetCall::"+statusCode);
		  String stringResponse = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		  JSONObject jsonObject=new JSONObject(stringResponse);
		  System.out.println("Json::"+jsonObject);
		  Header[] headerArray = closeableHttpResponse.getAllHeaders();
		  HashMap<String, String> allHeader=new HashMap<String, String>();
		  for(Header header: headerArray) {
			  allHeader.put(header.getName(), header.getValue());
		  }
		  System.out.println("All Header"+allHeader);
	  }

}
