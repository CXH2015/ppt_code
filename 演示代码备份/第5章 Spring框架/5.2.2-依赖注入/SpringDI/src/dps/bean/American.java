package dps.bean;
//美国人
public class American implements IPerson {
	private String name;
	private ICup cup;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ICup getCup() {
		return cup;
	}
	public void setCup(ICup cup) {
		this.cup = cup;
	}
	public void sayHello()
	{
		System.out.println(name+"say,hello.");
	}
	@Override
	public void drink() {
		this.cup.fillWater();
	}
}
