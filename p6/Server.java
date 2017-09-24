import java.io.BufferedReader;
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.InputStreamReader; 
import java.net.ServerSocket;  
import java.net.Socket;


public class Server {
      public static final int PORT = 2000;//�����Ķ˿ں�
      public Socket client;
	public static void main(String[] args) {
		
		System.out.println("����������...\n");    
        Server server = new Server();    
        server.init(); 
        
	}
	
	public void init() {    
        try {    
            @SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(PORT);    
       
                 client = serverSocket.accept();    
                // �����������    
               run();
              
        } catch (Exception e) {    
            System.out.println("�������쳣: " + e.getMessage());    
        }    
    }    
	public void run() {    
	
        try {    
            // ��ȡ�ͻ�������    
            DataInputStream input = new DataInputStream(client.getInputStream());  
           while(true)
            { String clientInputStr = input.readUTF();//����Ҫע��Ϳͻ����������д������Ӧ,������� EOFException  
            // ����ͻ�������    
            System.out.println("�ͻ��˷�����������:" + clientInputStr);  
            if(clientInputStr=="bye")break;
            int i=0;
            
            	i=Integer.parseInt(clientInputStr);
            // ��ͻ��˻ظ���Ϣ    
            DataOutputStream out = new DataOutputStream(client.getOutputStream());    
           
            // ���ͼ��������һ��    
            String s =String.valueOf(i*i);  
            
            out.writeUTF(s);    
            }
             
        } catch (Exception e) {    
            System.out.println("������ �Ͽ�����: " + e.getMessage());    
        } finally {    
            if (client != null) {    
                try {    
                    client.close();    
                } catch (Exception e) {    
                    client = null;    
                    System.out.println("����� finally �쳣:" + e.getMessage());    
                }    
            }    
}
	}
	}
