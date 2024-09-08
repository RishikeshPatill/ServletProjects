package ServletTask3;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO {
public static Connection con=null;
int executeUpdate=0;

public int updatePassWord(UserBean ub) {
	try {
		con=DBConnection.getConnection();
		PreparedStatement pt1=con.prepareStatement("update registeruser set upwd=? where uphno=?");
		
		pt1.setString(1, ub.getPassWord());
		pt1.setLong(2, ub.getPhone());
		
	    executeUpdate = pt1.executeUpdate();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return executeUpdate;
}
}
