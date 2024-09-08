package UserDetailsApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/viewUser")
public class ViewServlet extends HttpServlet {

	ArrayList<UserBean>users=new ArrayList<UserBean>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
			PrintWriter pw=res.getWriter();
		 
			ViewDAO dao=new ViewDAO();
			ArrayList<UserBean> user = dao.User();
			
			
		
			if(user.isEmpty()) {
				pw.print("no user is there in the database");
			}else {
				pw.print("all the user of the database:");
				Iterator<UserBean> iterator = user.iterator();
				
				while(iterator.hasNext()) {
					UserBean bean = iterator.next();
					
					pw.println(bean);
				}
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
