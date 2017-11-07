<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title><s:text name="loginTitle"/></title>
</head>
<body>
  <center>
       ${tip }
       <s:i18n name="temp">
			    <s:form action="userLogin">
			      <s:textfield name="username" key="loginName"/>
			      <s:password name="password" key="loginPassword"/>
			      <s:submit key="loginSubmit"/>
			    </s:form>
      </s:i18n>
  </center>

</body>
</html>