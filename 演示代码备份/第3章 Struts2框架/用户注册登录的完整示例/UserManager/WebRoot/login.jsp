<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆页面</title>
</head>
<body>
  <center>
       ${tip }
    <form action="login.action" method="post">
    <table>
    <tr>
      <td>用户名</td>
      <td> <input type="text" name="username"></td>
    </tr>
    <tr>
      <td>密码</td>
      <td> <input type="password" name="password"></td>
    </tr>
    <tr>
      <td> <input type="submit"  value="登陆" /></td>
      <td> <a href="regist.jsp">还没注册？</a></td>
    </tr>
      </table> 
    </form>
    
    </center>
</body>
</html>
