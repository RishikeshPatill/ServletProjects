package ServletTask3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
			PrintWriter pw=res.getWriter();
			UserBean ub=new UserBean();
			ub.setUserName(req.getParameter("userName"));
			ub.setPassWord(req.getParameter("passWord"));
			ub.setFirstName(req.getParameter("firstName"));
			ub.setLastName(req.getParameter("lastName"));
			ub.setAddress(req.getParameter("address"));
			ub.setEmail(req.getParameter("mailId"));
			ub.setPhone(Long.parseLong(req.getParameter("phone")));
			
			RegisterDAO rd=new RegisterDAO();
			int exceuteUpdate = rd.RegisterUser(ub);
				
			if(exceuteUpdate>0) {
				pw.print("user registered successfully");
			}else {
				pw.print("registration failed");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
