package dps.bean;

import java.util.Set;
//班级类
public class MyClass {
	private Integer cid;
	private String cname;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public MyClass() {
	}
		public MyClass(String cname) {
		super();
		this.cname = cname;
	}
	
	
	

}
