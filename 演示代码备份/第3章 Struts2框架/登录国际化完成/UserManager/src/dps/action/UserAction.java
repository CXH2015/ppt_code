package dps.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		//定义返回值变量
		String strReturn = INPUT;
		//业务逻辑判断
		if(this.username.equals("abc")&&this.password.equals("123"))
			strReturn = SUCCESS;
		else
			ActionContext.getContext().getSession().put("tip","登录失败");
		return strReturn;
		}
	}

