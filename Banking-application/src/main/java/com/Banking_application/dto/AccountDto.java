package com.Banking_application.dto;

public class AccountDto {
	
	private Long id;
	
    private String accountHolderName;
	
	private double balance;
	
	private  String bank_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDto(Long id, String accountHolderName, double balance, String bank_name) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.bank_name = bank_name;
	}
	

}
