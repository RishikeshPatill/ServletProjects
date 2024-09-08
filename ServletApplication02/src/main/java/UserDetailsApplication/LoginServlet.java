package UserDetailsApplication;


import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		try {
		 PrintWriter pw=res.getWriter();
		 UserBean ub=new UserBean();
		 ub.setUserName(req.getParameter("userName"));
		 ub.setPassWord(req.getParameter("passWord"));
		 
		 LogInDAO ld=new LogInDAO();
		 UserBean login = ld.login(ub);
		 
		 if(login==null) {
			 pw.print("failed to login");
		 }else {
			 pw.print("login successfull");
		 }
		
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		
	}
}