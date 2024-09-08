package UserNew;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/insertUser")
public class LoginUser extends GenericServlet {
	public static Connection con = null;

	@Override
	public void service(ServletRequest req, ServletResponse res) {

		try {
			PrintWriter pw = res.getWriter();
			con = DBConnection.getConnection();
			String userName=req.getParameter("userName");
			String passWord=req.getParameter("passWord");
			
			PreparedStatement pstmt1=con.prepareStatement("select * from usernew where Name=? and passWord=?");
			pstmt1.setString(1,userName);
			pstmt1.setString(2, passWord);
			
			ResultSet rs1=pstmt1.executeQuery();
			if(rs1.next())
			{
				pw.print("welcome "+rs1.getString(1));
			}
			else {
				pw.print("sorry username or password error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
