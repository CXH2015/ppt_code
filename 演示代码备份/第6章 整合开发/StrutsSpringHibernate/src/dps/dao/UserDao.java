package dps.dao;

import java.util.List;

import dps.bean.User;
import dps.page.Pager;

public interface UserDao {

	//根据id查找用户
	public User get(Object uid);
	//修改用户
	public void update(User u);
	//删除用户
	public void delete(User u);
	//添加用户
	public void save(User u);
	//用户登录判断
	public boolean loginCheck(String name,String password);
	//查询所有用户
	public List<User> selectAllUser();
	//查询所有用户--分页
	public List<User> selectAllUserPage(Pager page);
	//得到总记录个数
	public int getTotalRows();
	//根据条件查询用户--分页
	public List<User> searchUserPage(Pager page,String searchType,String searchValue);
	//根据条件得到记录个数
	public int getSearchRows(String searchType,String searchValue);
}
