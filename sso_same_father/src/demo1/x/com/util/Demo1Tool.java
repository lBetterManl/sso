package demo1.x.com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo1Tool {

	// 与远程校验Action 通信
	public static String doGet(String url, String cookieName, String cookieValue){
		StringBuffer sb = new StringBuffer();
		HttpURLConnection httpUTLConnection = null;
		try{			
			URL urls = new URL(url+"?cookieName="+cookieName+"&cookieValue="+cookieValue);
			httpUTLConnection = (HttpURLConnection) urls.openConnection();
			httpUTLConnection.setRequestMethod("GET");
			httpUTLConnection.connect();
			InputStream in = httpUTLConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String temp = null;
			while((temp=br.readLine())!=null){
				sb.append(temp);
			}
			br.close();
			isr.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpUTLConnection != null){
				httpUTLConnection.disconnect();
			}
		}
		return sb.toString();
	}
}
