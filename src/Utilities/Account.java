package Utilities;

import java.util.Date;

public class Account
{
	private int accountNumber;
	private double balance;
	private double annualInterestRate;
	Date dateCreated = new Date();
	
	public Account()
	{
		this(0, 0, 5, new Date());
	}
	
	public Account(int accountNumber, double balance, double annualInterestRate, Date dateCreated)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = dateCreated; 
	}

	public int getAccNum() 
	{
		return accountNumber;
	}

	public void setAccNum(int accountNumber) 
	{
		this.accountNumber = accountNumber;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}

	public double getAnnualInterestRate() 
	{
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) 
	{
		this.annualInterestRate = annualInterestRate;
	}
	
	public Date getDataCreated()
	{
		return dateCreated;
	}
	
	public double getMonthlyInterestRate()
	{
		return (getAnnualInterestRate() / 100 / 12);
	}
	
	public double getMonthlyInterest()
	{
		return (getBalance() * getMonthlyInterestRate());
	}
	
	public double withdraw(double withdraw) 
	{
		balance -= withdraw;
		return (getBalance() - withdraw);
	}
	
	public double deposit(double deposit)
	{
		balance += deposit;
		return (getBalance() + deposit);
	}
}

