package 第九题;

//导入java.sql包
import java.sql.*;

public class jdbc {
public static void main(String[] args) {

	String strCon =  "jdbc:mysql://192.168.1.100:3306/test";  //连接字符串 jdbc:mysql//服务器地址/数据库名
    String strUser = "root";               //数据库用户名
    String strPwd = "123456";                  //口令
    System.out.println("正在连接数据库...");
 try {  //监控异常
  Class.forName("com.mysql.jdbc.Driver");  //加载驱动程序
  Connection con;
  //获得连接对象
  con = DriverManager.getConnection(strCon, strUser, strPwd);
  System.out.println("成功连接到数据库。");
  
	     
  Statement sta = con.createStatement();//创建语句对象
  ResultSet rs = sta.executeQuery("SELECT * FROM t_value where stuNo = 10142510202");//查询
  System.out.println("查询到数据如下：");
  
  String stuRandomValue = null;
  
 while (rs.next()) { 
 stuRandomValue=rs.getString("stuRandomValue");//根据字段名称获得字段的值
  System.out.print(stuRandomValue + "\t");  //获得字符串
 }
  
  PreparedStatement ps;
  //使用带参数的SQL语句创建PreparedStatement对象
  ps = con.prepareStatement("INSERT INTO t_stu (stuNo, stuName, stuRandomValue) VALUES('10142510202','qibin',?)");
  //设置SQL语句中的参数值
  ps.setString(1, stuRandomValue);
  ps.executeUpdate();     //执行命令
 
  
  rs.close(); sta.close(); con.close();
  
 
} catch (ClassNotFoundException cnfe) { cnfe.printStackTrace(); }
catch (SQLException sqle) { sqle.printStackTrace(); }
	    }
}