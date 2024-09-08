package OnlineBankingApplication;

import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/transactMoney")
public class TransactServlet extends HttpServlet{
	public static long transferAmount;
	public static long senderAccountNumber;
	public static long senderAccountBalance;
	public static long recieverAccountNumber;
	public static long recieverAccountBalance;
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		try {
			PrintWriter pw=res.getWriter();
			ServletContext sct=req.getServletContext();
			BankUser logInUser = (BankUser) sct.getAttribute("user");
			//Sender details
			senderAccountNumber=logInUser.getAccountNumber();
			senderAccountBalance=logInUser.getAccountBalance();
			//Receiver details
			recieverAccountNumber=Long.parseLong(req.getParameter("recieverAccountNumber"));
			transferAmount=Long.parseLong(req.getParameter("transferAmount"));
			
			if(transferAmount>0 && transferAmount<=senderAccountBalance && senderAccountNumber!=recieverAccountNumber){
				int transactMoney=featureDAO.transferMoney();
			
				if(transactMoney>0) {
				   pw.print("transaction successfull");
				}else {
					pw.print("transaction failed");
				}
				
			}else {
				pw.print("invalid amount or account number");
				RequestDispatcher rd=req.getRequestDispatcher("transactMoney.html");
				rd.include(req, res);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
