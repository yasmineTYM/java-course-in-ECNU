package ZZX;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient 
{

	public static void main(String[] args) 
	{
		  try 
		  { 
	            //在RMI服务注册表中查找名称为U的对象，并调用其上的方法 
	            Hello client=(Hello) Naming.lookup("rmi://localhost:8888/U"); 
	            System.out.println(client.helloWorld()); 
		  } 
		  catch (NotBoundException e) 
		  { 
	            e.printStackTrace(); 
	      } 
		  catch (MalformedURLException e) 
		  { 
	            e.printStackTrace(); 
	      } 
		  catch (RemoteException e) 
		  { 
	            e.printStackTrace();   
	      } 
	}

}
//Port 8888 is already is use
/*
 * 
1. 打开一个命令窗口，执行netstat -a -o命令
2. 找到占用那个端口的程序，找到它的pid
3. 打开任务管理器，根据pid找到它的进程，杀掉这个进程
4. 重新启动或者运行你的服务或者程序你就会发现这个异常没有了
*
*/

