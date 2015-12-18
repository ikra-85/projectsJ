package app.db.main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.Connection;
import java.sql.Statement;

public class Connector {

	
	Connection conn;
	Statement stat;
	static String url, db, user, pass, host, port, driver;
	
	public Connector(Properties props, String password) {
		db = props.getProperty("Database");
		user = props.getProperty("User_name");
		port = props.getProperty("Port");
		host = props.getProperty("Host_name");
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://" + host + ":" + port + "/" + db;
		pass = password; 
	}
	
	public boolean open() {
		try {
			DriverManager.registerDriver( (java.sql.Driver) Class.forName(driver).newInstance());
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			if (conn == null) return false;
		}
		System.out.println(" Connected : true ");
		return true;
	}

	public ResultSet executeQuery(String s) throws SQLException {
		// TODO Auto-generated method stub
		return stat.executeQuery(s);
	}

	public void executeUpdate(String s) throws SQLException {
		stat.executeUpdate(s);
	
	}
	
}
