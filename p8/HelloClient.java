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
	            //��RMI����ע����в�������ΪU�Ķ��󣬲��������ϵķ��� 
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
1. ��һ������ڣ�ִ��netstat -a -o����
2. �ҵ�ռ���Ǹ��˿ڵĳ����ҵ�����pid
3. �����������������pid�ҵ����Ľ��̣�ɱ���������
4. ������������������ķ�����߳�����ͻᷢ������쳣û����
*
*/

