package ServletTask3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	public static Connection con = null;
    UserBean userBean=null;
	public UserBean logIn(UserBean ub) {
    try {
    	con=DBConnection.getConnection();
    	PreparedStatement pt1=con.prepareStatement("select * from registeruser where uname=? and upwd=?");
    	pt1.setString(1, ub.getUserName());
    	pt1.setString(2, ub.getPassWord());
    	
    	ResultSet rs1 = pt1.executeQuery();
    	if(rs1.next()){
    		UserBean userBean=new UserBean();
    		userBean.setUserName(rs1.getString(1));
    		userBean.setPassWord(rs1.getString(2));
    		userBean.setFirstName(rs1.getString(3));
    		userBean.setLastName(rs1.getString(4));
    		userBean.setAddress(rs1.getString(5));
    		userBean.setEmail(rs1.getString(6));
    		userBean.setPhone(rs1.getLong(7));
    		
    		
    		
    		
    	}
    }catch(Exception e) {
    	e.printStackTrace();
    }
		return userBean;
	}

}
