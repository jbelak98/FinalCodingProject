package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pckgHelper.Loan;
import pckgHelper.Payment;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;


public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private Button calculate;
	
	@FXML
	private TextField LoanAmount;

	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private TextField AdditionalPayment;
	
	@FXML
	private TextField TotalPayments;
	
	@FXML
	private TextField TotalInterest;
	
	public TableView loanTable = new TableView();
	
	@FXML
	public TableColumn colPaymentNum = new TableColumn("Payment Num");
	
	@FXML
	public TableColumn colDueDate = new TableColumn("Due Date");
	
	@FXML
	public TableColumn colPayment = new TableColumn("Payment");
	
	@FXML
	public TableColumn colAdditionalPayment = new TableColumn("Additional Payment");
	
	@FXML
	public TableColumn colInterest = new TableColumn("Interest");
	
	@FXML
	public TableColumn colPrinciple = new TableColumn("Principle");
	
	@FXML 
	TableColumn colBalance = new TableColumn("Balance");
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		System.out.println("Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);	
		
		lblTotalPayemnts.setText("123");
		
		LocalDate localDate = PaymentStartDate.getValue();
		System.out.println(localDate);
		
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		System.out.println("Interest Rate: " + dInterestRate);
		
		int dNbrOfYears = Integer.parseInt(NbrOfYears.getText());
		System.out.println("Number of Years: " + dNbrOfYears);
		
		double dAdditionalPayment = Double.parseDouble(AdditionalPayment.getText());
		
		
		Loan dLoan = new Loan(dLoanAmount,dInterestRate,dNbrOfYears,dAdditionalPayment,localDate,false,0);
		
		double totalInterest = 0;
		
		for (int i = 0; i < dLoan.LoanPayments.size();i++) {
			Payment payment = dLoan.LoanPayments.get(i);
			loanTable.getItems().add((payment.getPaymentID(),payment.getDueDate(),dAdditionalPayment,payment.getIMPT(),
					payment.getPPMT(),payment.getTotalPrinciple());
			totalInterest += payment.getIMPT();
		}
		
		TotalPayments.setText(String.valueOf(dLoan.LoanPayments.size()));
		TotalInterest.setText(String.valueOf(totalInterest));
		
	}
}
