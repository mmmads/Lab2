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
<h1>图书详细信息</h1>
<center>
<table align="center" class="table table-hover">
			<tr class="info">
				<!--  在行加样式 -->
				<th>图书详情</th>
			</tr>
			<tr>
			<td>ISBN</td>  
			<td>Title</td>   
      		<td>AuthorID</td>   
      		<td>Publisher</td>   
      		<td>PublishDate</td>   
      		<td>Price</td>   
			</tr>
			<s:iterator value="book">
				<tr>
					<td><s:property value="ISBN" /></td>
					<td><s:property value="Title" /></td>
					<td><s:property value="AuthorID" /></td>
					<td><s:property value="Publisher" /></td>
					<td><s:property value="PublishDate" /></td>
					<td><s:property value="Price" /></td>
				</tr>
			</s:iterator>

		</table>
		
<table align="center" class="table table-hover">
			<tr class="info">
				<!--  在行加样式 -->
				<th>作者详情</th>
			</tr>
			<tr> 
      		<td>AuthorID</td>   
      		<td>Name</td>   
      		<td>Age</td>   
      		<td>Country</td>   
			</tr>
			<s:iterator value="author">
				<tr>
					<td><s:property value="AuthorID" /></td>
					<td><s:property value="Name" /></td>
					<td><s:property value="Age" /></td>
					<td><s:property value="Country" /></td>
				</tr>
			</s:iterator>
		</table>
		<a href="Back"><input type="submit" value="返回"></a>

</center>
</body>
</html>
