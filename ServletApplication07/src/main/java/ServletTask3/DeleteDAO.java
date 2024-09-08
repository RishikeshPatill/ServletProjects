package ServletTask3;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDAO {
	public static Connection con=null;
    int executeDelete=0;
    public int deleteUser(UserBean ub) {
    	try {
    		con=DBConnection.getConnection();
    	PreparedStatement pt1=con.prepareStatement("delete from registeruser where uphno=?");
    	pt1.setLong(1, ub.getPhone());
    	executeDelete=pt1.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return executeDelete;
    }
}
