package io.mosip.kernel.smsserviceprovider.nimba.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
import io.mosip.kernel.core.exception.UnsupportedEncodingException;

/**
 * 
 * @author condeis
 *
 */
public class NimbaMessageRequest {
	public static void send(String url, String contact, String message)
			throws UnsupportedEncodingException, MalformedURLException, IOException, JSONException {
		message = URLEncoder.encode(message, "ISO-8859-1");
		String https_url ="https://api.nimbasms.com/v1/messages"; //+ SmsPropertyConstant.RECIPIENT_NUMBER.getProperty() + "=" + contact + "&"
			//	+ SmsPropertyConstant.SMS_MESSAGE.getProperty() + "=" + message;
		 
			HttpURLConnection urlConnection = (HttpURLConnection) new URL(https_url).openConnection();
			urlConnection.setUseCaches(false);
			urlConnection.setDoOutput(true); // Triggers POST.
			urlConnection.setDoInput(true);
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("accept-charset", "ISO-8859-1");
			urlConnection.setRequestProperty("Authorization", "Basic ZWRiODA2NmJiZmNiMjMwNzQyNWE2YzU2YzBlMDA1NDc6RHNJejZqX3dDZDJZQThHOEFFRFIzRUk3UVFEQ0tsOEdMTmpQUXE3dHpvZ3UyaHFhOE40RkYzUWdMcHZ0RVlveENiQzB2UmtLTDZkQTNxWUlEZnR2S0kxZV9RZjIwY3RyWms2UU5tdGo4c1U=");
			urlConnection.setRequestProperty("Content-Type", "application/json");
			urlConnection.getInputStream();
		    JSONObject jsonParam = new JSONObject();
            jsonParam.put("to", contact);
            jsonParam.put("sender_name", "SMS 9080");
            jsonParam.put("message", "Ceci est un message test"+System.currentTimeMillis());
            
            OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
            wr.write(jsonParam.toString());
            wr.flush();
            BufferedReader in= new BufferedReader(new InputStreamReader(		urlConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
			/**
			 * try{
	            URL url = new URL("https://api.nimbasms.com/v1/messages");
	             
	            con.setRequestProperty("Authorization", "Basic ZWRiODA2NmJiZmNiMjMwNzQyNWE2YzU2YzBlMDA1NDc6RHNJejZqX3dDZDJZQThHOEFFRFIzRUk3UVFEQ0tsOEdMTmpQUXE3dHpvZ3UyaHFhOE40RkYzUWdMcHZ0RVlveENiQzB2UmtLTDZkQTNxWUlEZnR2S0kxZV9RZjIwY3RyWms2UU5tdGo4c1U=");
	             

	            con.setDoOutput(true);
	            con.setDoInput(true);

	           

	            JSONObject jsonParam = new JSONObject();
	            jsonParam.put("to", to);
	            jsonParam.put("sender_name", "SMS 9080");
	            jsonParam.put("message", "Ceci est un message test");

	            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
	            wr.write(jsonParam.toString());
	            wr.flush();

	          BufferedReader in= new BufferedReader(new InputStreamReader(con.getInputStream()));
	            String inputLine;
	            StringBuilder response = new StringBuilder();
	            while((inputLine = in.readLine()) != null){
	                response.append(inputLine);
	            }
	            in.close();
	            System.out.println(response.toString());
	        }catch(Exception e){
	            System.out.println(e);
	        }
	    }
	}
			 */
			
			
	}

}
