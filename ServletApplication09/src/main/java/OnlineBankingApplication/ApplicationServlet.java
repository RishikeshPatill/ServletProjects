package OnlineBankingApplication;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/application")
public class ApplicationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res){
	try {
		PrintWriter pw=res.getWriter();
		pw.print("login successfull ");
		
		
		ServletContext sct=req.getServletContext();
		BankUser user=(BankUser)sct.getAttribute("user");
		pw.print(user.getAccountName()+" welcome to bank application ");
		
		String feature=req.getParameter("feature");
		if(feature.equals("withdraw")) {
			pw.print("you have selected withdraw");
			RequestDispatcher rd=req.getRequestDispatcher("withdraw.html");
			rd.forward(req, res);
		}else if(feature.equals("deposit")) {
			pw.print("you have selected deposit");
			RequestDispatcher rd=req.getRequestDispatcher("deposit.html");
			rd.forward(req, res);
			
		}else if(feature.equals("transferMoney")) {
			pw.print("you have selected transact money");
			RequestDispatcher rd=req.getRequestDispatcher("transactMoney.html");
			rd.forward(req, res);
			
		}else {
			pw.print("no options selected");
			RequestDispatcher rd=req.getRequestDispatcher("/ApplicationServlet");
			rd.include(req, res);
					
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
