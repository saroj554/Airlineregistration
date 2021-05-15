package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbuUility {
	public static final String url = "jdbc:mysql://localhost:3306/mydb";
	public static final String userName = "root";
	public static final String password = "root";
	public static Connection connection = null;
	
	
	public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Registered");
		connection = DriverManager.getConnection(url, userName, password);
		System.out.println("Connection Eastablished");
		// To check JDBC Version
		//DatabaseMetaData databaseMetaData = connection.getMetaData();
		//System.out.println("JDBC version" + databaseMetaData.getJDBCMajorVersion());

		return connection;
	}

	public static void  getDbConnectionClose() throws SQLException
	{
		if(connection!=null)
		{
			connection.close();
		}
	}
}

