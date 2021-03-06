package cn.segmentAndMatch.Geocoding;

import net.sf.json.JSONObject;

import java.io.IOException;


/**
 * @author 
 *
 * 通过百度地图api,将坐标解析为具体地址
 * 省份 ：江苏省   地级市 ：镇江市
 *省份代码 ：3000 地级市代码 ：3140
 *
 */
public class GetCityCode {
/*
	GetLocationString("31.237324", "121.670105");
	{"country":"中国",
			"country_code":0,"" +
			"province":"上海市",
			"city":"上海市",
			"district":"浦东新区",
			"adcode":"310115",
			"street":"顾唐路",
			"street_number":"1899",
			"direction":"附近",
			"distance":"12"
	}


Cstring = GetLocationString("32.0021400000", "119.6102790000");
	{"country":"中国",
			"country_code":0,
			"province":"江苏省",
			"city":"镇江市",
			"district":"丹阳市",
			"adcode":"321181",
			"street":"金陵西路辅路",
			"street_number":"",
			"direction":"",
			"distance":""
	}

*/

    
    
    public static String GetLocationString(String lat, String lng ) throws IOException, IOException{
    	String ak = "FpGacYmfVbQhNHO51YYGS4v3LR7cgS8P";
    	   
        //逆地理编码,即根据经度纬度来查地址
    	String url = "http://api.map.baidu.com/geocoder/v2/?ak=" + ak + "&location=" + lng + "," + lat + "&output=json&pois=1";
        
    	
    	String qr = Parser_Tool.do_get(url);
        // {"status":0,"result":{"location":{"lng":121.51996737545,"lat":31.308233429954},"formatted_address":"上海市杨浦区政通路177","business":"五角场,大学区,复旦大学","addressComponent":{"city":"上海市","district":"杨浦区","province":"上海市","street":"政通路","street_number":"177"},"pois":[{"addr":"政通路177","cp":"NavInfo","distance":"0.022361","name":"万达广场C座","poiType":"办公大厦,商务大厦","point":{"x":121.51996728562,"y":31.308233584217},"tel":"(021)61362818","uid":"18c7ec2a6c3b0e5e08ccddbe","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"76.894138","name":"麻辣风暴","poiType":"中餐馆,餐饮","point":{"x":121.51999558224,"y":31.308826030169},"tel":"(021)55663716","uid":"e7b540bd7d31784b4d6d4670","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"80.359847","name":"H&M","poiType":"服装鞋帽,购物","point":{"x":121.51968485837,"y":31.307663040014},"tel":"","uid":"badcec30996927a041ab9a26","zip":""},{"addr":"上海市杨浦区四平路2637号","cp":"mix","distance":"101.236603","name":"班尼路","poiType":"服装鞋帽,购物","point":{"x":121.51911075132,"y":31.307971259271},"tel":"","uid":"802871ea45db67f7704b87bc","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"103.612502","name":"特力屋","poiType":"家居建材,购物","point":{"x":121.51957508543,"y":31.307508698607},"tel":"(021)52191919","uid":"bfd5bcd746f798e551e5c581","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"103.612502","name":"复茂","poiType":"中餐馆,餐饮","point":{"x":121.51957508543,"y":31.307508698607},"tel":"","uid":"3c65d40795d0f74fefe4a523","zip":""},{"addr":"特力时尚汇5层","cp":"NavInfo","distance":"103.612502","name":"望湘园","poiType":"中餐馆,餐饮","point":{"x":121.51957508543,"y":31.307508698607},"tel":"(021)33620977","uid":"8889b451bdeb6544e111033f","zip":""},{"addr":"上海市杨浦区翔殷路1128号大西洋百货2楼(近国济路)","cp":"mix","distance":"130.818973","name":"艾格","poiType":"服装鞋帽,购物","point":{"x":121.5191145242,"y":31.307539242954},"tel":"","uid":"2d83695078e80ecf05fef54c","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"14.235832","name":"冠龙数码彩扩冲印","poiType":"快照冲印,摄影冲印,生活服务","point":{"x":121.52008792805,"y":31.308270067458},"tel":"","uid":"80d3f20fca4819726849f393","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"55.990822","name":"美卡拉","poiType":"服装鞋帽,购物","point":{"x":121.51972384483,"y":31.307855561471},"tel":"","uid":"f78e03f2963d1f271ee99941","zip":""}],"cityCode":289}}
        //System.out.println("接收到的字符串：" + qr);
        
        //将json字符串转成json对象
        JSONObject jsonObject = JSONObject.fromObject(qr);
        
        JSONObject result = jsonObject.getJSONObject("result");
        
        JSONObject addressComponentObject = result.getJSONObject("addressComponent");
        
        String province= addressComponentObject.getString("province"); 
        
        String city= addressComponentObject.getString("city");
        System.out.println(addressComponentObject);
        System.out.println("省份 ：" + province + "   地级市 ：" + city);
        String CodeString = "省份代码 ：" + LocationMap.getProvinceCode(province) + " 地级市代码 ：" + LocationMap.getCityCode(city);
        return CodeString;
    }
     

}