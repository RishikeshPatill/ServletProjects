package ExamTaskSetA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		    PrintWriter pw= res.getWriter();
		
			UserBean ub=new UserBean();
			
			ub.setUserName(req.getParameter("userName"));
			ub.setPassWord(req.getParameter("passWord"));
			ub.setFirstName(req.getParameter("firstName"));
			ub.setLastName(req.getParameter("lastName"));
			ub.setAddress(req.getParameter("address"));
			ub.setEmail(req.getParameter("email"));
			ub.setPhone(Long.parseLong(req.getParameter("phone")));
			int a=new RegisterDAO().registerUser(ub);
			
			
			
			
			
			
		
	}
}
