package com.Banking_application.service;

import java.util.List;

import com.Banking_application.dto.AccountDto;

public interface AccountService 
{
	
	abstract AccountDto createAccount(AccountDto account);
	

	 AccountDto getAccountById(Long id);
	 
	 AccountDto deposit(long id,double amount);
	 
	 AccountDto withdraw(long id,double amount);
	 
     List<AccountDto> getAllAccount();
     
     void deleteAccount(Long id);
	 
	 
	 

}
