package dps.bean;

import java.util.Date;

public class User {
	private Integer uid;
	private String uname;
	private String upassword;
	private Integer uage;
	private Date ubirthday;
	private String ugender;
	
	public User()
	{
		
	}
	public User(String uname, String upassword, Integer uage, Date ubirthday,
			String ugender) {
		super();
		this.uname = uname;
		this.upassword = upassword;
		this.uage = uage;
		this.ubirthday = ubirthday;
		this.ugender = ugender;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getUage() {
		return uage;
	}
	public void setUage(Integer uage) {
		this.uage = uage;
	}
	public Date getUbirthday() {
		return ubirthday;
	}
	public void setUbirthday(Date ubirthday) {
		this.ubirthday = ubirthday;
	}
@Override
public boolean equals(Object obj) {
	User u = (User) obj;
	if(u.getUid()==this.uid)
		return true;
	return false;
}
	@Override
	public String toString() {
		String str = "id = "+uid+", 姓名 = "+uname+"  ,密码 = "+upassword
				+"， 年龄 = "+uage+"  ,生日 = "+ubirthday+" ,性别 = "+ugender;
		return str;
	} 
	
	
	

}
