package ZZX;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Helloimpl extends UnicastRemoteObject implements Hello 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*��ΪUnicastRemoteObject�Ĺ��췽���׳���RemoteException�쳣��
	�������Ĭ�ϵĹ��췽������д�����������׳�RemoteException�쳣 */
	public Helloimpl() throws RemoteException 
	{ 
		
    } 
	//ʵ��Hello�ӿڵ�helloWorld();
	public String helloWorld() throws RemoteException 
	{ 
        return "Hello World!"; 
    }
}
