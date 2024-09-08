package OnlineBankingApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;

public class featureDAO {
public static Connection con=null;
public static long withdrawAmount;
public static long depositAmount;
public static long transactAmount;
public static int executeUpdate;
private static int executeUpdate2;

public static int withdraw() {
	try {
		con=DBConnection.getConnection();
		 withdrawAmount=WithdrawServlet.withdrawAmount;
		long accountBalance=WithdrawServlet.accountBalance;
	    long accountNumber=WithdrawServlet.accountNumber;
		PreparedStatement pt1=con.prepareStatement("update bankaccount set ACCBALANCE=? where ACCNO=?");
		//if(accountBalance>withdrawAmount)
		accountBalance=accountBalance-withdrawAmount;
    	pt1.setLong(1, accountBalance);
    	pt1.setLong(2, accountNumber);
	    executeUpdate = pt1.executeUpdate();
	    con.commit();
	}catch(Exception e) {
		e.printStackTrace();
		try {
			con.rollback();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	return executeUpdate;
}
public static int deposit() {
	try {
		con=DBConnection.getConnection();
		depositAmount=DepositServlet.depositAmount;
		long accountNumber=DepositServlet.accountNumber;
		long accountBalance=DepositServlet.accountBalance;
		PreparedStatement pt1=con.prepareStatement("update bankaccount set accbalance=? where ACCNO=?");
		accountBalance=accountBalance+depositAmount;
		pt1.setLong(1, accountBalance);
		pt1.setLong(2, accountNumber);
		executeUpdate=pt1.executeUpdate();
		con.commit();
	}catch(Exception e) {
		e.printStackTrace();
		try {
			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	return executeUpdate;
}
public static int transferMoney() {
	try {
		con=DBConnection.getConnection();
		//Sender details
		transactAmount=TransactServlet.transferAmount;
		long senderAccountNumber=TransactServlet.senderAccountNumber;
		long senderAccountBalance=TransactServlet.senderAccountBalance;
		
		PreparedStatement pt1=con.prepareStatement("update bankaccount set accbalance=? where accno=?");
		senderAccountBalance=senderAccountBalance-transactAmount;
		pt1.setLong(1, senderAccountBalance);
		pt1.setLong(2, senderAccountNumber);
		
	    int executeUpdate1= pt1.executeUpdate();
	    
	    //Receiver Details
	    long recieverAccountNumber=TransactServlet.recieverAccountNumber;
	   // long recieverAccountBalance=TransactServlet.recieverAccountBalance;
	    if(executeUpdate1>0) {
	    	PreparedStatement pt2=con.prepareStatement("select * from bankaccount where accno=?");
	    	pt2.setLong(1, recieverAccountNumber);
	    	ResultSet rs1=pt2.executeQuery();
	    	if(rs1.next()) {
	    		long recieverAccountNum=rs1.getLong(1);
	    		long recieverAccountBal=rs1.getLong(3);
	    		
	    		PreparedStatement pt3=con.prepareStatement("update bankaccount set accbalance=? where accno=?");
	    		recieverAccountBal=recieverAccountBal+transactAmount;
	    		pt3.setLong(1, recieverAccountBal);
	    		pt3.setLong(2, recieverAccountNum);
	    		 executeUpdate2 = pt3.executeUpdate();
	    		if (executeUpdate2>0){
	    			con.commit();
	    		}else {
	    			con.rollback();
	    		}
	    	}
	    }
	   
	    
	}catch(Exception e) {
		e.printStackTrace();
	}
	return executeUpdate2;
}
}
