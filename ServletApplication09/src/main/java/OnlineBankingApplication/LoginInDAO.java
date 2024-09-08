package OnlineBankingApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;

public class LoginInDAO {
	public static Connection con=null;
	
	public static BankUser logIn(BankUser user) 
	{
		BankUser u = null;
		try {
		
			con=DBConnection.getConnection();
			PreparedStatement pt1=con.prepareStatement("select * from bankaccount where accno=? and accname=?");
			pt1.setLong(1,user.getAccountNumber());
			pt1.setString(2, user.getAccountName());
			
			ResultSet rs1 = pt1.executeQuery();
			if(rs1.next()) {
				u=new BankUser();
				u.setAccountNumber(rs1.getLong(1));
				u.setAccountName(rs1.getString(2));
				u.setAccountBalance(rs1.getLong(3));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;	
	}

}
