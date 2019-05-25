package pckgHelper;

import java.util.Date;
import java.text.DecimalFormat;
import java.math.*;
import org.apache.poi.ss.formula.functions.*;

public class Payment {
	
	private int PaymentID;
	private Date DueDate;
	private double IMPT;
	private double PPMT;
	private double TotalPrinciple;
	private double Balance;
	private Loan l;
	
	public Payment(int paymentID, Date dueDate, double balance, Loan l) {
		
		PaymentID = paymentID;
		DueDate = dueDate;
		Balance = balance;
		
		this.l = l;
		this.PPMT = Math.abs(getPPMT());
		this.TotalPrinciple = this.PPMT + l.getExtraPayment();
		this.IMPT = (balance) * (l.getIntRate() / 12);
		this.Balance = balance - this.TotalPrinciple;
		
	}
	
	public double getPPMT() {
		return Finance.ppmt(l.getIntRate()/12, this.PaymentID, l.getTerm()*12, l.getLoanAmount());
	}
	
	public double getBalance() {
		Balance = Math.round(Balance*100.0)/100.0;
		return Balance;
	}
	
	public void ZeroBalance() {
		Balance = 0;
	}

	public int getPaymentID() {
		return PaymentID;
	}

	public Date getDueDate() {
		return DueDate;
	}

	public double getIMPT() {
		return IMPT;
	}

	public double getTotalPrinciple() {
		return TotalPrinciple;
	}
	
	
}
