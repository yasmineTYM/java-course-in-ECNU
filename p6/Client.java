import java.io.BufferedReader;
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;
import java.io.InputStreamReader; 
//import java.net.ServerSocket;  
import java.net.Socket;


public class Client {
	public static final String IP_ADDR = "localhost";//��������ַ   
    public static final int PORT = 2000;//�������˿ں�  
	
    public static void main(String[] args) {
	
    	Socket socket = null;  
        try {  
            socket = new Socket(IP_ADDR, PORT); //����һ�����׽��ֲ��������ӵ�ָ�������ϵ�ָ���˿ں�    
                
            //��ȡ������������    
            DataInputStream input = new DataInputStream(socket.getInputStream());    
            //��������˷�������    
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
            while(true)
            { 
            	System.out.print("������: \n");    
            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();    
            out.writeUTF(str);    
                
            String ret = input.readUTF();     
            System.out.println("�������˷��ع�������: " + ret);    
            // �緢�� "bye" ��Ͽ�����    
            if ("bye".equals(str)) {    
                System.out.println("�ͻ��˽��ر�����");   
                socket.close();
                break;
                  }      
            }  
        } catch (Exception e) {  
            System.out.println("�ͻ��˶Ͽ�����:" + e.getMessage());   
        } finally {  
            if (socket != null) {  
                try {  
                    socket.close();  
                } catch (IOException e) {  
                    socket = null;   
                    System.out.println("�ͻ��� finally �쳣:" + e.getMessage());   
                }  
            }  
        }  
	}

}
