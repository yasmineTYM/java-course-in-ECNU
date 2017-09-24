package crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.metal.OceanTheme;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class crawler {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url="http://www.ecnu.edu.cn/";
		System.out.println("网页上抓取到的数据如下所示\n\n");
		String result=browseAndGetCode(url);
		System.out.println(result);
		printEmail(url);
		
		
		
		
		//System.out.println(result);
//		ArrayList<String>list=RegexAllStringAndPrint(result,"question_link.+?>(.+?)<");
//		refineStringAndStore(url,list);			 
//		refineStringAndPrint(url,list);			 
	}
	
	
	public static void refineStringAndStore(String url,ArrayList< String> list) throws IOException{
		
		File file1=new File("/Users/Day1/Desktop/zhihu.txt");
		
		if(!file1.exists()){
			file1.createNewFile();
			System.out.print("txt文件已经创建，");
		}
	
		else{
			System.out.print("txt文件存在，");
		}
		System.out.println("请到相应位置查看");
		
		 PrintWriter output = new PrintWriter(new FileWriter(file1)); 

		for(int i=0;i<list.size();i++){
			int questionStart=list.get(i).indexOf(">");
			int quesitionEnd=list.get(i).indexOf("<");
			String quesition=list.get(i).substring(questionStart+1,quesitionEnd);
			
			
			int answerPosition=list.get(i).indexOf("question");
			String answerLink=url+list.get(i).substring(answerPosition, questionStart);
			
			//output.write("a");
			output.write("问题: "+quesition+"\n");
			output.write("回答: "+answerLink+"\n\n");	
		}
		output.flush();
		output.close();
		
	}

	
	public static void refineStringAndPrint(String url,ArrayList< String> list){
		
		for(int i=0;i<list.size();i++){
			System.out.println("问题:");
			int questionStart=list.get(i).indexOf(">");
			int quesitionEnd=list.get(i).indexOf("<");
			String quesition=list.get(i).substring(questionStart+1,quesitionEnd);
			System.out.println(quesition);
			
			
			int answerPosition=list.get(i).indexOf("question");
			String answerLink=url+list.get(i).substring(answerPosition, questionStart);
			System.out.println("回答： "+answerLink+"\n");
			
			
		}
		
	}
	
	public static String browseAndGetCode(String url) throws ClientProtocolException, IOException{
		 HttpClient client=HttpClients.createDefault();
		 HttpGet get=new HttpGet(url);
		 HttpResponse response=client.execute(get);
		 HttpEntity entity=response.getEntity();
		 InputStream is=(InputStream) entity.getContent();
		 InputStreamReader isr=new InputStreamReader(is,"utf-8");
		 BufferedReader br=new BufferedReader(isr);
		 String res=br.readLine();
		 StringBuilder sbr=new StringBuilder();
		 
		 while(res!=null){
			 //System.out.println(res);	
			 res=res+"\n";
			 sbr=sbr.append(res);
			 res=br.readLine();
		 }
		 
		 String crawledCode=sbr.toString();
		 return crawledCode;
	}
	
	public static void printEmail(String url) throws ClientProtocolException, IOException{
		 System.out.println("网站上抓取的邮箱数据如下：");
		 HttpClient client=HttpClients.createDefault();
		 HttpGet get=new HttpGet(url);
		 HttpResponse response=client.execute(get);
		 HttpEntity entity=response.getEntity();
		 InputStream is=(InputStream) entity.getContent();
		 InputStreamReader isr=new InputStreamReader(is,"utf-8");
		 BufferedReader br=new BufferedReader(isr);
		 String res=br.readLine();
		 StringBuilder sbr=new StringBuilder();
		 
		 System.out.println("student.ecnu.edu.cn");
		 while(res!=null){
			 //System.out.println(res);	
			 if(res.indexOf("option value")>=0&&res.indexOf("!")==-1){
				 int p1=res.indexOf("=");
				 int p2=res.indexOf(".cn");
				 res=res.substring(p1+2, p2+3);
				 System.out.println(res);
			 }
			 sbr=sbr.append(res);
			 res=br.readLine();
		 }
		 
		 String crawledCode=sbr.toString();
		 
		 
	}
	
	public static void browseAndPrintCode(String url) throws ClientProtocolException, IOException{
		 HttpClient client=HttpClients.createDefault();
		 HttpGet get=new HttpGet(url);
		 HttpResponse response=client.execute(get);
		 HttpEntity entity=response.getEntity();
		 InputStream is=(InputStream) entity.getContent();
		 InputStreamReader isr=new InputStreamReader(is);
		 BufferedReader br=new BufferedReader(isr);
		 String res=br.readLine();
		 StringBuilder sbr=new StringBuilder();
		 
		 while(res!=null){
			 //System.out.println(res);		
			 res=res+"\n";
			 sbr=sbr.append(res);
			 res=br.readLine();
		 }
		 
		 String crawledCode=sbr.toString();
		 System.out.println(crawledCode);
	}

	
	 static String RegexFirstString(String targetStr, String patternStr) {
		  // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		  // 相当于埋好了陷阱匹配的地方就会掉下去
		  Pattern pattern = Pattern.compile(patternStr);
		  // 定义一个matcher用来做匹配
		  Matcher matcher = pattern.matcher(targetStr);
		  // 如果找到了
		  if (matcher.find()) {
		   // 打印出结果
		   return matcher.group(1);
		  }
		  return "";
	}
	 
	 static ArrayList<String> RegexAllStringAndPrint(String targetStr, String patternStr) {
		  // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		  // 相当于埋好了陷阱匹配的地方就会掉下去
		 ArrayList<String> list=new ArrayList<String>();
		  Pattern pattern = Pattern.compile(patternStr);
		  // 定义一个matcher用来做匹配
		  Matcher matcher = pattern.matcher(targetStr);
//		  // 如果找到了
		  int length=matcher.groupCount();
//		  if (matcher.find()) {
//		   // 打印出结果
//		   	for(int i=1;i<=length;i++)
//			   System.out.println(matcher.group(i));
//		  }
		  while(matcher.find()){
			  list.add(matcher.group(0));
		  }
		  return list;
	}
		
}
