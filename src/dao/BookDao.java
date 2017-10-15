package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Book;
import util.DBHelper;


public class BookDao {

	
	public ArrayList<Book> getALLBook() throws SQLException
	{
		Connection conn=new DBHelper().getConnection();
		ArrayList<Book> list = new ArrayList<Book>();
		
		try
		{
			Statement stmt=conn.createStatement();
			String sql = "select * from book";
			ResultSet rs =stmt.executeQuery(sql);
			while(rs.next())
			{
			    Book book=new Book();
			    book.setISBN(rs.getString("ISBN"));
			    book.setTitle(rs.getString("Title"));
			    book.setAuthorID(rs.getInt("AuthorID"));
			    book.setPublisher(rs.getString("Publisher"));
			    book.setPublishDate(rs.getString("PublishDate"));
			    book.setPrice(rs.getDouble("Price"));
			    list.add(book);
			}
			conn.close();
			return list;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}

	}
	//通过ISBN获得book资料
	public Book getBookByISBN(String ISBN)
	{
		Connection conn=new DBHelper().getConnection();
		
		try
		{
			String sql = "select * from book where ISBN="+"\""+ISBN+"\"";
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next())
			{
			    Book book=new Book();
			    book.setISBN(rs.getString("ISBN"));
			    book.setTitle(rs.getString("Title"));
			    book.setAuthorID(rs.getInt("AuthorID"));
			    book.setPublisher(rs.getString("Publisher"));
			    book.setPublishDate(rs.getString("PublishDate"));
			    book.setPrice(rs.getDouble("Price"));
			    conn.close();
			   	return book;
			}
			else
			{
				conn.close();
				return null;
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}

	}

	//将对应行的图书从数据表中删除
	
	public void deleteBookByISBN(String ISBN) 
	{
		try {
		Connection conn = new DBHelper().getConnection();
		Statement statement = conn.createStatement();
		String sql = "delete from book where ISBN = "+"\""+ISBN+"\"";
		statement.executeUpdate(sql);
		conn.close();
		}catch (Exception e) {
		// TODO: handle exception
		}

	}
	//更新图书
	public int UpdateBook(String ISBN,String AuthorName,String Publisher,String PublishDate,Double Price) throws SQLException
	{
		try {
		Connection conn = new DBHelper().getConnection();
		Statement statement = conn.createStatement();
		String sql = "select * from book where ISBN = "+"\""+ISBN+"\"";
		ResultSet rs=statement.executeQuery(sql);
		int AuthorID=0;
		if (rs.next())
		{
			if (AuthorName!="")
			{
				sql = "select * from author where Name = \""+AuthorName+"\"";
				rs=statement.executeQuery(sql);
				if (rs.next())
				{
					AuthorID=rs.getInt("AuthorID");
				}
				else
				{
					sql = "insert into author(Name) values (\'"+AuthorName+"\')";
					statement.executeUpdate(sql);
					sql = "select * from author where Name=\""+AuthorName+"\"";
					rs = statement.executeQuery(sql);
					if (rs.next()) 
					{
						AuthorID = rs.getInt("AuthorID");
					}
					
				}
				sql = "update book set AuthorID = \'"+AuthorID+"\' where ISBN = "+"\""+ISBN+"\"";
				statement.executeUpdate(sql);
				
			}
			if (Publisher!="") 
			{
				sql = "update book set Publisher = \'"+Publisher+"\' where ISBN = "+"\""+ISBN+"\"";
				statement.executeUpdate(sql);
			}
			if (PublishDate!="")
			{
				sql = "update book set PublishDate = \'"+PublishDate+"\' where ISBN = "+"\""+ISBN+"\"";
				statement.executeUpdate(sql);
			}
			if (Price!=0) 
			{
				sql = "update book set Price = \'"+Price+"\' where ISBN = "+"\""+ISBN+"\"";
				statement.executeUpdate(sql);
			}
			conn.close();
			return 1;
		
		}
		conn.close();
		return 1;
		}
		catch (Exception e) {
		// TODO: handle exception
		}
		return 0;
	}
	//更新图书
	public int AddBook(String ISBN, String Title,String Name, int Age, String Country,String Publisher,String PublishDate,Double Price)
	{
		try {
		Connection conn=new DBHelper().getConnection();
		Statement statement=conn.createStatement();
		ResultSet rs=null;
		String sql="select * from book where ISBN = "+"\""+ISBN+"\"";
		rs=statement.executeQuery(sql);
		if (rs.next())
		{
			//这本书已经存在
			conn.close();
			return 1;
		}
		else
		{
			AuthorDao authordao=new AuthorDao();
			//作者不存在
			if (!authordao.AuthorExist(Name))
			{
				sql = "insert into author(Name,Age,Country) values (\'"+Name+"\',\'"+Age+"\',\'"+Country+"\')";
				statement.executeUpdate(sql);
			}
			int AuthorID=authordao.getAuthorIDByName(Name);
			sql = "insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values (\'"+ISBN+"\',\'"+Title+"\',\'"+AuthorID+"\',\'"+Publisher+"\',\'"+PublishDate+"\',\'"+Price+"\')";
			statement.executeUpdate(sql);
			conn.close();
			return 0;
		}
		}
		catch (Exception e) {
		// TODO: handle exception
		}
		return 0;
	}
}

