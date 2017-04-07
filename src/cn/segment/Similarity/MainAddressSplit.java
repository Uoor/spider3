package cn.segment.Similarity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;

//至少要有城市的名字
public class MainAddressSplit {
	public static NavigableMap<String, String> addressMap1 = new TreeMap<String,String>().descendingMap();
	public static NavigableMap<String, String> addressMap2 = new TreeMap<String,String>().descendingMap();
	
	
	public static String[] flag7list = {"特别行政区","自治区", "省"};  //考虑直辖市
	public static String[] flag6list = {"自治州", "地区", "市", "盟"};
	public static String[] flag5list = {"自治县", "自治旗", "林区", "特区", "县", "区", "旗"};//考虑县级市
	public static String[] flag4list = {"乡", "镇", "街道", "民族乡", "苏木"};
	//道路名 +
	public static String[] flag3list = { "大道","大街", "胡同", "横路", "横街", "纵路", "纵街", "弄", "线","路", "街", "巷", "条"};
	//小区住宅名 +
	public static String[] flag2list = {"小区","公寓", "村", "沟", "屯",  "里", "坊", "横", "队", "社",  
	                                    "大厦", "商场", "商城", "公司", "宾馆", "别墅", "商店", "所"};
	//门牌号
	public static String[] flag1list = {"栋", "号楼", "楼", "座", "型", "阁", "号"};
	//楼牌号
	public static String[] flag0list = {"#", "楼", "层", "室", "房","组" ,"号"};

	public static String[][] FlagLevel = {flag0list, flag1list,flag2list,flag3list,flag4list,flag5list,flag6list,flag7list};
	public static HashSet<String> citySet = new HashSet<String>();
	 
	
    public static void main(String[] args){
    	citySet = LevelMap.getCitySet();
    	
    	
/*

    	String add1 =  "福建省厦门市思明区槟榔西里197号第四层K8单元";
    	String add2 =  "厦门市槟榔西里197号第四层K8单元";
*/
/*
*这种情况，只有最后一位路符合条件，最后一位将会不符合
		String add1 =  "泉州市晋江市安海镇恒安工业城南环路";
		String add2 =  "泉州市安海镇恒安工业城南环路";
    */
		String add1 =  "泉州市晋江市安海镇恒安工业城南环路";
		String add2 =  "泉州市安海镇恒安工业城南环路";
    	//System.out.println("sim="+ levenshtein.similarity(add1, add2));  
    	 
    	addressMap1 = address_to_Map(add1,addressMap1);
    	 System.out.println(addressMap1);
    	
    	addressMap2 = address_to_Map(add2,addressMap2);
    	 System.out.println(addressMap2);
    	
    	 //System.out.println(Map_to_String(addressMap2));
    	
       //System.out.println("sim="+ levenshtein.similarity(Map_to_String(addressMap1), Map_to_String(addressMap2)));  
    
    	System.out.println(CompareAddress(addressMap1,addressMap2));
    }

