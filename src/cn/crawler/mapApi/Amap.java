package cn.crawler.mapApi;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Amap {
	public static void main(String args[]) {
		
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		try {
			
			HashMap<String,String> map = new HashMap<String,String>();
			
			String company = URLEncoder.encode("北京大学","utf-8");
			String city = URLEncoder.encode("北京","utf-8");
			
			//spider3 58d298e40df17c748afd1945e098b160
			url = new URL("http://restapi.amap.com/v3/place/text?key=58d298e40df17c748afd1945e098b160&keywords=" + company + 
					"&types=高等院校&city=" + city +"&children=1&offset=20&page=1&extensions=all");

					
					
			// ��get��ʽ����
			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setRequestMethod("GET");

			// ��ȡ��������
			BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(
					httpurlconnection.getInputStream(), "utf-8"));

            String line = null;
            String re_com = null;
            String re_add = null;
            while ((line = inputStreamReader.readLine()) != null) {
            	System.out.println(line);
            	/*
            	if(line.contains("name"))
            	{
            		String buffer1[] = line.split(",");
            		String buffer2[] = buffer1[0].split(":");
            		re_com = buffer2[1];
            	}
            	else if(line.contains("address"))
            	{
            		String buffer1[] = line.split(",");
            		String buffer2[] = buffer1[0].split(":");
            		re_add = buffer2[1];
            	}
            	*/
            }
			
            map.put(re_com, re_add);
       
            System.out.println(map);
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (httpurlconnection != null)
				httpurlconnection.disconnect();
		}

	}
}
