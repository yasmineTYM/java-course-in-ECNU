package �ھ���;

//����java.sql��
import java.sql.*;

public class jdbc {
public static void main(String[] args) {

	String strCon =  "jdbc:mysql://192.168.1.100:3306/test";  //�����ַ��� jdbc:mysql//��������ַ/���ݿ���
    String strUser = "root";               //���ݿ��û���
    String strPwd = "123456";                  //����
    System.out.println("�����������ݿ�...");
 try {  //����쳣
  Class.forName("com.mysql.jdbc.Driver");  //������������
  Connection con;
  //������Ӷ���
  con = DriverManager.getConnection(strCon, strUser, strPwd);
  System.out.println("�ɹ����ӵ����ݿ⡣");
  
	     
  Statement sta = con.createStatement();//����������
  ResultSet rs = sta.executeQuery("SELECT * FROM t_value where stuNo = 10142510202");//��ѯ
  System.out.println("��ѯ���������£�");
  
  String stuRandomValue = null;
  
 while (rs.next()) { 
 stuRandomValue=rs.getString("stuRandomValue");//�����ֶ����ƻ���ֶε�ֵ
  System.out.print(stuRandomValue + "\t");  //����ַ���
 }
  
  PreparedStatement ps;
  //ʹ�ô�������SQL��䴴��PreparedStatement����
  ps = con.prepareStatement("INSERT INTO t_stu (stuNo, stuName, stuRandomValue) VALUES('10142510202','qibin',?)");
  //����SQL����еĲ���ֵ
  ps.setString(1, stuRandomValue);
  ps.executeUpdate();     //ִ������
 
  
  rs.close(); sta.close(); con.close();
  
 
} catch (ClassNotFoundException cnfe) { cnfe.printStackTrace(); }
catch (SQLException sqle) { sqle.printStackTrace(); }
	    }
}