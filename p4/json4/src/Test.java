import java.util.Date;

import net.sf.json.JSONObject;


public class Test {
	public static void main(String[] args) {
		JavaObject su=new JavaObject(1001,"苏耀东",new Date());

		JSONObject a=new Convert().javaObject_to_Json(su);   
		System.out.println (a);
	}
}
