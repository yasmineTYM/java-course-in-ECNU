import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class Convert {

	JSONObject javaObject_to_Json(JavaObject ob) {
		JSONObject jsonObject = null;
		try {
			Map map = BeanToMapUtil.convertBean(ob);
			jsonObject = JSONObject.fromObject(map);
		} catch (IllegalAccessException | InvocationTargetException
				| IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// /return JSONObject.fromObject(ob);
		return jsonObject;
	}

}
