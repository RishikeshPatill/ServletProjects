package UserDetailsApplication;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection implements DBInfo {

	public static Connection con=null;
	
	public static Connection getConnection()
	{
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url, username, password);
	    
		
		}catch(Exception e)
		{
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
