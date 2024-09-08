package ExamTaskSetA;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;


public class LoginDAO {
	public static Connection con = null;

	UserBean userBean=new UserBean();
	public UserBean login(UserBean ub) {

		try {
			
			con = DBConnection.getConnection();
			
            PreparedStatement pt1=con.prepareStatement("select * from rgisterUser where uname=? and upword=?");
            pt1.setString(1, ub.getUserName());
            pt1.setString(2, ub.getPassWord());
            
            ResultSet rs1 = pt1.executeQuery();
            if(rs1.next())
            {
            	String userName=rs1.getString(1);
            	String passWord=rs1.getString(2);
            	userBean.setUserName(userName);
            	userBean.setPassWord(passWord);
            	userBean.setAddress(rs1.getString(3));
            	userBean.setEmail(rs1.getString(4));
            	userBean.setPhone(rs1.getLong(5));
            //	userBean.set
            	
            	
            }else {
            	
            }
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ub;
	}
}
