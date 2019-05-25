package pkgUT;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import pckgHelper.Loan;
import pckgHelper.Payment;

public class TestLoan {

	@Test
	public void testLoan() {
		double loanAmount = 200000;
		double intRate = 0.06;
		int term = 30;
		double extraPayment = 0;
		Date firstDueDate = Loan.parseDate("2021-08-01");
		boolean bCompoundType = false;
		double futureValue = 0;
		
		Loan loan = new Loan(loanAmount,intRate,term,extraPayment,firstDueDate,bCompoundType,futureValue);
		
		assertEquals(loan.getLoanAmount(),200000,0.001);
		assertEquals(loan.getIntRate(),0.06,0.0001);
		assertEquals(loan.getTerm(),30);
		assertEquals(loan.getExtraPayment(),0,0.001);
		assertEquals(loan.isbCompoundType(),false);
		assertEquals(loan.getFutureValue(),0,0.001);
		
		for (int i = 0; i < loan.LoanPayments.size();i++) {
			Payment payment = loan.LoanPayments.get(i);
			
			assertEquals(payment.getPPMT(),1199.10,.001);
			assertEquals(payment.getPaymentID(),i+1);
		}
			
	}

}
