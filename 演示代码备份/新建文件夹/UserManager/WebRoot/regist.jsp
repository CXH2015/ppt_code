<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
   <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�û�ע��ҳ��</title>
</head>
<body>
<br/>
 <center>
	<s:form action="userRegist" >
	  	<s:textfield name="username"  label="�û���"/>
	  	<s:password name="password" label="����"/>
	  	<s:password name="repassword" label="�ظ�����"/>
	  	 <s:radio list="{'��','Ů'}" name="gender"  value="'��'" />
	  	 <s:textfield name="birthday" label="����(��ʽ��:1990-01-01)"/>
	  	 <s:checkboxlist list="{'����','��Ϸ','����Ӱ','����'}" name="habby" label="����"/>
	  	 <s:textarea rows="3" cols="15" name="address" label="��ͥסַ"/>
	  	 <s:submit value="ע��"/>
	</s:form>
	</center>
</body>
</html>