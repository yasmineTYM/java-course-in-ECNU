package mypack;

import java.util.List;
import java.text.DecimalFormat;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class ReadXML {
	
static double total=0;
	
	public static void main(String[] args) throws Exception{
	
		SAXBuilder file =new SAXBuilder();
		
		Document doc=file.build("stu.xml");
		
		Element root =doc.getRootElement();
		
		List<Element> list =root.getChildren("student");
		
		for(int i=0;i<list.size();i++){
		
			Element element=(Element)list.get(i);
			
			Integer score= Integer.parseInt(element.getChildText("score"));
				
			System.out.println(score);
			
			total=total+score;
					
			}
		
		double d1 =total/list.size();
		
		DecimalFormat df = new DecimalFormat("######0.00");   
		
		System.out.println("学生平均分数为："+df.format(d1));
		
	}
	
}
