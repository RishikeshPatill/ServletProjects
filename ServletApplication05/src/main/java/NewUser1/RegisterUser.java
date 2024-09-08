package NewUser1;

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

@WebServlet("/register")
public class RegisterUser extends GenericServlet {
public static Connection con=null;
	@Override
	public void service(ServletRequest req, ServletResponse res) {
		try {
		PrintWriter pw=res.getWriter();
		con=DBConnection.getConnection();
		int userId=Integer.parseInt(req.getParameter("userId"));
		String uFname=req.getParameter("uFame");
		String uLname=req.getParameter("uLname"); 
		String uEmail=req.getParameter("uEmail");
	    long uPhno=Long.parseLong(req.getParameter("uPhno"));
	    
	    PreparedStatement pt1=con.prepareStatement("insert into newuser1 values(?,?,?,?,?)");
	    pt1.setInt(1, userId);
	    pt1.setString(2, uFname);
	    pt1.setString(3, uLname);
	    pt1.setString(4, uEmail);
	    pt1.setLong(5, uPhno);
	    int executeUpdate = pt1.executeUpdate();
	    if(executeUpdate>0)
	    {
	    	pw.print("user registered successfully");
	    	PreparedStatement pt2=con.prepareStatement("select * from newuser1 where uemail=?");
	    	pt2.setString(1, uEmail);
	    	ResultSet rs1 = pt2.executeQuery();
	    	if(rs1.next())
	    	{
	    		String userName=rs1.getString(2);
	    		pw.print(userName+" thank you for registration");
	    	}
	    	else
	    	{
	    		pw.print("no such user found");
	    	}
	    }
	    else
	    {
	    	pw.print("registration failed");
	    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
