package dps.bean;

public class Person {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public void information() {
		System.out.print("这个人的名字是：" + name);
	}
}
