package ServletTask3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
			PrintWriter pw=res.getWriter();
			UserBean ub=new UserBean();
			ub.setPhone(Long.parseLong(req.getParameter("phone")));
			ub.setPassWord(req.getParameter("passWord"));
			
			UpdateDAO ud=new UpdateDAO();
			int updatePassWord = ud.updatePassWord(ub);
			if(updatePassWord>0) {
				pw.print("user updated successfully");
			}else {
				pw.print("user updated failed");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
