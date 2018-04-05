package www.a.com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Demo1Tool {

	// 与远程校验Action 通信
	public static String doGet(String url, Map<String, String> map){
		StringBuffer sb = new StringBuffer();
		HttpURLConnection httpUTLConnection = null;
		try{
			StringBuffer t_s = new StringBuffer(url).append("?");
			for(Map.Entry<String, String> entry:map.entrySet()){
				t_s.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
			}
			url = t_s.substring(0, t_s.length()-1);
			URL urls = new URL(url);
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
