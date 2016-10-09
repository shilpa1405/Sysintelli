package com.sysintelli.ws.rs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class httpclass {

	public static void main(String[] args) {
	try {
		DefaultHttpClient httpClient = new DefaultHttpClient();

		JSONObject obj = new JSONObject();
		obj.put("path", "/rest");
		obj.put("include_media_info", false);
		obj.put("recursive", false);
		obj.put("include_deleted", false);
		obj.put("include_has_explicit_shared_members", false);
		StringEntity ee =new StringEntity(obj.toString());
		HttpPost postRequest = new HttpPost("https://api.dropboxapi.com/2/files/list_folder");

		postRequest.addHeader("Authorization","Bearer kmS_5nz0CVAAAAAAAAAE7uveQtYjUfa8HMtLwf6c9-YgF1chXNkfpCEBaO-eNves");
		postRequest.addHeader("Content-Type", "application/json");
		postRequest.setEntity(ee);

		HttpResponse response = httpClient.execute(postRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatusLine().getStatusCode());
		}

		String json = EntityUtils.toString(response.getEntity());
		
		
		System.out.println(json);
		
	} catch (JSONException | IOException e) {
	
		e.printStackTrace();
	}
	
	}	
}
