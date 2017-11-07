package dps.bean;

import java.util.Date;
//学生类
public class Student {
	private Integer sid;
	private String snum;
	private String sname;
	private Integer sage;
	private Date sbirthday;
    MyClass myClass;//学生所属的班级,1端
	public MyClass getMyClass() {
		return myClass;
	}
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
	}
	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public String getSnum() {
		return snum;
	}


	public void setSnum(String snum) {
		this.snum = snum;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public Integer getSage() {
		return sage;
	}


	public void setSage(Integer sage) {
		this.sage = sage;
	}


	public Date getSbirthday() {
		return sbirthday;
	}


	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}


	public Student()
	{
		
	}
	public Student( String snum, String sname, Integer sage,
			Date sbirthday) {
		super();
		this.snum = snum;
		this.sname = sname;
		this.sage = sage;
		this.sbirthday = sbirthday;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", snum=" + snum + ", sname=" + sname
				+ ", sage=" + sage + ", sbirthday=" + sbirthday + ", myClass="
				+ myClass + "]";
	}
	
	
	
}
