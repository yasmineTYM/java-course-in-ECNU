import java.io.BufferedReader;
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.InputStreamReader; 
import java.net.ServerSocket;  
import java.net.Socket;


public class Server {
      public static final int PORT = 2000;//监听的端口号
      public Socket client;
	public static void main(String[] args) {
		
		System.out.println("服务器启动...\n");    
        Server server = new Server();    
        server.init(); 
        
	}
	
	public void init() {    
        try {    
            @SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(PORT);    
       
                 client = serverSocket.accept();    
                // 处理这次连接    
               run();
              
        } catch (Exception e) {    
            System.out.println("服务器异常: " + e.getMessage());    
        }    
    }    
	public void run() {    
	
        try {    
            // 读取客户端数据    
            DataInputStream input = new DataInputStream(client.getInputStream());  
           while(true)
            { String clientInputStr = input.readUTF();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException  
            // 处理客户端数据    
            System.out.println("客户端发过来的内容:" + clientInputStr);  
            if(clientInputStr=="bye")break;
            int i=0;
            
            	i=Integer.parseInt(clientInputStr);
            // 向客户端回复信息    
            DataOutputStream out = new DataOutputStream(client.getOutputStream());    
           
            // 发送键盘输入的一行    
            String s =String.valueOf(i*i);  
            
            out.writeUTF(s);    
            }
             
        } catch (Exception e) {    
            System.out.println("服务器 断开连接: " + e.getMessage());    
        } finally {    
            if (client != null) {    
                try {    
                    client.close();    
                } catch (Exception e) {    
                    client = null;    
                    System.out.println("服务端 finally 异常:" + e.getMessage());    
                }    
            }    
}
	}
	}
