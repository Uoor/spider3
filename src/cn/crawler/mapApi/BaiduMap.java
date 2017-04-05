package cn.crawler.mapApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import cn.util.CSVUtils;

//Place APIWeb服务API
public class BaiduMap {
	public static void main(String args[]) {
		
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		try {
			
			HashMap<String,String> map = new HashMap<String,String>();
			
			String company = URLEncoder.encode("红兴红（厦门）投资集团有限公司","utf-8");
			/*不需要
			 * 
			String city = URLEncoder.encode("","utf-8");
			*/
			String compareAddress = "厦门市思明区观音山国际商务营运中心启动区A3地块3号楼3层301单元";
			
			
			/*
			 * 向Internet发送请求参数
				1)将地址和参数存到byte数组中:byte[] data = params.toString().getBytes();
				2)创建URL对象:URL realUrl = new URL(requestUrl);
				3)通过HttpURLConnection对象,向网络地址发送请求:HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
				4)设置容许输出:conn.setDoOutput(true);
				5)设置不使用缓存:conn.setUseCaches(false);
				6)设置使用POST的方式发送:conn.setRequestMethod("POST");            
				7)设置维持长连接:conn.setRequestProperty("Connection", "Keep-Alive");
				8)设置文件字符集:conn.setRequestProperty("Charset", "UTF-8");
				9)设置文件长度:conn.setRequestProperty("Content-Length", String.valueOf(data.length));
				10)设置文件类型:conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
				11)以流的方式输出.
			总结:
			--发送POST请求必须设置允许输出
			--不要使用缓存,容易出现问题.
			--在开始用HttpURLConnection对象的setRequestProperty()设置,就是生成HTML文件头.
			*/
			
			//创建一个url对象，region设置为空
			url = new URL("http://api.map.baidu.com/place/v2/search?q="+company+"&region="+null+"&output=json&ak=ETQCCo6XhZLKUnTbsiSKWItQMnYv3GDt");

			// 利用HttpURLConnection对象从网络中获取网页数据
			httpurlconnection = (HttpURLConnection) url.openConnection();
			//设置容许输出
			httpurlconnection.setDoOutput(true);
			//设置使用/GETPOST的方式发送
			httpurlconnection.setRequestMethod("POST");

			// 字符流
			BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(
					httpurlconnection.getInputStream(), "utf-8"));

            String line = null;
            String re_com = null;
            String re_add = null;
            while ((line = inputStreamReader.readLine()) != null) {
            	System.out.println(line);
            	
            	if(line.contains("name"))
            	{	
            		String buffer1[] = line.split(",");
            		String buffer2[] = buffer1[0].split(":");
            		re_com = buffer2[1];
            		System.out.println();
            	}
            	else if(line.contains("address"))
            	{
            		String buffer1[] = line.split(",");
            		String buffer2[] = buffer1[0].split(":");
            		re_add = buffer2[1];
            	}
            	if(re_com == null)
            		continue;
            	map.put(re_com, re_add);

            }
            	//输入map，看结果
                System.out.println(map);
                /*
                 *导出到cvs，这部分根据需求改进！
                */
                //迭代hashMap,存储到dataList
        		Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        		int i = 0;
        		List<String> dataList=new ArrayList<String>();
        		while (iter.hasNext()) {
        			Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
        			Object key = entry.getKey();
        			Object val = entry.getValue();
        			dataList.add(++i + "," + key + "," + val);
        		}
        		//将dataList导入csv
        		boolean isSuccess=CSVUtils.exportCsv(new File("./ljq.csv"), dataList);
        		//查看导出结果
        		System.out.println(isSuccess);
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (httpurlconnection != null)
				httpurlconnection.disconnect();
			
		}

	}
}
