package com.sysintelli.ws.rs;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Restclient {

	public static void main(String[] args) {
		
		try {
			Client client = Client.create();
			WebResource resource = client.resource("https://api.dropboxapi.com/2/files/list_folder");
			String input="{\"path\":\"/rest\"}";
			JSONObject obj = new JSONObject();
			obj.put("path", "/Friends ocu");
			obj.put("include_media_info", false);
			obj.put("recursive", false);
			obj.put("include_deleted", false);
			obj.put("include_has_explicit_shared_members", false);
			resource.header("Authorization", "Bearer kmS_5nz0CVAAAAAAAAAE7uveQtYjUfa8HMtLwf6c9-YgF1chXNkfpCEBaO-eNves");
			resource.header("Content-Type", "application/json");
			//resource.accept("application/json");
			
			ClientResponse response = resource.accept("application/json")
	                .post(ClientResponse.class, obj.toString());
			if (response.getStatus() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                    + response.getStatus());
	        }

	        // display response
	        String output = response.getEntity(String.class);
	        System.out.println("Output from Server .... ");
	        System.out.println(output + "\n");
			
		//	String response = resource.post(String.class, obj.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	

	}

}
