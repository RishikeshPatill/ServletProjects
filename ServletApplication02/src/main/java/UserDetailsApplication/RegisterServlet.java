package UserDetailsApplication;

import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	 public static Connection con=null;
	 @Override
	 public void doPost(HttpServletRequest req,HttpServletResponse res)
	 {
		 UserBean ub=new UserBean();
		 try
		 {
			 PrintWriter pw=res.getWriter();
			 ub.setUserName(req.getParameter("userName"));
			 ub.setPassWord(req.getParameter("passWord"));
			 ub.setAddress(req.getParameter("address"));
			 ub.setMailId(req.getParameter("mailId"));
			 ub.setPhone(Long.parseLong(req.getParameter("phoneNumber")));
			 ub.setState(req.getParameter("state"));
			 ub.setCountry(req.getParameter("country"));
			 
			 RegisterDAO rd=new RegisterDAO(); //we have to call non static method so that we have to make object of dao class.
			 
			 int executeUpdate = rd.insert(ub);
			 
			 if(executeUpdate>0) {
				 pw.print("user registration successfull");
			 }else {
				 pw.print("user registration failed");
			 }
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	 }
	 
//		@Override
//		public void service(ServletRequest req, ServletResponse res){
//		
//			try {
//				PrintWriter pw=res.getWriter();
//				con=DBConnection.getConnection();
//				String userName=req.getParameter("userName");
//				String PassWord=req.getParameter("passWord");
//				String address=req.getParameter("address");
//				String mailId=req.getParameter("mailId");
//			    long phoneNumber=Long.parseLong(req.getParameter("phoneNumber"));
//			    String state=req.getParameter("state");
//			    String country=req.getParameter("country");
//			    PreparedStatement pstmt1=con.prepareStatement("insert into userDetails values(?,?,?,?,?,?,?");
//			    pstmt1.setString(1, userName);
//			    pstmt1.setString(2, PassWord);
//			    pstmt1.setString(3, address);
//			    pstmt1.setString(4, mailId);
//			    pstmt1.setLong(5, phoneNumber);
//			    pstmt1.setString(6, state);
//			    pstmt1.setString(7, country);
//			    int executeUpdate = pstmt1.executeUpdate();
//			    PreparedStatement pstmt2=con.prepareStatement("select * from userDetails where phoneNumber=? and mailId=?");
//			    pstmt2.setLong(1, phoneNumber);
//			    pstmt2.setString(2, mailId);
//			    ResultSet rs1=pstmt2.executeQuery();
//			    if(executeUpdate>0)
//			    {
//			    	pw.print("<h1>user registration successfull.</h1>");
//			    	
//			        if(rs1.next())
//			        {
//			        	ResultSetMetaData rsmd1=rs1.getMetaData();
//			        	for(int i=1;i<=rsmd1.getColumnCount();i++)
//			        	{
//			        		pw.print(rsmd1.getColumnName(i)+"\t");
//			        	}
//			        	pw.println("<br>------------------------------------------------------------------------------------------------------------<br>");
//			        	pw.print(rs1.getString(1));
//			        	pw.print(rs1.getString(2));
//			        	pw.print(rs1.getString(3));
//			        	pw.print(rs1.getString(4));
//			        	pw.print(rs1.getLong(5));
//			        	pw.print(rs1.getString(6));
//			        	pw.print(rs1.getString(7));
//			        }
//			    	pw.print("<h1>thank you fro registration</h1>");
//			    	
//			    }
//			    
//			}catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//			
//			
//		}
}
