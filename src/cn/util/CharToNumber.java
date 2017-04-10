package cn.util;

/**
 * Created by mh on 17-4-10.
 */
public class CharToNumber {
	public static boolean isNumeric(String str){
		for (int i = 0; i < str.length(); i++){
			if (!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
}
