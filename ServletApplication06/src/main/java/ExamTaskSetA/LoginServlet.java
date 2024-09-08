package ExamTaskSetA;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		 UserBean ub=new UserBean();
		 ub.setUserName(req.getParameter("userName"));
		 ub.setPassWord(req.getParameter("passWord"));
		 
		 
	}

}
