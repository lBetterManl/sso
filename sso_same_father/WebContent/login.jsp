<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录主页</title>
</head>
<body>
	<center>
		<h1>请登录</h1>
		<form action="http://check.x.com/sso/doLogin.action" method="post">
			<span>用户名：</span><input type="text" name="username"/><br>
			<span>密&nbsp;码：</span><input type="password" name="password"/><br>
			<!-- 暂存请求地址 -->
			<input type="hidden" name="gotoUrl" value="${gotoUrl} "/>
			<input type="submit" value="登录"/>
		</form>
	</center>
</body>
</html>