package ServletTask3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
			PrintWriter pw=res.getWriter();
			UserBean ub=new UserBean();
			ub.setPhone(Long.parseLong(req.getParameter("phone")));
			
			DeleteDAO dd=new DeleteDAO();
			int deleteUser = dd.deleteUser(ub);
			if(deleteUser>0) {
				pw.print("user deleted successfully");
			}else
			{
				pw.print("delete failed");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
