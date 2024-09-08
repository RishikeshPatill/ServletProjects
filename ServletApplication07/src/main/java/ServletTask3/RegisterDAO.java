package ServletTask3;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO {
	public static Connection con = null;
	int executeUpdate;

	public int RegisterUser(UserBean ub) {
        try {
        	con=DBConnection.getConnection();
        	PreparedStatement pt1=con.prepareStatement("insert into registeruser values(?,?,?,?,?,?,?)");
        	pt1.setString(1, ub.getUserName());
        	pt1.setString(2, ub.getPassWord());
        	pt1.setString(3, ub.getFirstName());
        	pt1.setString(4, ub.getLastName());
        	pt1.setString(5, ub.getAddress());
        	pt1.setString(6, ub.getEmail());
        	pt1.setLong(7, ub.getPhone());
        	
            executeUpdate = pt1.executeUpdate();
            
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return executeUpdate;

	}
}
