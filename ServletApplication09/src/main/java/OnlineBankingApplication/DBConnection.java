package OnlineBankingApplication;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username="RISHIKESH";
	private static final String password="RISHI";
	public static Connection con=null;
	
	
	public static Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
}
