package doc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class WordRead {

    public static void main(String[] args) throws InvalidFormatException {
        //mapAll的key为需要替换的字符，value为替换成什么
    	//注意单纯文字替换和图片替换是有区别的
    	String key1="stuNo";//对应模板中“$stuNo$”
    	String value1="10142510249";//将key1替换成value1
    	String key2="stuName";//对应模板中"$stuName$"
    	String value2="yangyifei";//将key1替换成value2
    	String key3="photo";//对应模板中“$photo$”
    	String value3="C:\\Users\\yang\\Desktop\\qq.jpg";//为要插入photo的路径
    	String fromAddress="D:\\yang\\Template3.doc";//模板所在路径
    	String toAddress="D:\\yang\\test3.doc";//转换后word路径
        Map<String, Object> mapAll = new HashMap<String, Object>();
        
        //文字替换
        mapAll.put(key1,value1);
        mapAll.put(key2,value2);
        //图片替换
        mapAll.put(WordUtil.IMAGE_ + key3,
                   value3);
       
        try {
            WordUtil a = new WordUtil();
            a.generateWordFromTemplate(fromAddress,
                    toAddress,
                    mapAll);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        

}
