package NewUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet("/registerStudent")
public class InsertUser extends GenericServlet {
public static Connection con=null;
	@Override
	public void service(ServletRequest req, ServletResponse res)  {
	
		try {
			PrintWriter pw=res.getWriter();
			con=DBConnection.getConnection();
			String firstName=req.getParameter("firstName");
			String middleName=req.getParameter("middleName");
			String lastName=req.getParameter("lastName");
			long phone=Long.parseLong(req.getParameter("phone"));
			
			PreparedStatement pstmt1=con.prepareStatement("insert into newuser values(?,?,?,?)");
			pstmt1.setString(1, firstName);
			pstmt1.setString(2, middleName);
			pstmt1.setString(3, lastName);
			pstmt1.setLong(4, phone);
			int executeUpdate = pstmt1.executeUpdate();
			if(executeUpdate>0) {
				pw.print("user registration successfull");
			}
			else {
				pw.print("failed");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	

}
