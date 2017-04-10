package cn.segmentAndMatch.match;

import cn.CrawlerAndCompare;
import cn.util.CharToNumber;
import cn.util.levenshtein;

import java.util.Iterator;
import java.util.NavigableMap;

/**
 * Created by mh on 17-4-9.
 */
public class MatchAddress {
	public static String Map_to_String(NavigableMap<String, String> addressMap22){
		String result = "";
		for(String v: addressMap22.values())
			result= result+ v;
		return result;
	}




	//两个地址 匹配，看是否正确。  从前往后匹配
	//todo 改为规则树匹配
	public static Boolean CompareAddress(NavigableMap<String, String> A, NavigableMap<String, String> B){
		Iterator<String> ita = A.keySet().iterator();
		Iterator<String> itb = B.keySet().iterator();
		Boolean districtFlag = true;
		Boolean YFlag = false;  //完全匹配
		Boolean NFlag = false;  //出现不相似的
		//其中一个缺少部分
		Boolean LackFlag = false;

		Boolean MatchFlag = true;
		int j = 0;
		String StrA = "";
		String StrB = "";
		//每一个维度开始比较
		while(ita.hasNext() && itb.hasNext()){
			j++;
			String keyA = ita.next();
			String keyB = itb.next();
			//A B当前维度都不为空 且相等
			if(!A.get(keyA).isEmpty() && A.get(keyA).equals(B.get(keyB))){
				StrA = StrA + A.get(keyA);
				StrB = StrB + B.get(keyB);
				YFlag = true;
			}
			//A B当前维度 有一边为空
			else if((A.get(keyA).isEmpty() && !B.get(keyB).isEmpty())
					||(!A.get(keyA).isEmpty() && B.get(keyB).isEmpty())){
				//该维度不加入匹配
				LackFlag = true;
			}
			//地址A,B都在该维度，都不为空， 直接判断地址不匹配 MatchFlag = false;
			else if(!A.get(keyA).isEmpty() && !B.get(keyB).isEmpty()
					&& !A.get(keyA).equals(B.get(keyB))) {
				//前面三个行政区域 出错 直接判断错误
				if(j <= 3){
					districtFlag = false;
					break;
				}
				NFlag = true;
				MatchFlag = false;

				if(!(CharToNumber.isNumeric(A.get(keyA)) && CharToNumber.isNumeric(B.get(keyB))) &&  // A B 不是数字的情况下
						(A.get(keyA).contains(B.get(keyB)) || B.get(keyB).contains(A.get(keyA)))){   // 软件园二期 观日路  与 观日路 算匹配 忽略该部分
					MatchFlag = true;
					continue;
				}
				StrA = StrA + A.get(keyA);
				StrB = StrB + B.get(keyB);
			}
		}


		System.out.println(StrA);
		System.out.println(StrB);

		if(districtFlag == false)
			return false;

		//得出两个相似度
		double sim = levenshtein.similarity(Map_to_String(CrawlerAndCompare.addressMap1), Map_to_String(CrawlerAndCompare.addressMap2));
		double simAfterMatch = levenshtein.similarity(StrA, StrB);
		//完全匹配
		if(MatchFlag ){
			System.out.println(sim);
			System.out.println(simAfterMatch);
			return true;
		}
		//维度部分缺少 当却地址完全匹配
		else if(LackFlag && StrA.equals(StrB)){

			return true;
		}
		else if(!MatchFlag && simAfterMatch>0.95){
			System.out.println(sim);
			System.out.println(simAfterMatch);
			return true;
		}
		else{
			System.out.println(sim);
			System.out.println(simAfterMatch);
			return false;
		}

	}
}
