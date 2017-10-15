<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BOOKDB</title>
</head>
<body>
<h1>欢迎来到图书管理系统!</h1>
	<h2> 图书查询</h2>
	<s:form action = "AuthorTitle">
	<br>请输入作者名字
	<br><input type="text" name="authorname"> 
	<input type="submit" value="提交"> 
	</s:form>
	<br>
	<h2> 图书增添 </h2>
	<s:form action = "AddBook">
	<input type="submit" value="图书增添"> 
	</s:form>
	<br>
	<h2> 查看全部图书 </h2>
	<s:form action = "AllBook">
	<input type="submit" value="确定"> 
	</s:form>
</body>
</html>
