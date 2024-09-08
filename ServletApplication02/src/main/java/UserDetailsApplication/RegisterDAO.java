package UserDetailsApplication;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class RegisterDAO extends HttpServlet{
	 public static Connection con=null;
	 int executeUpdate=0;
	 public int insert(UserBean ub)
	 {
		 try {
			 con=DBConnection.getConnection();
			 PreparedStatement pt1=con.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?)");
			 pt1.setString(1, ub.getUserName());
			 pt1.setString(2, ub.getPassWord());
			 pt1.setString(3, ub.getAddress());
			 pt1.setString(4, ub.getMailId());
             pt1.setLong(5, ub.getPhone());
             pt1.setString(6, ub.getState());
             pt1.setString(7, ub.getCountry());
             
             executeUpdate= pt1.executeUpdate();
              
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return executeUpdate; 
	 }
}
