package ServletTask3;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection con = null;
	public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String username = "RISHIKESH";
	public static final String password = "RISHI";

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
}
//<table>
//<tr>
//<td>
//
//</td>
//</tr>
//</table>
