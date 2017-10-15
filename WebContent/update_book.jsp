<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page import="dao.BookDao" %>
<%@ page import="dao.AuthorDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Book" %>
<%@ page import="entity.Author" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BOOKDB</title>
</head>
<body>
<h1>图书更新</h1>
<center>
	<s:form action ="Update" method="post">
	<input type="hidden" name="ISBN" value=<s:property value="ISBN" />>
	<br>请输入作者名字
	<br><input type="text" name="AuthorName"> 
	<br>请输入图书出版社
	<br><input type="text" name="Publisher"> 
	<br>请输入图书出版日期
	<br><input type="text" name="PublishDate"> 
	<br>请输入图书价格
	<br><input type="text" name="Price"> 
	<br><input type="submit" value="提交"> 
	</s:form>
</center>
</body>
</html>