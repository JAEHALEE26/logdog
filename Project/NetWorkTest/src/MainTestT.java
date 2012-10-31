import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;


public class MainTestT {


	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://localhost:8888/score/post");
		
			ClientReportData Temp = new ClientReportData(1);
			Gson gson = new Gson();
	
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(
				"http://localhost:8888/score/post");
 
			StringEntity input = new StringEntity(gson.toJson(Temp));
			input.setContentType("application/json");
			postRequest.setEntity(input);
 
			HttpResponse response = httpClient.execute(postRequest);
			System.out.print(gson.toJson(new CallstackTest(1)));
			if (response.getStatusLine().getStatusCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader((response.getEntity().getContent())));
 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
 
			httpClient.getConnectionManager().shutdown();
 
			} catch (MalformedURLException e1) {
 
				e1.printStackTrace();
 
			} catch (IOException e) {
 
				e.printStackTrace();
 
			}
		
		
		
			
 
	}
		
		/*	List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("track", gson.toJson(Temp) ));
		//formparams.add(new BasicNameValuePair("param2", "value2"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
		httppost.setEntity(entity);
		
		
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entitys = response.getEntity();
		if (entity != null) {
		    InputStream instream = entitys.getContent();
		    try {
		        // do something useful
		    	System.out.println(EntityUtils.toString(entity));
		    	System.out.print(response.getStatusLine().getStatusCode());
		    	
		    } finally {
		        instream.close();
		    }
		}*/
		
		
		/*  	HttpParams myParams = new BasicHttpParams();
		    HttpConnectionParams.setConnectionTimeout(myParams, 10000);
		    HttpConnectionParams.setSoTimeout(myParams, 10000);

		//    String json=obj.toString();

		    try {

		     //   HttpPost httppost = new HttpPost(result.toString());
		        StringEntity se = new StringEntity(gson.toJson(Temp)); 
		        se.setContentEncoding(new BasicHeader("Content-type", "application/json"));
		        httppost.setEntity(se); 

		        HttpResponse response = httpclient.execute(httppost);
		        String temp = EntityUtils.toString(response.getEntity());
		   //     Log.i("tag", temp);
		        
		    	System.out.println(temp);
		    	System.out.print(response.getStatusLine().getStatusCode());


		    } catch (ClientProtocolException e) {

		    } catch (IOException e) {
		    }
		*/
	

}