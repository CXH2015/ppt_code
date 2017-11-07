package dps.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dps.bean.User;
import dps.dao.UserDao;
import dps.dao.impl.UserDaoImpl;
import dps.page.Pager;
import dps.page.PagerHelper;

public class UserAction extends ActionSupport {
	private User user;//用户实体
	private String validateCode;//登陆时的验证码
	private UserDao userDao = new UserDaoImpl();//数据库操作接口
	private String searchType;//查询类型
	private String searchValue;//查询值
	
	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	public String getSearchValue() {
		return searchValue;
	}


	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getValidateCode() {
		return validateCode;
	}


	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}


	//用户登录逻辑
	public String login() throws Exception {
		Object obj = ActionContext.getContext().getSession().get("code");
		String code = obj==null?"":obj.toString();
		if(code.equalsIgnoreCase(this.validateCode))
		{
				if(this.userDao.loginCheck(this.user.getUname(), this.user.getUpassword()))
			{
				ActionContext.getContext().getSession().put("user", user);
				return SUCCESS;
			}
			else
			{
				this.addActionMessage("登录失败，请重新登录");
			}
		}
		else
		{
			this.addActionMessage("校验码错误，请重新输入");
		}
		return INPUT;
	}
	//用户注册逻辑
	public String regist() throws Exception {
		this.userDao.save(this.user);
		this.addActionMessage("注册成功，请登录");
		return SUCCESS;
	}
	//到用户修改界面
	public String preUpdate() throws Exception {
		Object uid = ServletActionContext.getRequest().getParameter("uid");
		this.user = this.userDao.get(uid);
		return SUCCESS;
	}
	//删除用户
	public String delete() throws Exception {
		Object uid = ServletActionContext.getRequest().getParameter("uid");
		this.userDao.delete(this.userDao.get(uid));
		return SUCCESS;
	}
	//用户修改
	public String update() throws Exception {
		this.userDao.update(this.user);
		return SUCCESS;
	}
	//列出所有用户
	public String listAllUser() throws Exception {
		List<User> allUserList = this.userDao.selectAllUser();
		ServletActionContext.getRequest().setAttribute("allUserList", allUserList);
		return SUCCESS;
	}
	//列出所有用户  --有分页 
	public String listAllUserPage() throws Exception {
		int totalRows = 0;// 记录总行数，待hibernate计算
		Pager pager = null; // 页面信息
		int pageSize = 5;// 每页记录数
		HttpServletRequest request = ServletActionContext.getRequest();
		totalRows = userDao.getTotalRows(); // 获取数据库总行数
		pager = PagerHelper.getPager(request, totalRows, pageSize); // 初始化分页对象
		pager.setLinkUrl("listAllUserPage.action?"); // 设置跳转路径，也可以是？&
		request.setAttribute("pb", pager); // 将分页信息保存在Request对象pb中
		List<User> userList = userDao.selectAllUserPage(pager);// 根据分页范围内的list
		request.setAttribute("allUserList", userList);
		return  SUCCESS;
	}
	// 根据条件查询  --有分页 
	public String searchUser() throws Exception {
		int totalRows = 0;// 记录总行数，待hibernate计算
		Pager pager = null; // 页面信息
		int pageSize = 5;// 每页记录数
		HttpServletRequest request = ServletActionContext.getRequest();
		totalRows = userDao.getSearchRows(searchType, searchValue); // 获取数据库总行数
		pager = PagerHelper.getPager(request, totalRows, pageSize); // 初始化分页对象
//		pager.setLinkUrl("searchUser.action?"); // 设置跳转路径，也可以是？&
		pager.setLinkUrl("searchUser.action?searchType="+searchType+"&searchValue="+searchValue+"&"); // 设置跳转路径，也可以是？&

		request.setAttribute("pb", pager); // 将分页信息保存在Request对象pb中
		List<User> userList = userDao.searchUserPage(pager, searchType, searchValue);// 根据分页范围内的list
		request.setAttribute("allUserList", userList);
		return  SUCCESS;
	}
}
