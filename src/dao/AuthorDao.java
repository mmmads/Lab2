package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Author;
import entity.Book;
import util.DBHelper;


public class AuthorDao {

	public Author getAuthorByAuthorID(int AuthorID)
	{
		Connection conn=new DBHelper().getConnection();
		
		try
		{
			Statement stmt= conn.createStatement();
			String sql = "select * from author where AuthorID="+"\""+AuthorID+"\"";
			ResultSet rs =stmt.executeQuery(sql);
			Author author=null;
			if(rs.next())
			{
				author=new Author();
				author.setAuthorID(rs.getInt("AuthorID"));
				author.setName(rs.getString("Name"));
				author.setAge(rs.getInt("Age"));
				author.setCountry(rs.getString("Country"));
			}
			conn.close();
		   	return author;
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		return null;
		
	}
	
	public int getAuthorIDByName(String Name) throws SQLException
	{
		Connection conn=new DBHelper().getConnection();
		
		try
		{
			Statement stmt=conn.createStatement();
			String sql = "select * from author where Name="+"\""+Name+"\"";
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next())
			{
				int AuthorID=rs.getInt("AuthorID");
				conn.close();
				return AuthorID;
			}
			else
			{
				conn.close();
				return 0;
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			conn.close();
			return 0;
		}
	}
	public ArrayList<Book> getAllBooks(int AuthorID)
	{
		Connection conn= new DBHelper().getConnection();
		ArrayList<Book> booklist = new ArrayList<Book>();
		
		try
		{
			Statement stmt=conn.createStatement();
			String sql = "select * from book where AuthorID="+"\""+AuthorID+"\"";
			ResultSet rs =stmt.executeQuery(sql);
			while(rs.next())
			{
				Book book=new Book();
				String Title=rs.getString("Title");
				String ISBN=rs.getString("ISBN");
				String Publisher=rs.getString("Publisher");
				String PublishDate=rs.getString("PublishDate");
				double Price=rs.getDouble("Price");
				book.setTitle(Title);
				book.setISBN(ISBN);
				book.setPublisher(Publisher);
				book.setPublishDate(PublishDate);
				book.setAuthorID(AuthorID);
				book.setPrice(Price);
				booklist.add(book);
			}
			conn.close();
			return booklist;
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			return null;
		}
	
	}
	public boolean AuthorExist(String Name)
	{
		Connection conn=new DBHelper().getConnection();
		try 
		{
			Statement statement=conn.createStatement();
			String sql="select * from author where Name = "+"\""+Name+"\"";
			ResultSet rs=statement.executeQuery(sql);
			if (rs.next())
			{
				//该作者存在
				conn.close();
				return true;
			}
			else 
			{
				conn.close();
				return false;
			}
		}
		catch (SQLException e) {
		// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}
}
