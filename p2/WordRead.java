package doc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class WordRead {

    public static void main(String[] args) throws InvalidFormatException {
        //mapAll��keyΪ��Ҫ�滻���ַ���valueΪ�滻��ʲô
    	//ע�ⵥ�������滻��ͼƬ�滻���������
    	String key1="stuNo";//��Ӧģ���С�$stuNo$��
    	String value1="10142510249";//��key1�滻��value1
    	String key2="stuName";//��Ӧģ����"$stuName$"
    	String value2="yangyifei";//��key1�滻��value2
    	String key3="photo";//��Ӧģ���С�$photo$��
    	String value3="C:\\Users\\yang\\Desktop\\qq.jpg";//ΪҪ����photo��·��
    	String fromAddress="D:\\yang\\Template3.doc";//ģ������·��
    	String toAddress="D:\\yang\\test3.doc";//ת����word·��
        Map<String, Object> mapAll = new HashMap<String, Object>();
        
        //�����滻
        mapAll.put(key1,value1);
        mapAll.put(key2,value2);
        //ͼƬ�滻
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
