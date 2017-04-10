package cn.segmentAndMatch.Geocoding;

import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

/**
 * Created by mh on 17-4-8.
 */
public class AddCodeAdd {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		//String Cstring = GetFromAddress("北京市","北京市海淀区上地十街10号");
		//String Cstring = GetFromAddress("北京市海淀区上地十街10号");
		System.out.println("------ Step1:将地址转为编码 ------");
		String[] Cstring = GetGeocoding.GetFromAddress("北京市东城区正义路2号");
		System.out.println("------ Step2:将编码转为地址 ------");
		String re = GetCityCode.GetLocationString(Cstring[0], Cstring[1]);
		System.out.println("------ 输入结果 ------" + "\n"  + re);

	}


}
