package ZZX;

import java.rmi.Remote;
import java.rmi.RemoteException;
//����һ��Զ�̽ӿڣ�����̳�Remote�ӿڣ�������ҪԶ�̵��õķ��������׳�RemoteException�쳣 
public interface Hello extends Remote 
{
	public String helloWorld()throws RemoteException;
}
