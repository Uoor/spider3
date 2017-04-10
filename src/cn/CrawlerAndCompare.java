package cn;

import cn.crawler.mapApi.Amap;
import cn.segmentAndMatch.match.MatchAddress;
import cn.segmentAndMatch.segment.SegmentAddress;

import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by mh on 17-4-8.
 */
public class CrawlerAndCompare {

	public static NavigableMap<String, String> addressMap1 = new TreeMap<String,String>().descendingMap();
	public static NavigableMap<String, String> addressMap2 = new TreeMap<String,String>().descendingMap();

	public static void main(String[] args) {
		boolean isOk = false;
		//---------------通过 完全匹配-----------------
		//Step1 通过 地图API
		HashMap<Integer,String> map = Amap.getAddByAmap("厦门市美亚柏科信息股份有限公司");
		// 对地址进行处理，取除掉空格
		for(int i = 0;i < map.size();i ++) {
			System.out.println("地图api 第" + i +"条地址匹配:");
			String add1 = map.get(i).replace(" ", "");
			String add2 = "厦门市思明区观日路12号".replace(" ", "");
			// todo 对地址进行处理，将文字数字转为 阿拉伯数字
			if(sliptAndcompare(add1, add2)) {
				isOk =true;
				break;
			}

		}

		if(!isOk) {
			//step2 招聘网站爬虫
			//todo 整合
		}

		if(!isOk) {
			//step3 baidu直接搜索 爬虫
			//todo 整合
		}




		//------------------通过地址库（词典库） 最大正向匹配------------------


		//-----------------通过 机器学习匹配可参考 hanlp分词----------------- -





		System.out.println("isOK: " + isOk);
	}

	public static boolean sliptAndcompare(String add1, String add2){

		addressMap1 = SegmentAddress.address_to_Map(add1,addressMap1);
		System.out.println(addressMap1);

		addressMap2 = SegmentAddress.address_to_Map(add2,addressMap2);
		System.out.println(addressMap2);

		System.out.println(MatchAddress.CompareAddress(addressMap1,addressMap2));
		return MatchAddress.CompareAddress(addressMap1,addressMap2);
	}
}

