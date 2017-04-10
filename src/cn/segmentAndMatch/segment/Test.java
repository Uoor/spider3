/*
package cn.segmentAndMatch.segment;

import cn.util.LevelMap;

import java.util.NavigableMap;
import java.util.TreeMap;

//至少要有城市的名字
public class Test {
	public static NavigableMap<String, String> addressMap1 = new TreeMap<String,String>().descendingMap();
	public static NavigableMap<String, String> addressMap2 = new TreeMap<String,String>().descendingMap();

	public static String[] province = {"特别行政区","自治区", "省"};  //考虑直辖市
	public static String[] city = {"自治州", "地区", "市", "盟"};
	public static String[] district = {"自治县", "自治旗", "林区", "特区", "县", "区", "旗"};//考虑县级市
	public static String[] flag4list = {"乡", "镇", "街道", "民族乡", "苏木"};
	//道路名 +
	public static String[] flag3list = { "路", "大道","大街", "胡同", "横路", "横街", "纵路", "纵街", "弄", "线","街", "巷", "条"};
	//小区住宅名 +
	public static String[] flag2list = {"小区","公寓", "村", "沟", "屯",  "里", "坊", "横", "队", "社",
			"大厦", "商场", "商城", "公司", "宾馆", "别墅", "商店", "所"};
	//门牌号
	public static String[] flag1list = {"栋", "号楼", "楼", "座", "型", "阁", "号"};
	//楼牌号
	public static String[] flag0list = {"#", "楼", "层", "室", "房","组" ,"号"};

	public static String[][] FlagLevel = {flag0list, flag1list,flag2list,flag3list,flag4list,district,city,province};


	public static void sliptAndcompare(String add1, String add2){



		addressMap1 = address_to_Map(add1,addressMap1);
		System.out.println(addressMap1);

		addressMap2 = address_to_Map(add2,addressMap2);
		System.out.println(addressMap2);

	}

	//地址 分词
	public static NavigableMap<String, String> address_to_Map(String address, NavigableMap<String, String> addressMap){
		String leftadd = address;
		System.out.println("原始：" + leftadd);
		addressMap.put("key7","");
		addressMap.put("key6","");
		addressMap.put("key5","");
		//从前往后 一只到区县一级
		//province
		for(String province : LevelMap.getProvinceSet()) {
			//如果包含省，将省一级加入map
			if(leftadd.startsWith(province)) {
				addressMap.put("key7",province);
				//temp 长度为1 ！！！
				String[] temp = leftadd.split(province);
				leftadd = temp[1];
				//如果有省级通名 去掉

				for(String flag: FlagLevel[7]) {
					if(temp[1].startsWith(flag)) {
						leftadd = temp[1].split(flag)[1];
						break;
					}
				}
				break;

			}
		}
		System.out.println("去掉省：" + leftadd);
		//city
		for(String city: LevelMap.getCitySet()) {
			//如果包含市，将市一级加入map
			if(leftadd.startsWith(city)) {
				addressMap.put("key6",city);
				//temp 长度为1 ！！！
				String[] temp = leftadd.split(city);
				leftadd = temp[1];
				//如果有省级通名 去掉

				for(String flag: FlagLevel[6]) {
					if(temp[1].startsWith(flag)) {
						leftadd = temp[1].split(flag)[1];
						break;
					}
				}
				break;
			}
		}

		System.out.println("去掉市：" + leftadd);
		//distrinct
		for(String district: LevelMap.getDistrictSet()) {
			//如果包含区县，将区县一级加入map
			if(leftadd.startsWith(district)) {
				addressMap.put("key5",district);
				//temp 长度为1 ！！！
				String[] temp = leftadd.split(district);
				leftadd = temp[1];
				//如果有省级通名 去掉

				for(String flag: FlagLevel[5]) {
					if(temp[1].startsWith(flag)) {
						leftadd = temp[1].split(flag)[1];
						break;
					}
				}
				break;

			}
		}
		System.out.println("去掉区：" + leftadd);

		//区县城后面 从尾巴到前面分割
		int i=0;
		//上次切分的标记位置
		int lastfind = 0;
		while(i<5){
			String[] temp_list = FlagLevel[i];

			if(i == 0) {
				for(String flag : temp_list) {
					//如果匹配到
					if(leftadd.endsWith(flag)) {
						//从最后一位截取,去掉地址通名
						leftadd = leftadd.split(flag)[0];
						break;
					}
				}
				i ++;
				continue;
			}
			//如果是 县城的下一级别 直接
			if(i == 4){
				addressMap.put("key4", leftadd);
			}

			for(String flag: temp_list){
				if(leftadd.contains(flag)){

					int len = leftadd.split(flag).length;
*/
/*					if(i==0){

						if(leftadd.split(flag).length == 1)
							leftadd = leftadd.split(flag)[0];
					}*//*

					if(len == 2){
						String item = leftadd.split(flag)[1];
						addressMap.put("key"+ lastfind, item);
						if(leftadd.endsWith(flag)) {
							leftadd = leftadd.split(flag)[0] + flag;
						} else
							leftadd = leftadd.split(flag)[0];


					}
					else{
						//如果被切割为多个部分，取最后一部分
						String[] itemList = leftadd.split(flag);
						int k=0;

						//不好取地址要素 如曾厝垵西路12座16号，去掉“号” 不好取 16
						// 所以continue
						if(itemList.length == 1) {
							continue;
						}

						leftadd = itemList[0];
						while(k < itemList.length-1){
							leftadd = leftadd + flag + itemList[k];
							k++;
						}
						addressMap.put("key"+ lastfind, itemList[len-1]);
					}
					lastfind = i;
					break; // 只要匹配到，则该轮查找结束，进入下一个while循环
				}
				else{
					addressMap.put("key"+ i, "");
				}
			}

			// 一轮查找结束进入下一个while循环
			i++;
		}
		addressMap.put("key" + lastfind, leftadd);


		return 	addressMap;
	}



public static void main(String[] args) {

	sliptAndcompare("六安软件园二期观日路12号","六安市思明区观日路12号");
}




}
*/
