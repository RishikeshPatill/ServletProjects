package ServletTask3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
			PrintWriter pw=res.getWriter();
			UserBean ub=new UserBean();
			ub.setUserName(req.getParameter("userName"));
			ub.setPassWord(req.getParameter("passWord"));
			
			LoginDAO ld=new LoginDAO();
			UserBean logIn = ld.logIn(ub);
			if(logIn==null) {
				pw.print("login  failed");
			}else {
				pw.print("log in successfull");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
