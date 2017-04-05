package cn.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import cn.util.*;



/**
 * CSV操作(导出和导入)
 * 
 * @author 林计钦
 * @version 1.0 Jan 27, 2014 4:17:02 PM
 */
public class Test {

    /**
     * CSV导出
     * 
     * @throws Exception
     */
//    @Test
    public static void main(String[] args) {
        List<String> dataList=new ArrayList<String>();
        dataList.add("1,张三,男");
        dataList.add("2,李四,男");
        dataList.add("3,小红,女");
        boolean isSuccess=CSVUtils.exportCsv(new File("./ljq.csv"), dataList);
        System.out.println(isSuccess);
    }
    
    /**
     * CSV导入
     * 
     * @throws Exception
     */
 /*   @Test
    public void importCsv()  {
        List<String> dataList=CSVUtils.importCsv(new File("D:/test/ljq.csv"));
        if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                System.out.println(data);
            }
        }
    }*/
    
    
}