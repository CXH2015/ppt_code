package dps.bean;
//美国人
public class American implements IPerson {
	private String name;
	private ICup cup;
    public American()
    {
    }
    public American(String name,ICup c)
    {
    	this.name = name;
    	this.cup = c;
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
