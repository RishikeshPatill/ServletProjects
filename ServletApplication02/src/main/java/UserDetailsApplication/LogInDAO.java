package UserDetailsApplication;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LogInDAO {
	public static Connection con = null;

	UserBean userBean=null;
	public UserBean login(UserBean ub) {

		try {
			
			con = DBConnection.getConnection();
			
            PreparedStatement pt1=con.prepareStatement("select * from userdetails where uname=? and upword=?");
            pt1.setString(1, ub.getUserName());
            pt1.setString(2, ub.getPassWord());
            
            ResultSet rs1 = pt1.executeQuery();
            if(rs1.next())
            {
            	userBean=new UserBean();
            	
            	userBean.setUserName(rs1.getString(1));
            	userBean.setPassWord(rs1.getString(2));
            	userBean.setAddress(rs1.getString(3));
            	userBean.setMailId(rs1.getString(4));
            	userBean.setPhone(rs1.getLong(5));
            	userBean.setState(rs1.getString(6));
            	userBean.setCountry(rs1.getString(7));
            	
                
            	
            }
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBean;
	}
}
