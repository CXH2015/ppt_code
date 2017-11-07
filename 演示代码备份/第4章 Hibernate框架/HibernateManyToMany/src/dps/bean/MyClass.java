package dps.bean;

import java.util.Set;
//班级类。因为要控制关联关系，所依为其增加Set类型的属性指向Stduent关联实体
public class MyClass {
	private Integer cid;
	private String cname;
    private Set<Student>myStudentSet;
	public Set<Student> getMyStudentSet() {
		return myStudentSet;
	}
	public void setMyStudentSet(Set<Student> myStudentSet) {
		this.myStudentSet = myStudentSet;
	}
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
