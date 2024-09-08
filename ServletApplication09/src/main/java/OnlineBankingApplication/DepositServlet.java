package OnlineBankingApplication;

import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet{
	public static long depositAmount;
	public static long accountNumber;
	public static long accountBalance;
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		try {
			PrintWriter pw=res.getWriter();
			ServletContext sct=req.getServletContext();
			BankUser logInUser= (BankUser) sct.getAttribute("user");
			
			depositAmount=Long.parseLong(req.getParameter("DepositAmount"));
			accountNumber=logInUser.getAccountNumber();
			accountBalance=logInUser.getAccountBalance();
			if(depositAmount>0) {
			int deposit=featureDAO.deposit();
			if(deposit>0) {
				pw.print(depositAmount+" Rs amount deposited successfully");
			}else {
				pw.print("deposit failed");
			}
			}else {
				pw.print("invalid amount");
				RequestDispatcher rd=req.getRequestDispatcher("deposit.html");
				rd.include(req, res);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
