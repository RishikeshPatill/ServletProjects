package PersonDetailsApplication;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Arrays;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/register")
public class PersonDetails extends GenericServlet{
public static Connection con=null;
	@Override
	public void service(ServletRequest req, ServletResponse res)  {
		
		try {
			PrintWriter pw=res.getWriter();
			con=DBConnection.getConnection();
			
			String userName=req.getParameter("userName");
			int userAge=Integer.parseInt(req.getParameter("userAge"));
			long mobileNumber=Long.parseLong(req.getParameter("mobileNumber"));
			String gender=req.getParameter("gender");
		    String []hobbies=req.getParameterValues("hobbies");
		    
		    StringBuffer myHobby=new StringBuffer();
		    
			for(String hobby:hobbies) {
				myHobby.append(hobby+",");
			}
			
		    PreparedStatement pstmt1=con.prepareStatement("insert into PersonDetails values(?,?,?,?,?)");
		    pstmt1.setString(1,userName);
			pstmt1.setInt(2, userAge);
			pstmt1.setLong(3, mobileNumber);
			pstmt1.setString(4, gender);
			pstmt1.setString(5, myHobby.toString());
			int executeUpdate = pstmt1.executeUpdate();
			PreparedStatement pstmt2=con.prepareStatement("select * from PersonDetails where mobile=?");
			pstmt2.setLong(1, mobileNumber);
			ResultSet rs1=pstmt2.executeQuery();
			if(executeUpdate>0) {
				pw.println("<h1>User Registration successfull.</h1>");
			   
			   
			    if(rs1.next())
			    {
			    	ResultSetMetaData rsmd1=rs1.getMetaData();
			    	for(int i=1;i<=rsmd1.getColumnCount();i++)
			    	{
			    		pw.print(rsmd1.getColumnName(i)+"\t");
			    	}
				    pw.print("<br>---------------------------------------------------------------------------<br>");
			    	pw.print(rs1.getString(1)+"\t");
			    	pw.print(rs1.getInt(2)+"\t");
			    	pw.print(rs1.getLong(3)+"\t");
			    	pw.print(rs1.getString(4)+"\t");
			    	pw.print(rs1.getString(5).toString()+"\t");
			    }
			    pw.print("<br>---------------------------------------------------------------------------<br>");
				pw.println("<h1>"+" "+userName+" thank you for Registration</h1>");
			}else {
				pw.println("Registration failed");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	

}
//body {
//	display: flex;
//	justify-content: center;
//	align-items: center;
//	height: 70vh;
//	background-color: grey;
//}
//div{
//	background-color: forestgreen;
//	border:  1px solid red;
//	padding: 10px;
//}
//h1 {
//	text-align: center;
//}
