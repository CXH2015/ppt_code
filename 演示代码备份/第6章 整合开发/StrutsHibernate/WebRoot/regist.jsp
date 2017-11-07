<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript">
  function validate()
  {
		  var psw = document.getElementById("psw").value;
		  var repsw = document.getElementById("repsw").value;
		  var name = document.getElementById("name").value;
		  if(name.length==0)
			  {
				  document.getElementById("error").innerHTML="用户名不能为空";
				  return false;
			  }
		  if(psw.length==0)
			  {
				  document.getElementById("error").innerHTML="密码不能为空";
				  return false;
			  }
			  if(psw!=repsw)
			  {
				  document.getElementById("error").innerHTML="密码和重复密码不一致，请重新输入";
				  return false;
			  }
	  return true;
  }
  </script>
<link href="css/admin.css" rel="stylesheet" type="text/css"/>
<link href="css/theme.css" rel="stylesheet" type="text/css"/>
<title>用户注册</title>
<%int i =0; %>
</head>
<body>
<br>
<br>
<br>
<div class="body-box" align="center">
    <form action="regist.action" method="post">
       <table width="50%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
			<tr>
          <td width="10%" class="pn-flabel pn-flabel-h">用户名：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="user.uname" id="name">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">密码：</td>
          <td width="40%" class="pn-fcontent">
             <input type="password" name="user.upassword" id="psw">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">确认密码：</td>
          <td width="40%" class="pn-fcontent">
             <input type="password" name="repassword"  id="repsw">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">年龄：</td>
          <td width="40%" class="pn-fcontent">
             <select name="user.uage">
             <%   while(i++<100)
            	 {%>
               <option value="<%=i %>"><%=i %></option>
               <%} %>
             </select>
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">生日：</td>
          <td width="40%" class="pn-fcontent">
            <input type="text" name="user.ubirthday" value="2014-5-12"
                                readonly="readonly"
                                class="Wdate"
                                onFocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">性别：</td>
          <td width="40%" class="pn-fcontent">
               <input type="radio" name="user.ugender" value="男"checked="checked">男
               <input type="radio" name="user.ugender" value="女">女
          </td>
          </tr>
          <tr>
            <td width="40%" class="pn-fcontent" colspan="2">
             <div id="error" style="color:red"></div>
          </td>
          </tr>
				<tr>
					<td colspan="2" class="pn-fbutton" width="50%">
						<input type="submit" value="提交" class="submit"  onclick="return validate();"  /> &nbsp; 
						<input type="reset" value="重置" class="reset" class="reset"/>
					</td>
				</tr>
       
       </table>
    
    </form>
    </div>
</body>
</html>