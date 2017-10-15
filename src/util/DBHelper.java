package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {


	String driver = "com.mysql.jdbc.Driver";
	String username = System.getenv("ACCESSKEY");
	String password = System.getenv("SECRETKEY");
	String dbName = System.getenv("MYSQL_DB");
	String host = System.getenv("MYSQL_HOST");
	String port = System.getenv("MYSQL_PORT");
	String dbUrl = "jdbc:mysql://"+host+":"+port + "/" +dbName;
	public Connection getConnection() {
		
		//System.getenv("MYSQL_HOST_S"); 为从库，只读
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
		
		try {
			Class.forName(driver);
		
		// 连续数据库
		Connection conn = DriverManager.getConnection(dbUrl, username, password);
		if (!conn.isClosed())
			System.out.println("connecting to the database successfully!");
			return conn;
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}


