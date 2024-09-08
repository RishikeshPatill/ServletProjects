package OnlineBankingApplication;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.connector.Response;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LogInServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		BankUser logIn =null;
		try {
			PrintWriter pw = res.getWriter();
            BankUser user=new BankUser();
           
            user.setAccountNumber(Long.parseLong(req.getParameter("accountNumber")));
            user.setAccountName(req.getParameter("accountName"));
            
            BankUser logInUser = LoginInDAO.logIn(user);
            ServletContext sct=req.getServletContext();
            sct.setAttribute("user", logInUser);
            if(logInUser==null) {
            	pw.print("login failed");
            	RequestDispatcher rd=req.getRequestDispatcher("login.html");
            	rd.include(req, res);	
            }
            else {
            	
            	RequestDispatcher rd=req.getRequestDispatcher("application.html");
            	rd.forward(req, res);
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
