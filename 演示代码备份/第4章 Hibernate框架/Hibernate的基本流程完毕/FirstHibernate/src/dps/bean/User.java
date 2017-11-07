package dps.bean;
import java.util.Date;
public class User {

	private Integer id;
	private String name;
	private String password;
	private Integer age;
	private String gender;
	private Date birthday;
	
	public User()
	{
		
	}
	public User(String name, String password, Integer age,
			String gender, Date birthday) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}
}
