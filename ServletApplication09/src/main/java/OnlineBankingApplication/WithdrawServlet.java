package OnlineBankingApplication;

import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {
	public static long withdrawAmount;
	public static long accountNumber;
	public static long accountBalance;
	public static String accountName;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter pw = res.getWriter();
			ServletContext sct = req.getServletContext();
			BankUser logInUser = (BankUser) sct.getAttribute("user");
			//System.out.println(logInUser.getAccountBalance());
			withdrawAmount = Long.parseLong(req.getParameter("withdrawAmount"));
			
			accountNumber = logInUser.getAccountNumber();
			accountBalance = logInUser.getAccountBalance();
			accountName = logInUser.getAccountName();
			if (withdrawAmount <= accountBalance && withdrawAmount > 0) {
				int withdraw = featureDAO.withdraw();

				if (withdraw > 0) {
					pw.print(withdrawAmount + " Rs withdrawn successfully");
				} else {
					pw.print("withdraw failed");
				}
			} else {
				pw.print("invalid amount");
				RequestDispatcher rd = req.getRequestDispatcher("withdraw.html");
				rd.include(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
