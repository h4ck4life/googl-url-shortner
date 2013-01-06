package org.muveo.android.googlURLShortener;

import org.muveo.android.googlURLShortener.GooglURLShortenerException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class GooglURLInsert {
	
	String inputLongURL;
	String inputApiKey;
	String resultShortURL;

	final String API_ENDPOINT;
	
	public GooglURLInsert() {
		API_ENDPOINT = "https://www.googleapis.com/urlshortener/v1/url";
	}
	
	public GooglURLInsert(String longURL) {
		this();
		if (!longURL.equals("")) {
			this.setLongURL(longURL);
		}
	}
	

	public GooglURLInsert(String longURL, String apiKey) {
		this();
		if (!longURL.equals("")) {
			this.setLongURL(longURL);
		}
		if (!apiKey.equals("")) {
			this.setApiKey(apiKey);
		}
	}
	
	public void send() throws GooglURLShortenerException {
		if (getApiKey().isEmpty()) {
			throw new GooglURLShortenerException("API Key not specified. Please call setApiKey() on your instance.");
		} else if (getLongURL().isEmpty()) {
			throw new GooglURLShortenerException("URL to be shortened not specified. Please call setLongUrl() on your instance.");
		} else {
			HashMap<String, String> api_payload = new HashMap<String, String>();
			api_payload.put("longUrl", this.getLongURL());
			api_payload.put("key", this.getApiKey());
			JSONObject json_api_payload = new JSONObject(api_payload);
			String api_response = postData(json_api_payload.toString());
			try {
				JSONObject json_api_response = new JSONObject(api_response);
				this.setResult(json_api_response.getString("id"));
			} catch (JSONException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public String sendWithoutKey() throws GooglURLShortenerException  {
		if (getLongURL().isEmpty()) {
			throw new GooglURLShortenerException("");
		} else {
			
		}
		return "WIBBLE";
	}
	
	private String postData (String inputJSON) {
	    // Create a new HttpClient and Post Header
	    HttpClient http_client = new DefaultHttpClient();
	    HttpPost http_post = new HttpPost(API_ENDPOINT);
	    String response_string = "API_FAIL";

	    try {
	        http_post.setEntity(new StringEntity(inputJSON));
	        http_post.setHeader("Accept", "application/json");
	        http_post.setHeader("Content-type", "application/json");
	        // Execute HTTP Post Request
	        ResponseHandler<String> responseHandler = new BasicResponseHandler();
	        return response_string = http_client.execute(http_post, responseHandler);
	    } catch (ClientProtocolException e) {
			e.printStackTrace();
	    } catch (IOException e) {
			e.printStackTrace();
	    } finally {
	    	http_client = null;
	    	http_post = null;
	    }
	    return response_string;
	}

	public String getLongURL() {
		return inputLongURL;
	}

	public void setLongURL(String longURL) {
		this.inputLongURL = longURL;
	}

	public String getApiKey() {
		return inputApiKey;
	}

	public void setApiKey(String apiKey) {
		this.inputApiKey = apiKey;
	}
	
	public String getResult() {
		return resultShortURL;
	}

	private void setResult(String resultShortURL) {
		this.resultShortURL = resultShortURL;
	}
}