	//地址 分词
	public static NavigableMap<String, String> address_to_Map(String address, NavigableMap<String, String> addressMap22){
    	String leftinfo = address;

        int i=0;
        int curfind =0;
        int lastfind = 0;
  
        
    	while(i<8){
    	  String[] temp_list = FlagLevel[i];
 
    	  for(String flag: temp_list){
    		if(leftinfo.contains(flag)){

    			int len = leftinfo.split(flag).length;
    			if(i==0){

    			  if(leftinfo.split(flag).length == 1)
    				leftinfo = leftinfo.split(flag)[0];
    			}
    			else if(leftinfo.split(flag).length == 2){
    			  String item = leftinfo.split(flag)[1];
        		  addressMap22.put("key"+ lastfind, item);
        		  leftinfo = leftinfo.split(flag)[0];
//        		  System.out.println(i);
//        		  System.out.println(leftinfo);
    		    }
    			else{
    				//如果被切割为多个部分，取最后一部分
    			  String[] itemList = leftinfo.split(flag);
    			  int k=0;
     			  if(itemList.length == 1) {
					  continue;
				  }

    			  leftinfo = itemList[0];
    			  while(k < itemList.length-1){
    				  leftinfo = leftinfo + flag + itemList[k];
    				  k++;
    			  }  
          		  addressMap22.put("key"+ lastfind, itemList[itemList.length-1]);
    			}
			   lastfind = i;
    		   break; // 只要匹配到，则该轮查找结束，进入下一个while循环
    		}
    		else{
    			addressMap22.put("key"+ i, "");
    			}
    	  } 
    	  
    	  // 一轮查找结束进入下一个while循环
    	  i++;
    	}


    	/*
    	if(leftinfo.length()>2) {     //减少查询次数
    		for(String city: citySet){
    			String[] templist;
				if(leftinfo.contains(city)){
				   isprovince = false;
    			   templist = leftinfo.split(city);
				   if(templist.length>1){
					   addressMap22.put("key7", templist[0]);
					   addressMap22.put("key6", city);
					   addressMap22.put("key5", templist[1]);
				   }
				   else{
					   addressMap22.put("key7", templist[0]);
					   addressMap22.put("key6", city);
				   }
				   break;
				}
    		}

    		if(isprovince)   //黑龙江这些
				//addressMap22.put("key8", leftinfo);
    			addressMap22.put("key7", leftinfo);

    	}
    	else
			//addressMap22.put("key8", leftinfo);
    		addressMap22.put("key7", leftinfo);
    	*/
		//用于确定省份
		boolean isprovince = true;

		     //减少查询次数,至少有市一级别
			for(String city: citySet){
				String[] templist;
				if(leftinfo.contains(city)){
					isprovince = false;
					templist = leftinfo.split(city);
					if(templist.length>1){
						addressMap22.put("key7", templist[0]);
						addressMap22.put("key6", city);
						addressMap22.put("key5", templist[1]);
					}
					else if(templist.length == 1){
						addressMap22.put("key7", templist[0]);
						addressMap22.put("key6", city);
					}
					else
						addressMap22.put("key6", city);
					break;
				}
			}

			if(isprovince)   //黑龙江这些
				//addressMap22.put("key8", leftinfo);
				addressMap22.put("key7", leftinfo);



    	return 	addressMap22; 
    }
	 
    public static String Map_to_String(NavigableMap<String, String> addressMap22){
    	String result = "";
    	for(String v: addressMap22.values())
    		result= result+ v;
    	return result;
    }

//    public static boolean CompareDistrict{
//    	
//    	
//    }

    
 	//两个地址 匹配，看是否正确。  从前往后匹配
    public static Boolean CompareAddress(NavigableMap<String, String> A, NavigableMap<String, String> B){
        Iterator<String> ita = A.keySet().iterator(); 
        Iterator<String> itb = B.keySet().iterator(); 
        Boolean YFlag = false;  //有相似的
        Boolean NFlag = false;  //出现不相似的
		//其中一个缺少部分
        Boolean LackFlag = false;

        Boolean MatchFlag = true;
        
        String StrA = "";
        String StrB = "";
        //每一个维度开始比较
        while(ita.hasNext() && itb.hasNext()){
        	String keyA = ita.next();
        	String keyB = itb.next();
        	if(!A.get(keyA).isEmpty() && A.get(keyA).equals(B.get(keyB))){
        		StrA = StrA + A.get(keyA); 
        		StrB = StrB + B.get(keyB); 
        		YFlag = true;
        	}
			//判断是否缺少一部分   一边缺少省 会出错！
        	else if((A.get(keyA).isEmpty() && !B.get(keyB).isEmpty())
        			||(!A.get(keyA).isEmpty() && B.get(keyB).isEmpty())){
        		LackFlag = true;
        	}
        	//地址A,B都在该维度，不为空， 直接判断地址不匹配 MatchFlag = false;
        	else if(!A.get(keyA).isEmpty() && !B.get(keyB).isEmpty() 
        			&& !A.get(keyA).equals(B.get(keyB))) {
        		NFlag = true;
        		MatchFlag = false;
        		StrA = StrA + A.get(keyA); 
        		StrB = StrB + B.get(keyB); 
        		break;
        	}
        }

        System.out.println(StrA);
   	    System.out.println(StrB);

   	    //得出两个相似度
         double sim = levenshtein.similarity(Map_to_String(addressMap1), Map_to_String(addressMap2));
            if(MatchFlag && !LackFlag){
            	System.out.println(sim);
            	return true;
            }
            //维度部分缺少 当却地址完全匹配
             else if(LackFlag && StrA.equals(StrB)){
            	
            	 return true;
            }
            else if(!MatchFlag && sim<0.7){
            	System.out.println(sim);
            	return false;
            }
            else{
            	System.out.println(sim);
            	return false;
            }

    }

}
