<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page import="dao.BookDao" %>
<%@ page import="dao.AuthorDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Book" %>
<%@ page import="entity.Author" %>
<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BOOKDB</title>
</head>
<body>
<h1>图书馆内所有图书</h1>
<center>
<table align="center" class="table table-hover">
			<tr class="info">
				<!--  在行加样式 -->
				<th>Title</th>
			</tr>
			<s:iterator value="#booklist">
				<tr>
					<td><a href="BookDetail?ISBN=<s:property value="ISBN" />"><s:property value="Title" /></a></td>
					<td><a href="DeleteBook?ISBN=<s:property value="ISBN" />"><input type="submit" value="删除"></a>
					<a href="UpdateBook?ISBN=<s:property value="ISBN" />"><input type="submit" value="更新"></a></td>
				</tr>
			</s:iterator>
		</table>


</center>
</body>
</html>
