package cn.crawler.mapApi;

import cn.segmentAndMatch.Geocoding.Parser_Tool;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.net.URLEncoder;

public class Amap {
	public static HashMap<Integer,String> getAddByAmap(String comName) {
		
		String url = null;
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		try {

			String company = URLEncoder.encode(comName,"utf-8");

			url = "http://restapi.amap.com/v3/place/text?key=58d298e40df17c748afd1945e098b160&keywords=" + company +
					"&types=&city=" + "" +"&children=1&offset=20&page=1&extensions=all";


			String qr = Parser_Tool.do_get(url);
			System.out.println(qr);
			JSONObject jsonObject = JSONObject.fromObject(qr);


			JSONArray re = jsonObject.getJSONArray("pois");
			for(int i = 0; i < re.size();i ++) {
				JSONObject jtemp = (JSONObject)re.get(i);
				map.put(i,jtemp.getString("address"));
			}

            System.out.println(map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return map;
	}


}
