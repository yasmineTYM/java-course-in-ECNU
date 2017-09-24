import java.io.BufferedReader;
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;
import java.io.InputStreamReader; 
//import java.net.ServerSocket;  
import java.net.Socket;


public class Client {
	public static final String IP_ADDR = "localhost";//服务器地址   
    public static final int PORT = 2000;//服务器端口号  
	
    public static void main(String[] args) {
	
    	Socket socket = null;  
        try {  
            socket = new Socket(IP_ADDR, PORT); //创建一个流套接字并将其连接到指定主机上的指定端口号    
                
            //读取服务器端数据    
            DataInputStream input = new DataInputStream(socket.getInputStream());    
            //向服务器端发送数据    
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
            while(true)
            { 
            	System.out.print("请输入: \n");    
            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();    
            out.writeUTF(str);    
                
            String ret = input.readUTF();     
            System.out.println("服务器端返回过来的是: " + ret);    
            // 如发送 "bye" 则断开连接    
            if ("bye".equals(str)) {    
                System.out.println("客户端将关闭连接");   
                socket.close();
                break;
                  }      
            }  
        } catch (Exception e) {  
            System.out.println("客户端断开连接:" + e.getMessage());   
        } finally {  
            if (socket != null) {  
                try {  
                    socket.close();  
                } catch (IOException e) {  
                    socket = null;   
                    System.out.println("客户端 finally 异常:" + e.getMessage());   
                }  
            }  
        }  
	}

}
