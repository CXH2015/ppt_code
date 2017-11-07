package dps.bean;
//中国人
public class Chinese implements IPerson{
	private String name;
	private ICup cup;
    public Chinese()
    {
    }
    public Chinese(String name,ICup c)
    {
    	this.name = name;
    	this.cup = c;
    }
	@Override
	public void sayHello()
	{
		System.out.println(name+"说，你好");
	}
	@Override
	public void drink() {
		this.cup.fillWater();
	}
}
