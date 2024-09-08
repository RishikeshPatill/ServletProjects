package OrderPizza;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
			PrintWriter pw=res.getWriter();
			String name=req.getParameter("name");
			String crust=req.getParameter("crust");
			String []toppings=req.getParameterValues("toppings");
			String appetizer=req.getParameter("apt");
			String address=req.getParameter("address");
			String creditCard=req.getParameter("creditCard");
			long cardNumber=Long.parseLong(req.getParameter("cardNumber"));
			long confirmNumber=Long.parseLong(req.getParameter("confirmNumber"));
			String orderStatus="order confirmed";
			
			StringBuffer sb=new StringBuffer();
			for(String y:toppings) {
				sb.append(y+"\n");
			}
			if(cardNumber==confirmNumber)
			{
				pw.print("pararmeter name : "+"parameter value"+"<br>");
			    pw.print("order status : "+orderStatus+"<br>");
			    pw.print("address :"+address+"<br>");
			    pw.print("customer name :"+name+"<br>");
			    pw.print("appitizer :"+appetizer+"<br>");
			    pw.print("crust :"+crust+"<br>");
			    pw.print("toppings :"+sb.toString()+"<br>");
			    pw.print("credit card :"+creditCard+"<br>");
			    pw.print("card number :"+cardNumber+"<br>");
			    
			}else {
				pw.print("enter the credit card number again");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
