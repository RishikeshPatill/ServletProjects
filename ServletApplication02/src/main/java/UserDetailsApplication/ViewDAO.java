package UserDetailsApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewDAO {
public static Connection con=null;


public 	ArrayList< UserBean>  User() {
	ArrayList< UserBean> al =new ArrayList<UserBean>();
	try {
		con=DBConnection.getConnection();
		PreparedStatement pt1=con.prepareStatement("select * from userdetails");
		ResultSet rs1 = pt1.executeQuery();
		
		while(rs1.next())
        {
			UserBean userBean=new UserBean();
        	
        	userBean.setUserName(rs1.getString(1));
        	userBean.setPassWord(rs1.getString(2));
        	userBean.setAddress(rs1.getString(3));
        	userBean.setMailId(rs1.getString(4));
        	userBean.setPhone(rs1.getLong(5));
        	userBean.setState(rs1.getString(6));
        	userBean.setCountry(rs1.getString(7));
        	al.add(userBean);
            
        	
        }
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return al;	
}
}
