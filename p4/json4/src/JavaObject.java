import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaObject {
	public JavaObject(int a, String b, Date c) {
		this.ID = a;
		this.Name = b;
		this.birthday = myFm.format(c);
	}
    SimpleDateFormat myFm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()
	private int ID;
	private String Name;
	private String  birthday;
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday =myFm.format(birthday);
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}