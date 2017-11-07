package dps.dao;
//真实接口实现
public class UserDaoImpl implements UserDao {
	public void modify() {
		System.out.println("执行修改操作");
	}
	public void view() {
		System.out.println("执行查询操作");
	}
}
