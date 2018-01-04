package com.admin.otp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*import java.io.OutputStreamWriter;*/
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/*import java.net.URLEncoder;*/

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class AccountVerficationSMS {

/*private static final String USERNAME="rvcinfo9600@gmail.com";
private static final String PASSWORD="Ranjit9600"*/;

private String msg;
public AccountVerficationSMS(String mobile_no,int otp) {
	
	//msg="httpapi/send?username="+USERNAME+"&password="+PASSWORD+"&sender_id=SMSIND&route=T&phonenumber="+u.getMobileno()+"&message=Dear%20"+u.getName()+"%2C%20Thanks%20for%20registering%20to%20our%20site.%20Your%20user%20id%20is%20"+u.getMobileno()+"%20your%20account%20verfication%20OTP%20is%20"+otp+"%20";
	//String msg1="httpapi/send?username=rvcinfo9600@gmail.com&password=Ranjit9600&sender_id=SMSIND&route=T&phonenumber="+mobile_no+"&message=Dear%20Admin%2C%20OTP%20for%20forget%20password%20recovery%20is%20"+String.valueOf(otp)+"%20";
	msg="httpapi/send?username=rvcinfo9600@gmail.com&password=Ranjit9600&sender_id=SMSIND&route=T&phonenumber="+mobile_no+"&message=Dear%20Admin%2C%20OTP%20for%20forget%20password%20recovery%20is%20"+String.valueOf(otp)+"%20";
	sendMessage();

}


	

	private void sendMessage() {

		try {

			final TrustManager[] trustAllCerts = new TrustManager[] { 
					new X509TrustManager() 
					{
						@Override
						public void checkClientTrusted( final X509Certificate[] chain, final String authType ) {
						}
						@Override
						public void checkServerTrusted( final X509Certificate[] chain, final String authType ) {
						}
						@Override
						public X509Certificate[] getAcceptedIssuers() {
							return null;
						}
					} };
			


			final SSLContext sslContext = SSLContext.getInstance( "SSL" );
			sslContext.init( null, trustAllCerts, new java.security.SecureRandom() );

			final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
			HttpsURLConnection.setDefaultSSLSocketFactory( sslContext.getSocketFactory() );
			URL url = new URL(getURLPath());
			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			int responseCode = conn.getResponseCode();
			//System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getURLPath() {
		
		String twar = getURL()+msg;
		return twar;
	}

	private String getURL() {

		return "http://smsc.biz/";
	}
}
