package cn.util;

import java.util.HashSet;

public class LevelMap {
	private static HashSet<String> provinceSet = new HashSet<String>();
	private static HashSet<String> citySet = new HashSet<String>();
	private static HashSet<String> districtSet = new HashSet<String>();
	private static HashSet<String> aeratSet = new HashSet<String>();
	
	public static HashSet<String> getProvinceSet(){
		provinceSet.add("北京");
		provinceSet.add("上海");
		provinceSet.add("天津");
		provinceSet.add("重庆");
		provinceSet.add("河北");
		provinceSet.add("山西");
		provinceSet.add("内蒙古");
		provinceSet.add("黑龙江");
		provinceSet.add("吉林");
		provinceSet.add("辽宁");
		provinceSet.add("陕西");
		provinceSet.add("甘肃");
		provinceSet.add("青海");
		provinceSet.add("新疆维吾尔");
		provinceSet.add("宁夏回族");
		provinceSet.add("山东");
		provinceSet.add("河南");
		provinceSet.add("江苏");
		provinceSet.add("浙江");
		provinceSet.add("安徽");
		provinceSet.add("江西");
		provinceSet.add("福建");
		provinceSet.add("台湾");
		provinceSet.add("湖北");
		provinceSet.add("湖南");
		provinceSet.add("广东");
		provinceSet.add("广西壮族");
		provinceSet.add("海南");
		provinceSet.add("四川");
		provinceSet.add("云南");
		provinceSet.add("贵州");
		provinceSet.add("西藏");
		provinceSet.add("香港");
		provinceSet.add("澳门");

	    return provinceSet;
	}
	
	
	public static HashSet<String> getCitySet(){  
	    //System.out.println("重写无参的构造函数");
		citySet.add("石家庄");
		citySet.add("张家口");
		citySet.add("承德");
		citySet.add("唐山");
		citySet.add("秦皇岛");
		citySet.add("廊坊");
		citySet.add("保定");
		citySet.add("沧州");
		citySet.add("衡水");
		citySet.add("邢台");
		citySet.add("邯郸");
		citySet.add("太原");
		citySet.add("大同");
		citySet.add("朔州");
		citySet.add("忻州");
		citySet.add("阳泉");
		citySet.add("晋中");
		citySet.add("吕梁");
		citySet.add("长治");
		citySet.add("临汾");
		citySet.add("晋城");
		citySet.add("运城");
		citySet.add("呼和浩特");
		citySet.add("呼伦贝尔");
		citySet.add("通辽");
		citySet.add("赤峰");
		citySet.add("巴彦淖尔");
		citySet.add("乌兰察布");
		citySet.add("包头");
		citySet.add("鄂尔多斯");
		citySet.add("乌海");
		citySet.add("哈尔滨");
		citySet.add("黑河");
		citySet.add("伊春");
		citySet.add("齐齐哈尔");
		citySet.add("鹤岗");
		citySet.add("佳木斯");
		citySet.add("双鸭山");
		citySet.add("绥化");
		citySet.add("大庆");
		citySet.add("七台河");
		citySet.add("鸡西");
		citySet.add("牡丹江");
		citySet.add("长春");
		citySet.add("白城");
		citySet.add("松原");
		citySet.add("吉林");
		citySet.add("四平");
		citySet.add("辽源");
		citySet.add("白山");
		citySet.add("通化");
		citySet.add("沈阳");
		citySet.add("铁岭");
		citySet.add("阜新");
		citySet.add("抚顺");
		citySet.add("朝阳");
		citySet.add("本溪");
		citySet.add("辽阳");
		citySet.add("鞍山");
		citySet.add("盘锦");
		citySet.add("锦州");
		citySet.add("葫芦岛");
		citySet.add("营口");
		citySet.add("丹东");
		citySet.add("大连");
		citySet.add("华东地区");
		citySet.add("南京");
		citySet.add("连云港");
		citySet.add("徐州");
		citySet.add("宿迁");
		citySet.add("淮安");
		citySet.add("盐城");
		citySet.add("泰州");
		citySet.add("扬州");
		citySet.add("镇江");
		citySet.add("句容");
		citySet.add("南通");
		citySet.add("常州");
		citySet.add("无锡");
		citySet.add("苏州");
		citySet.add("杭州");
		citySet.add("湖州");
		citySet.add("嘉兴");
		citySet.add("绍兴");
		citySet.add("舟山");
		citySet.add("宁波");
		citySet.add("金华");
		citySet.add("衢州");
		citySet.add("台州");
		citySet.add("丽水");
		citySet.add("温州");
		citySet.add("合肥");
		citySet.add("淮北");
		citySet.add("亳州");
		citySet.add("宿州");
		citySet.add("蚌埠");
		citySet.add("阜阳");
		citySet.add("淮南");
		citySet.add("滁州");
		citySet.add("六安");
		citySet.add("马鞍山");
		citySet.add("巢湖");
		citySet.add("芜湖");
		citySet.add("宣城");
		citySet.add("铜陵");
		citySet.add("池州");
		citySet.add("安庆");
		citySet.add("黄山");
		citySet.add("福州");
		citySet.add("宁德");
		citySet.add("南平");
		citySet.add("三明");
		citySet.add("莆田");
		citySet.add("龙岩");
		citySet.add("泉州");
		citySet.add("漳州");
		citySet.add("厦门");
		citySet.add("南昌");
		citySet.add("九江");
		citySet.add("景德镇");
		citySet.add("上饶");
		citySet.add("鹰潭");
		citySet.add("抚州");
		citySet.add("新余");
		citySet.add("宜春");
		citySet.add("萍乡");
		citySet.add("吉安");
		citySet.add("赣州");
		citySet.add("济南");
		citySet.add("德州");
		citySet.add("滨州");
		citySet.add("东营");
		citySet.add("烟台");
		citySet.add("威海");
		citySet.add("淄博");
		citySet.add("潍坊");
		citySet.add("聊城");
		citySet.add("泰安");
		citySet.add("莱芜");
		citySet.add("青岛");
		citySet.add("日照");
		citySet.add("济宁");
		citySet.add("菏泽");
		citySet.add("临沂");
		citySet.add("枣庄");
		citySet.add("中南地区");
		citySet.add("郑州");
		citySet.add("安阳");
		citySet.add("鹤壁");
		citySet.add("濮阳");
		citySet.add("新乡");
		citySet.add("焦作");
		citySet.add("三门峡");
		citySet.add("开封");
		citySet.add("洛阳");
		citySet.add("商丘");
		citySet.add("许昌");
		citySet.add("平顶山");
		citySet.add("周口");
		citySet.add("漯河");
		citySet.add("南阳");
		citySet.add("驻马店");
		citySet.add("信阳");
		citySet.add("武汉");
		citySet.add("十堰");
		citySet.add("襄樊");
		citySet.add("随州");
		citySet.add("荆门");
		citySet.add("孝感");
		citySet.add("宜昌");
		citySet.add("黄冈");
		citySet.add("鄂州");
		citySet.add("荆州");
		citySet.add("黄石");
		citySet.add("咸宁");
		citySet.add("长沙");
		citySet.add("岳阳");
		citySet.add("张家界");
		citySet.add("常德");
		citySet.add("益阳");
		citySet.add("湘潭");
		citySet.add("株洲");
		citySet.add("娄底");
		citySet.add("怀化");
		citySet.add("邵阳");
		citySet.add("衡阳");
		citySet.add("永州");
		citySet.add("郴州");
		citySet.add("广州");
		citySet.add("韶关");
		citySet.add("梅州");
		citySet.add("河源");
		citySet.add("清远");
		citySet.add("潮州");
		citySet.add("揭阳");
		citySet.add("汕头");
		citySet.add("肇庆");
		citySet.add("惠州");
		citySet.add("佛山");
		citySet.add("东莞");
		citySet.add("云浮");
		citySet.add("汕尾");
		citySet.add("江门");
		citySet.add("中山");
		citySet.add("深圳");
		citySet.add("珠海");
		citySet.add("阳江");
		citySet.add("茂名");
		citySet.add("湛江");
		citySet.add("南宁");
		citySet.add("桂林");
		citySet.add("河池");
		citySet.add("贺州");
		citySet.add("柳州");
		citySet.add("百色");
		citySet.add("来宾");
		citySet.add("梧州");
		citySet.add("贵港");
		citySet.add("玉林");
		citySet.add("崇左");
		citySet.add("钦州");
		citySet.add("防城港");
		citySet.add("北海");
		citySet.add("海口");
		citySet.add("三亚");
		citySet.add("成都");
		citySet.add("广元");
		citySet.add("巴中");
		citySet.add("绵阳");
		citySet.add("德阳");
		citySet.add("达州");
		citySet.add("南充");
		citySet.add("遂宁");
		citySet.add("广安");
		citySet.add("资阳");
		citySet.add("眉山");
		citySet.add("雅安");
		citySet.add("内江");
		citySet.add("乐山");
		citySet.add("自贡");
		citySet.add("泸州");
		citySet.add("宜宾");
		citySet.add("攀枝花");
		citySet.add("贵阳");
		citySet.add("遵义");
		citySet.add("六盘水");
		citySet.add("安顺");
		citySet.add("昆明");
		citySet.add("昭通");
		citySet.add("丽江");
		citySet.add("曲靖");
		citySet.add("保山");
		citySet.add("玉溪");
		citySet.add("临沧");
		citySet.add("普洱");
		citySet.add("拉萨");
		citySet.add("西安");
		citySet.add("榆林");
		citySet.add("延安");
		citySet.add("铜川");
		citySet.add("渭南");
		citySet.add("宝鸡");
		citySet.add("咸阳");
		citySet.add("商洛");
		citySet.add("汉中");
		citySet.add("安康");
		citySet.add("兰州");
		citySet.add("嘉峪关");
		citySet.add("酒泉");
		citySet.add("张掖");
		citySet.add("金昌");
		citySet.add("武威");
		citySet.add("白银");
		citySet.add("庆阳");
		citySet.add("平凉");
		citySet.add("定西");
		citySet.add("天水");
		citySet.add("陇南");
		citySet.add("西宁");
		citySet.add("银川");
		citySet.add("石嘴山");
		citySet.add("吴忠");
		citySet.add("中卫");
		citySet.add("固原");
		citySet.add("乌鲁木齐");
		citySet.add("克拉玛依");
		citySet.add("台北");
		citySet.add("高雄");
		citySet.add("锡林郭勒");
		citySet.add("阿拉善");
		citySet.add("和兴安");
		citySet.add("大兴安岭");
		citySet.add("大连市华东");
		citySet.add("那曲");
		citySet.add("昌都");
		citySet.add("林芝");
		citySet.add("山南");
		citySet.add("日喀则");
		citySet.add("阿里");
		citySet.add("海东地区");
		citySet.add("吐鲁番");
		citySet.add("哈密");
		citySet.add("和田");
		citySet.add("阿克苏");
		citySet.add("喀什");
		citySet.add("塔城");
		citySet.add("阿勒泰");
		citySet.add("琼北");
		citySet.add("琼南");
		citySet.add("延边朝鲜族");
		citySet.add("阿坝藏族羌族");
		citySet.add("甘孜藏族");
		citySet.add("凉山彝族");
		citySet.add("黔东南苗族侗族");
		citySet.add("黔南布依族苗族");
		citySet.add("黔西南布依族苗族");
		citySet.add("楚雄彝族");
		citySet.add("大理白族");
		citySet.add("德宏傣族景颇族");
		citySet.add("迪庆藏族");
		citySet.add("红河哈尼族彝族");
		citySet.add("怒江傈僳族");
		citySet.add("文山壮族苗族");
		citySet.add("西双版纳傣族");
		citySet.add("甘南藏族");
		citySet.add("临夏回族");
		citySet.add("果洛藏族");
		citySet.add("海南藏族");
		citySet.add("海西蒙古族藏族");
		citySet.add("海北藏族");
		citySet.add("黄南藏族");
		citySet.add("玉树藏族");
		citySet.add("新疆维吾尔");
		citySet.add("巴音郭楞蒙古");
		citySet.add("博尔塔拉蒙古");
		citySet.add("昌吉回族");
		citySet.add("克孜勒苏柯尔克孜");
		citySet.add("伊犁哈萨克");
		citySet.add("恩施土家族苗族");
		citySet.add("湘西土家族苗族");
		
		return citySet;
	}

	public static HashSet<String> getDistrictSet(){
		districtSet.add("思明");
		districtSet.add("湖里");
		districtSet.add("同安");
		districtSet.add("集美");
		districtSet.add("海沧");
		districtSet.add("翔安");

		return districtSet;
	}

 
}