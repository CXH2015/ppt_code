package dps.bean;

import java.util.Date;
//学生类。因为不再控制关联关系，所以不再需要MyClass类型的属性。
public class Student {
	private Integer sid;
	private String snum;
	private String sname;
	private Integer sage;
	private Date sbirthday;
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
	
	
	
}
