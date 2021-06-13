package ar.edu.unju.fi.TPFinal.model;

import java.time.LocalDate;

public class Payment {
	
	private int customersNumber;
	private String checkNumber; // tamaño 50
	private LocalDate paymentDate; 
	private double amount;
	
	
	public Payment()
	{
		
	}


	/**
	 * @param customersNumber
	 * @param checkNumber
	 * @param paymentDate
	 * @param amount
	 */
	public Payment(int customersNumber, String checkNumber, LocalDate paymentDate, double amount) {
		super();
		this.customersNumber = customersNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}


	/**
	 * @return the customersNumber
	 */
	public int getCustomersNumber() {
		return customersNumber;
	}


	/**
	 * @param customersNumber the customersNumber to set
	 */
	public void setCustomersNumber(int customersNumber) {
		this.customersNumber = customersNumber;
	}


	/**
	 * @return the checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}


	/**
	 * @param checkNumber the checkNumber to set
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}


	/**
	 * @return the paymentDate
	 */
	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}


	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Payments [customersNumber=" + customersNumber + ", checkNumber=" + checkNumber + ", paymentDate="
				+ paymentDate + ", amount=" + amount + "]";
	}
	
	

}
