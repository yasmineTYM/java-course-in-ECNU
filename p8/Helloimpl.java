package ZZX;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Helloimpl extends UnicastRemoteObject implements Hello 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*因为UnicastRemoteObject的构造方法抛出了RemoteException异常，
	因此这里默认的构造方法必须写，必须声明抛出RemoteException异常 */
	public Helloimpl() throws RemoteException 
	{ 
		
    } 
	//实现Hello接口的helloWorld();
	public String helloWorld() throws RemoteException 
	{ 
        return "Hello World!"; 
    }
}
